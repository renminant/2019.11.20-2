package controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import exception.ParamErrorException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import pojo.User;
import service.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
        @Autowired
        UserDao userDao;
        @Autowired
        HttpServletRequest request;


        @RequestMapping("/loginPage.action")
        public String loginPage(){
            return "login";
        }

        //点击"登录"后
        @RequestMapping("/login.action")
        public String Login(User user, Model model) throws ParamErrorException {
            String password = user.getPassword();
            if (password.length()<3){
                throw new ParamErrorException();
            }
            HttpSession session = request.getSession();
            User loginUser = userDao.Login(user);
            if (loginUser != null){
                //重定向
                session.setAttribute("user",loginUser);
                return "redirect:frame.action";//内部转发不用redirect（直接写frame）
            }else{
                //转发
                return "login";
            }

        }

        //登录成功
        @RequestMapping("/frame.action")
        public String frame(){
            return "frame" ;
        }

        //点击"修改密码"后

        @RequestMapping("/updatePwd1.action")
        public ModelAndView updatePwd1(){
            ModelAndView mad = new ModelAndView();
            List<User> userList = userDao.getUserList(null);//调用getUserList方法
            mad.addObject("list",userList);
            mad.setViewName("updatePwd");//此时不能用redirect
            return mad;
        }


        //点击“用户管理”or"查询"后
        //点击“用户管理”or"查询"后
        @RequestMapping("/userList.action")
        public ModelAndView userList(User user,@RequestParam(required = false,defaultValue = "1",value = "page")int page){
            ModelAndView mad = new ModelAndView();
            //首先是设置第几页，第二个参数是每页的记录数
            PageHelper.startPage(page,5);
            List<User> userList = userDao.getUserList(user);//调用getUserList方法
            PageInfo pageinfo = new PageInfo(userList);
            mad.addObject("searchName",user.getName() );
            mad.addObject("pageinfo",pageinfo);
            mad.setViewName("userList");
            return mad;
        }

    //添加用户 点击"保存"后
    @RequestMapping("/registerUser.action")
//    @ResponseBody
    public ModelAndView registerUser(User user,@RequestParam(required = false,defaultValue = "1",value = "page")int page){
        ModelAndView mad = new ModelAndView();
        PageHelper.startPage(page,5);
        List<User> userList = userDao.getUserList(null);
        PageInfo pageinfo = new PageInfo(userList);
        boolean register = userDao.RegisterUser(user);//用Register进行判断
        if (register){//注册成功
            mad.addObject("pageinfo",pageinfo);
            mad.setViewName("userList");
        }else{//注册失败
            mad.setViewName("userAdd");
        }
        return mad;
    }

    //点击"用户名"后
    @RequestMapping("/selectUserViewByid.action")
    public String selectUserViewByid(Integer user_id,Model model){
        User user = userDao.getUserByid(user_id);
            if (user != null){
                model.addAttribute("user",user);
                return "userView";//回填页面数据
            }else{
                return "userList";//跳转至列表页面
            }
    }

    //点击"修改"后
    @RequestMapping("/selectUserByid.action")
    public ModelAndView selectUserByid(Integer user_id,Model model){
            ModelAndView mad = new ModelAndView();
        User user = userDao.getUserByid(user_id);
            if (user != null){
                mad.addObject("user",user);
                mad.setViewName("userUpdate");//回填页面数据
            }else{
                model.addAttribute("errorMsg","修改失败");
                mad.setViewName("userList");//跳转至列表页面
            }
            return mad;
    }

    //进入userUpdate页面 确认"修改"后
    @RequestMapping("/userUpdate.action")
    public String userUpdate(User user, MultipartFile pictureFile) throws IOException {
            String filname = UUID.randomUUID().toString().replaceAll("-","");
            String extension = FilenameUtils.getExtension(pictureFile.getOriginalFilename());
            filname = filname +"."+ extension;
            pictureFile.transferTo(new File("D:\\upload\\" + filname));
            user.setHeadpath(filname);
//            userDao.updateUser(user);
//            return "redirect:userList.action";
        boolean update =  userDao.updateUser(user);//通过updateProduct方法进行判断
        if (update){//修改成功
            return "userList";
        }else{//修改失败
            return "userUpdate";
        }
    }


    //点击"删除"后
    @RequestMapping("/deleteUser.action")
    public String deleteUser(Integer user_id){
        boolean delete = userDao.deleteUserByid(user_id);//用deleteUserByid进行判断
        return "redirect:userList.action";//跳转至列表页面
    }

//密码修改

@RequestMapping("/updatePwd2.action")
public  String  updatePwd2(User user) throws Exception {
   // Integer user_id = (Integer) request.getSession().getAttribute("user_id");
    HttpSession session = request.getSession();
    User user1 = (User) session.getAttribute("user");
    user.setUser_id(user1.getUser_id());
    int ps = userDao.modifyPs(user);
    if (ps>0){
        //重定向
        session.invalidate();
        return "login";//内部转发不用redirect（直接写frame）
    }else{
    return "updatePwd";
}

}
}



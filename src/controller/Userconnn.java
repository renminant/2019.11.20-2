package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.User;
import service.UserDao;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class Userconnn {
    @Autowired
    UserDao userDao;
    @Autowired
    HttpServletRequest request;
    @RequestMapping("/check.action")
    @ResponseBody
    public String check(String loginName){
        int i = userDao.checkUsername(loginName);
        if (i>0){
            return "用户名已被注册";
        }else {
            return "没被注册";
        }
    }
    @RequestMapping("/search.action")
    @ResponseBody
    public List<User>  search(@RequestBody User user){
        List<User> userList=userDao.getUserList(user);
        return userList;
    }

}

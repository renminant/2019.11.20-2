package mapper;


import pojo.User;

import java.util.List;

public interface UserMapper {
    public User login(User user);
    public Boolean RegisterUser(User user);
    public List<User> getUserList(User user);
    public boolean deleteUserByid(Integer user_id);
    public User getUserByid(Integer user_id);
    public int modifyPs(User user);

    public int checkUsername(String loginName);

    public boolean updateUser(User user);
}

package service;

import pojo.User;

import java.util.List;

public interface UserDao {
    public User Login(User user);
    public Boolean RegisterUser(User user);
    public List<User> getUserList(User user);

    public boolean deleteUserByid(Integer user_id);
public User getUserByid(Integer user_id);

    public int checkUsername(String loginName);

    public int modifyPs(User user);

    public boolean updateUser(User user);
}

package cn.edu.student_system.service;

import cn.edu.student_system.dao.UserDao;
import cn.edu.student_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Override
    public User Login(String userName,String password){
    return userDao.Login(userName,password);
}
}

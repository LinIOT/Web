package cn.edu.student_system.service;

import cn.edu.student_system.model.User;

public interface UserService {
    public User Login(String userName,String password);
}

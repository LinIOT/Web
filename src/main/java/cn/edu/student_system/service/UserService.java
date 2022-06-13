package cn.edu.student_system.service;

import cn.edu.student_system.mapper.UserMapper;
import cn.edu.student_system.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public int add(User user){
        return userMapper.addUser(user);

    }


    public User login(String account, String password){
        String salt_md5pwd=password+"zzuli"; //后端加盐操作
        String final_md5pwd= DigestUtils.md5DigestAsHex(salt_md5pwd.getBytes());// 最终的 MD5 密码
        System.out.println("前端传过来的MD5密码："+password);
        System.out.println("后端加密的 MD5 密码："+final_md5pwd);
        User user = userMapper.findUserByAccount(account);
        if (user == null || !final_md5pwd.equals(user.getPassword())){
            return null;
        }
        return user;


        }

    }



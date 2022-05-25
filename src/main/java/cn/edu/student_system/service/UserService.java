package cn.edu.student_system.service;

import cn.edu.student_system.mapper.UserMapper;
import cn.edu.student_system.model.User;
import cn.edu.student_system.util.GeneralResponse;
import cn.edu.student_system.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User login(String account, String password){
        User user = userMapper.findUserByAccount(account);
        if (user == null || !password.equals(user.getPassword())){
            return null;
        }
        return user;
    }

    @Transactional
    public GeneralResponse addUser(User user){
        if (userMapper.findUserByAccount(user.getAccount()) != null){
            return ResultUtils.error(404, "用户已存在");
        }
        if (!userMapper.insertUser(user)){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404, "用户注册失败");
        }
        return ResultUtils.success("注册成功");
    }

    @Transactional
    public GeneralResponse updatePassword(String account, String oldPassword, String newPassword){
        User user = userMapper.findUserByAccount(account);
        if (user == null){
            return ResultUtils.error(404, "用户不存在");
        }
        if (!user.getPassword().equals(oldPassword)){
            return ResultUtils.error(404, "密码错误");
        }
        user.setPassword(newPassword);
        if (!userMapper.updateUserPassword(user)){
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return ResultUtils.error(404, "密码修改失败");
        }
        return ResultUtils.success();
    }
}

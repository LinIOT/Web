package cn.edu.student_system.controller;

import cn.edu.student_system.model.User;
import cn.edu.student_system.service.UserService;
import cn.edu.student_system.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private static Logger log = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;
    @PostMapping("/user/add")
    public GeneralResponse add(@RequestParam("id") int id,@RequestParam("account") String account,@RequestParam("password") String password){
        log.info("账户注册已执行");
        String salt_md5pwd=password+"zzuli"; //后端加盐操作
        String final_md5pwd= DigestUtils.md5DigestAsHex(salt_md5pwd.getBytes());// 最终的 MD5 密码
        System.out.println("前端传过来的MD5密码："+password);
        System.out.println("后端加密的 MD5 密码："+final_md5pwd);
        User user=new User();
        user.setId(id);
        user.setAccount(account);
        user.setPassword(final_md5pwd);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(userService.add(user));
        return response;
    }

}

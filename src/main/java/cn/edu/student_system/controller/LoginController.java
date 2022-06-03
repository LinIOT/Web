package cn.edu.student_system.controller;
import cn.edu.student_system.model.User;
import cn.edu.student_system.service.UserService;
import cn.edu.student_system.util.GeneralResponse;
import cn.edu.student_system.util.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
public class LoginController {
    @Value("${server.port}")
    String port;
    @Autowired
    UserService userService;


    @GetMapping("/")
    public String index() {
        System.out.println("访问登录页面!");
        return "login";
    }

    @PostMapping("/login")
    public GeneralResponse login(@RequestParam("account") String account, @RequestParam("password") String password,HttpSession session) {
        User user = userService.login(account, password);
        session.setAttribute("user",user);
        if (user == null){
            return ResultUtils.error(404, "登录失败");
        }
            return ResultUtils.loginSuccess(user);

    }




}





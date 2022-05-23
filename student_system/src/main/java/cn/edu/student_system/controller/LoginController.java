package cn.edu.student_system.controller;

import cn.edu.student_system.model.User;
import cn.edu.student_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public String index(){
        return "login.html";
    }

    @PostMapping("/login")
    public ModelAndView login(HttpServletRequest request, ModelAndView mv, User user){
        String userName=request.getParameter("userName");
        String password=request.getParameter("password");
        user=userService.Login(userName,password);
       if (user!=null){
           mv.setViewName("login");
           mv.addObject("info","登陆成功");
           return mv;
       }
       mv.setViewName("login");
       mv.addObject("info","登陆失败");
       return mv;
    }
}

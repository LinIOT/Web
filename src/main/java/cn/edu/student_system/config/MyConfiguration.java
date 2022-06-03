//package cn.edu.student_system.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import cn.edu.student_system.interceptor.LoginHandlerInterceptor;
//
//@Configuration
//public class MyConfiguration implements WebMvcConfigurer {
//    @Override
//    public void addInterceptors(InterceptorRegistry registry){
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                .addPathPatterns("/**")
//                .excludePathPatterns("/login.html")
//                .excludePathPatterns("/**/*.html")
//                .excludePathPatterns("/**/*.css")
//                .excludePathPatterns("/**/*.js")
//                .excludePathPatterns("/**/*.png")
//                .excludePathPatterns("static/**");
//    }
//}

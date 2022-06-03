//package cn.edu.student_system.interceptor;
//
//import cn.edu.student_system.model.User;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.jws.soap.SOAPBinding;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//public class LoginHandlerInterceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        System.out.println("执行力拦截器的preHandle");
//        try {
//        HttpSession session=request.getSession();
//        User user=(User)session.getAttribute("user");
//        if(user!=null){
//            return true;
//        }
//            response.sendRedirect(request.getContextPath() + "/login.html");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//       return false;
//
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//        System.out.println("执行拦截器的postHandle");
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//        System.out.println("执行拦截器的afterCompletion");
//
//    }
//}

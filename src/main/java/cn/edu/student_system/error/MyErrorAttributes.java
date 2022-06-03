/*package cn.edu.student_system.error;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@Component
public class MyErrorAttributes extends DefaultErrorAttributes {
   @Override
    public Map<String,Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace){
        Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);//2.6.4版本的SP中DefaultErrorAttributes类的getErrorAttributes方法是private的无法重载
        System.out.println(errorAttributes);
        errorAttributes.put("mymsg","IOT错误");
     //   errorAttributes.remove("error");
        return errorAttributes;
    }

}*/

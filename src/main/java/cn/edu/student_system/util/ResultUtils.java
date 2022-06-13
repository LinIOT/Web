package cn.edu.student_system.util;



import cn.edu.student_system.model.User;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
    private ResultUtils() {
    }

    public static GeneralResponse loginSuccess(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("account", user.getAccount());
        GeneralResponse message = new GeneralResponse();
        message.setSuccess(true);
        message.setMessage("登录成功");
        message.setCode("200");
        message.setData(map);
        return message;
    }

    public static GeneralResponse success(Object object) {
        GeneralResponse message = new GeneralResponse();
        message.setSuccess(true);
        message.setMessage("请求成功");
        message.setCode("200");
        message.setData(object);
        return message;
    }

    public static GeneralResponse success() {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setSuccess(true);
        generalResponse.setMessage("请求成功");
        return generalResponse;
    }

    public static GeneralResponse success(String string) {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setSuccess(true);
        generalResponse .setCode("200");
        generalResponse.setMessage(string);
        return generalResponse;
    }

    public static GeneralResponse error(Integer code, String resultMessage) {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setSuccess(false);
        generalResponse.setCode(code.toString());
        generalResponse.setMessage(resultMessage);
        return generalResponse;
    }
}

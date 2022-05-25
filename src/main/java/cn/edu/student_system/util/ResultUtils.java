package cn.edu.student_system.util;



import cn.edu.student_system.model.User;

import java.util.HashMap;
import java.util.Map;

public class ResultUtils {
    private ResultUtils() {
    }

    /**
     * 登录验证成功的返回信息
     * @param user 成功登录的用户
     * @return
     */
    public static GeneralResponse loginSuccess(User user) {
        Map<String, Object> map = new HashMap<>();
        map.put("name", user.getName());
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
        GeneralResponse message = new GeneralResponse();
        message.setSuccess(true);
        message.setMessage("请求成功");
        return message;
    }

    public static GeneralResponse success(String string) {
        GeneralResponse generalResponse = new GeneralResponse();
        generalResponse.setSuccess(true);
        generalResponse .setCode("200");
        generalResponse.setMessage(string);
        return generalResponse;
    }

    public static GeneralResponse error(Integer code, String resultMessage) {
        GeneralResponse message = new GeneralResponse();
        message.setSuccess(false);
        message.setCode(code.toString());
        message.setMessage(resultMessage);
        return message;
    }
}

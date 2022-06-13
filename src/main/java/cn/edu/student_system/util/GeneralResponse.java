package cn.edu.student_system.util;


public class GeneralResponse {
    private boolean success;
    private String message;
    private Object data;
    private String code;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "GeneralResponse{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", code='" + code + '\'' +
                '}';
    }
}

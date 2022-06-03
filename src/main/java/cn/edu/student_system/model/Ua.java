package cn.edu.student_system.model;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Ua {
    @ExcelProperty("学号")
    private Integer id;
    @ExcelProperty("姓名")
    private String stuName;
    @ExcelProperty("密码")
    private String password;
    @ExcelProperty("班级")
    private String cla;
    @ExcelProperty("性别")
    private String sex;
    @ExcelProperty("图片地址")
    private String userimg;


}

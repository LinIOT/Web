package cn.edu.student_system.controller;

import cn.edu.student_system.service.StudentService;
import cn.edu.student_system.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
@RestController
public class ExcelController {
    private static Logger log = LoggerFactory.getLogger(ExcelController.class);
   @Autowired
   StudentService studentService;
    @PostMapping("/student/download")
    public GeneralResponse download(HttpServletResponse response){
        log.info("收到文件下载请求");
        return studentService.download(response);
    }
}

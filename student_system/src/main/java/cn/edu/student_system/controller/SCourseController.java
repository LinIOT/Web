package cn.edu.student_system.controller;

import cn.edu.student_system.service.SCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SCourseController {
    @Autowired
    private SCourseService sCourseService;


}

package cn.edu.student_system.controller;

import cn.edu.student_system.model.SCourse;
import cn.edu.student_system.service.SCourseService;
import cn.edu.student_system.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SCourseController {
    private static Logger log = LoggerFactory.getLogger(SCourseController.class);
    @Autowired
    private SCourseService sCourseService;
    @GetMapping("/scourses")
    public GeneralResponse SCourses(){
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(sCourseService.getAll());
        return response;
    }
    @PostMapping("/scourse/add")
    public GeneralResponse add(@RequestParam Integer cid, @RequestParam String courseName, @RequestParam String teacherName){
        log.info("课程add已执行");
        SCourse sCourse=new SCourse();
        sCourse.setCid(cid);
        sCourse.setCourseName(courseName);
        sCourse.setTeacherName(teacherName);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(sCourseService.add(sCourse));
        return response;
    }
    @PutMapping("/scourse/update")
    public GeneralResponse update(@RequestParam Integer cid, @RequestParam String courseName, @RequestParam String teacherName){
        log.info("课程update已执行");
        SCourse sCourse=new SCourse();
        sCourse.setCid(cid);
        sCourse.setCourseName(courseName);
        sCourse.setTeacherName(teacherName);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(sCourseService.update(sCourse));
        return response;
    }
    @PostMapping("/scourse/delete")
    public GeneralResponse delete(@RequestParam Integer cid){
        log.info("课程delete已执行");
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(sCourseService.deleteById(cid));
        return response;
    }
    @GetMapping("/scourse")
    public GeneralResponse courseById(@RequestParam Integer cid){
        log.info("cid查询信息已执行");
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        List<SCourse> result=new ArrayList<>();
        result.add(sCourseService.getById(cid));
        response.setData(result);
        return response;
    }

}

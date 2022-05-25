package cn.edu.student_system.controller;

import cn.edu.student_system.model.Student;
import cn.edu.student_system.service.StudentService;
import cn.edu.student_system.util.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping("/students")
    public GeneralResponse student(){
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(studentService.getAll());
        return response;
    }
    @PostMapping("/student/add")
    public GeneralResponse add(@RequestParam Integer id,@RequestParam String stuName,@RequestParam String password,@RequestParam String cla,@RequestParam String sex){
        Student student=new Student();
        student.setId(id);
        student.setStuName(stuName);
        student.setPassword(password);
        student.setCla(cla);
        student.setSex(sex);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(studentService.add(student));
        return response;
    }
    @PostMapping("/student/update")
    public GeneralResponse update(@RequestParam String stuName,@RequestParam String password,@RequestParam String cla,@RequestParam String sex){
        Student student=new Student();
        student.setStuName(stuName);
        student.setPassword(password);
        student.setCla(cla);
        student.setSex(sex);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(studentService.update(student));
        return response;
    }
    @PostMapping("/student/delete")
    public GeneralResponse delete(@RequestParam int id){
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(studentService.deleteById(id));
        return response;
    }
    @GetMapping("/student")
    public GeneralResponse userById(@RequestParam int id){
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        List<Student> result=new ArrayList<>();
        result.add(studentService.getById(id));
        response.setData(result);
        return response;
    }
}

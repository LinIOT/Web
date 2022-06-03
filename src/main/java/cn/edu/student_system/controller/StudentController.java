package cn.edu.student_system.controller;

import cn.edu.student_system.model.Student;
import cn.edu.student_system.service.StudentService;
import cn.edu.student_system.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
public class StudentController {
    private static Logger log = LoggerFactory.getLogger(StudentController.class);
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd/");
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
    public GeneralResponse add(MultipartFile uploadFile, HttpServletRequest req, @RequestParam Integer id, @RequestParam String stuName, @RequestParam String password, @RequestParam String cla, @RequestParam String sex){
        log.info("学生信息add已执行");
        Student student=new Student();
        GeneralResponse response=new GeneralResponse();
        String realPath="./uploadFile/";
        System.out.println("======"+realPath);
        String format=sdf.format(new Date());
        File folder=new File(realPath+format);
        System.out.println("======"+folder.getAbsolutePath());
        if(!folder.isDirectory()){
            folder.mkdirs();//如果不是文件夹，就创建出来
        }
        String oldName =uploadFile.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+
                oldName.substring(oldName.lastIndexOf("."),oldName.length());
        System.out.println("======="+"图片本地名："+oldName+"\t"+"随机命名："+newName);
        try{
            uploadFile.transferTo(new File(folder.getAbsolutePath(),newName));
            String filePath=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/uploadFile/"+format+newName;
            student.setId(id);
            student.setStuName(stuName);
            student.setPassword(password);
            student.setCla(cla);
            student.setSex(sex);
            student.setUserimg(filePath);
            response.setSuccess(true);
            response.setData(studentService.add(student));
            System.out.println(student.getUserimg());
            return response;
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("上传失败");
            response.setSuccess(false);
            return response;
        }
    }


    @PutMapping("/student/update")
    public GeneralResponse update(MultipartFile uploadFile, HttpServletRequest req,@RequestParam Integer id,@RequestParam String stuName,@RequestParam String password,@RequestParam String cla,@RequestParam String sex){
        Student student=new Student();
        GeneralResponse response=new GeneralResponse();
        log.info("学生信息update已执行");
        String realPath="./uploadFile/";
        System.out.println("======"+realPath);
        String format=sdf.format(new Date());
        File folder=new File(realPath+format);
        System.out.println("======"+folder.getAbsolutePath());
        if(!folder.isDirectory()){
            folder.mkdirs();//如果不是文件夹，就创建出来
        }
        String oldName =uploadFile.getOriginalFilename();
        String newName= UUID.randomUUID().toString()+
                oldName.substring(oldName.lastIndexOf("."),oldName.length());
        System.out.println("======="+"图片本地名："+oldName+"\t"+"随机命名："+newName);
        try {
            uploadFile.transferTo(new File(folder.getAbsolutePath(),newName));
            String filePath=req.getScheme()+"://"+req.getServerName()+":"+req.getServerPort()+"/uploadFile/"+format+newName;
            student.setId(id);
            student.setStuName(stuName);
            student.setPassword(password);
            student.setCla(cla);
            student.setSex(sex);
            student.setUserimg(filePath);
            response.setSuccess(true);
            System.out.println(student.getUserimg());
            response.setData(studentService.update(student));
            return response;
        }catch (IOException e){
            e.printStackTrace();
            //有时会报一个IOException null的错，报错是因为图片大小
            System.out.println("上传失败");
            response.setSuccess(false);
            return response;
        }

    }
    @PostMapping("/student/delete")
    public GeneralResponse delete(@RequestParam int id){
        log.info("学生信息删除已执行");
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(studentService.deleteById(id));
        return response;
    }
    @GetMapping("/student")
    public GeneralResponse userById(@RequestParam int id){
        log.info("查询学生信息已执行");
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        List<Student> result=new ArrayList<>();
        result.add(studentService.getById(id));
        response.setData(result);
        return response;
    }


}

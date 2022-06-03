package cn.edu.student_system.controller;

import cn.edu.student_system.model.Ua;
import cn.edu.student_system.service.UaService;
import cn.edu.student_system.util.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class AllController {
    @Autowired
    UaService uaService;
    @PostMapping("/all/add")
    public GeneralResponse add(MultipartFile file,@RequestParam int id,@RequestParam String stuName,@RequestParam String password,@RequestParam String cla,@RequestParam String sex) {
        Ua ua =new Ua();
        if (!file.isEmpty()) {
            String uploadPath = "D:\\uploadFile";
            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String OriginalFilename = file.getOriginalFilename();//获取原文件名
            String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
            //重新随机生成名字
            String filename = UUID.randomUUID().toString() + suffixName;
            File localFile = new File(uploadPath + "\\" + filename);
            try {
                file.transferTo(localFile); //把上传的文件保存至本地
                /*          *
                 *这里应该把filename保存到数据库, 供前端访问时使用*/
                ua.setId(id);
                ua.setStuName(stuName);
                ua.setPassword(password);
                ua.setCla(cla);
                ua.setSex(sex);
                ua.setUserimg(uploadPath+"\\"+filename);
                //return filename;//上传成功，返回保存的文件地址
                GeneralResponse response=new GeneralResponse();
                response.setSuccess(true);
                response.setData(uaService.add(ua));
                System.out.println(ua.getUserimg());
                return response;

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("上传失败");
                GeneralResponse response=new GeneralResponse();
                response.setSuccess(false);
                return response;
            }
        } else {
            System.out.println("文件为空");
            GeneralResponse response=new GeneralResponse();
            response.setSuccess(false);
            return response;
        }
    }

}

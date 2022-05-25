package cn.edu.student_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @PostMapping("/upload")

    public String upload(@RequestParam MultipartFile file, HttpServletRequest request){
        if(!file.isEmpty()){
            String uploadPath = "D:\\uploadFile";
            // 如果目录不存在则创建
            File uploadDir = new File(uploadPath);
            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }
            String OriginalFilename = file.getOriginalFilename();//获取原文件名
            String suffixName = OriginalFilename.substring(OriginalFilename.lastIndexOf("."));//获取文件后缀名
            //重新随机生成名字
            String filename = UUID.randomUUID().toString() +suffixName;
            File localFile = new File(uploadPath+"\\"+filename);
            try {
                file.transferTo(localFile); //把上传的文件保存至本地
                /**
                 * 这里应该把filename保存到数据库,供前端访问时使用
                 */
                return filename;//上传成功，返回保存的文件地址
            }catch (IOException e){
                e.printStackTrace();
                System.out.println("上传失败");
                return "";
            }
        }else{
            System.out.println("文件为空");
            return "";
        }
    }

}

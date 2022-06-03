package cn.edu.student_system.service;

import cn.edu.student_system.mapper.ImgMapper;
import cn.edu.student_system.model.Img;
import cn.edu.student_system.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImgService {
    @Autowired
    ImgMapper imgMapper;
    public List<Img> getAll(){
        return imgMapper.getAllImg();
    }
    public int add(Img img){
        return imgMapper.addImg(img);
    }
}

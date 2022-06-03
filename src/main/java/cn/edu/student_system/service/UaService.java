package cn.edu.student_system.service;

import cn.edu.student_system.mapper.UaMapper;
import cn.edu.student_system.model.Ua;
import cn.edu.student_system.util.GeneralResponse;
import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.util.List;

@Service
public class UaService {
    @Autowired
    UaMapper uaMapper;
    public List<Ua> getAll(){
        return uaMapper.getAllUa();
    }
    public int add(Ua ua){
        return uaMapper.addUa(ua);
    }
    public Ua getById(int id){
        return uaMapper.getById(id);
    }

    @SneakyThrows
    public GeneralResponse download(HttpServletResponse response) {
        List<Ua> houseList = uaMapper.getAllUa();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("学生信息", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Ua.class)
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())//自适应表格格式
                .sheet("模板")
                .doWrite(houseList);
        GeneralResponse generalResponse=new GeneralResponse();
        generalResponse.setMessage("下载成功");
        generalResponse.setCode("200");
        generalResponse.setSuccess(true);
        return generalResponse;
    }

    public int update(Ua ua){
        return uaMapper.updateStudent(ua);
    }

}

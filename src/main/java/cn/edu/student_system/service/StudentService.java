package cn.edu.student_system.service;

import cn.edu.student_system.mapper.StudentMapper;
import cn.edu.student_system.model.Student;
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
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
    public List<Student> getAll(){
        return studentMapper.getAll();
    }
    public int add(Student student){
        return studentMapper.addStudent(student);

    }
    public int update(Student student ){
        return studentMapper.updateStudent(student);
    }
    public int deleteById(int id){
        return studentMapper.deleteById(id);
    }
    public Student getById(int id){
        return studentMapper.getById(id);
    }

    @SneakyThrows
    public GeneralResponse download(HttpServletResponse response) {
        GeneralResponse generalResponse=new GeneralResponse();
        List<Student> studentList = studentMapper.getAll();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("学生信息", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Student.class)
                    .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())//自适应表格格式
                    .sheet("模板")
                    .doWrite(studentList);
            generalResponse.setMessage("下载成功");
            generalResponse.setCode("200");
            generalResponse.setSuccess(true);
            System.out.println(generalResponse);
            return null;

    }



}

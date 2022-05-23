package cn.edu.student_system.service;

import cn.edu.student_system.dao.StudentMapper;
import cn.edu.student_system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

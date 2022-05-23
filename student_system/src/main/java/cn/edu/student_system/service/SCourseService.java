package cn.edu.student_system.service;

import cn.edu.student_system.dao.SCourseMapper;
import cn.edu.student_system.dao.StudentMapper;
import cn.edu.student_system.model.SCourse;
import cn.edu.student_system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SCourseService {
    @Autowired
    private SCourseMapper sCourseMapper;
    public List<SCourse> getAll(){
        return sCourseMapper.getAll();
    }
    public int add(SCourse sCourse){
        return sCourseMapper.addStudent(sCourse);

    }
    public int update(SCourse sCourse ){
        return sCourseMapper.updateStudent(sCourse);
    }
    public int deleteById(int Cid){
        return sCourseMapper.deleteById(Cid);
    }
    public Student getById(int Cid){
        return sCourseMapper.getById(Cid);
    }
}

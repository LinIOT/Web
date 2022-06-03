package cn.edu.student_system.service;

import cn.edu.student_system.mapper.SCourseMapper;
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
        return sCourseMapper.getAllC();
    }
    public int add(SCourse sCourse){
        return sCourseMapper.addSCourse(sCourse);

    }
    public int update(SCourse sCourse ){
        return sCourseMapper.updateSCourse(sCourse);
    }
    public int deleteById(int cid){
        return sCourseMapper.deleteByCId(cid);
    }
    public SCourse getById(int cid){
        return sCourseMapper.getByCId(cid);
    }
}

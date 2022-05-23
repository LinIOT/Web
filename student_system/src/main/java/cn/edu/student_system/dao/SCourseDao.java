package cn.edu.student_system.dao;

import cn.edu.student_system.model.SCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public class SCourseDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int addSCourse(SCourse sCourse){
        return jdbcTemplate.update("INSERT INTO scourse(cid,courseName,teacherName) VALUES (?,?,?)",
                sCourse.getCid(),sCourse.getCourseName(),sCourse.getTeacherName());
    }
    public int updateSCourse(SCourse sCourse){
        return  jdbcTemplate.update("UPDATE scourse SET courseName=?,teacherName=? WHERE cid=?",
                sCourse.getCourseName(),sCourse.getTeacherName(),sCourse.getCid());
    }
    public int deleteByCId(Integer Cid){
        return jdbcTemplate.update("DELETE FROM scourse WHERE cid=?",Cid);

    }
    public SCourse getById(Integer Cid){
        return jdbcTemplate.queryForObject("select * from scourse where cid=?",
                new BeanPropertyRowMapper<>(SCourse.class),Cid);
    }
    public List<SCourse> getAll(){
        return jdbcTemplate.query("select * from scourse",new BeanPropertyRowMapper<>(SCourse.class));
    }
}

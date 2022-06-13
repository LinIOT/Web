package cn.edu.student_system.dao;

import cn.edu.student_system.model.SCourse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
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
    public int deleteByCId(Integer cid){
        return jdbcTemplate.update("DELETE FROM scourse WHERE cid=?",cid);

    }
    public SCourse getByCId(Integer cid){
        return jdbcTemplate.queryForObject("select * from scourse where cid=?",
                new BeanPropertyRowMapper<>(SCourse.class),cid);
    }
    public List<SCourse> getAllC(){
        return jdbcTemplate.query("select * from scourse",new BeanPropertyRowMapper<>(SCourse.class));
    }
}

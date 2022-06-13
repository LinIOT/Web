package cn.edu.student_system.dao;

import cn.edu.student_system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO student(id,stuName,password,cla,sex,userimg) VALUES (?,?,?,?,?,?)",
                student.getId(),student.getStuName(),student.getPassword(),student.getCla(),student.getSex());
    }
    public int updateStudent(Student student){
        return  jdbcTemplate.update("UPDATE student SET stuName=?,password=?,cla=?,sex=?,userimg=? WHERE id=?",
                student.getStuName(),student.getPassword(),student.getCla(),student.getSex(),student.getUserimg(),student.getId());
    }
    public int deleteById(Integer id){
        return jdbcTemplate.update("DELETE FROM student WHERE id=?",id);

    }
    public Student getById(Integer id){
        return jdbcTemplate.queryForObject("select * from student where id=?",
        new BeanPropertyRowMapper<>(Student.class),id);
    }
    public List<Student> getAll(){
        return jdbcTemplate.query("select * from student",new BeanPropertyRowMapper<>(Student.class));
    }

}

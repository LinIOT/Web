package cn.edu.student_system.dao;

import cn.edu.student_system.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@ResponseBody
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int addStudent(Student student){
        return jdbcTemplate.update("INSERT INTO student(id,name,password,cla,sex,imgURL) VALUES (?,?,?,?,?,?)",
                student.getId(),student.getName(),student.getPassword(),student.getCla(),student.getSex(),student.getImgURL());
    }
    public int updateStudent(Student student){
        return  jdbcTemplate.update("UPDATE student SET name=?,password=?,cla=?,sex=?,imgURL=? WHERE id=?",
                student.getName(),student.getPassword(),student.getCla(),student.getSex(),student.getImgURL(),student.getId());
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

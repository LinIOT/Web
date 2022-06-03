package cn.edu.student_system.dao;

import cn.edu.student_system.model.Ua;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class UaDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Ua> getAllUa(){
        return jdbcTemplate.query("select * from ua",new BeanPropertyRowMapper<>(Ua.class));
    }
    public int addUa(Ua ua){
        return jdbcTemplate.update("INSERT INTO ua(id,stuName,password,cla,sex,userimg) VALUES (?,?,?,?,?,?)",
                ua.getId(), ua.getStuName(), ua.getPassword(), ua.getCla(), ua.getSex(), ua.getUserimg());
    }
    public Ua getById(Integer id){
        return jdbcTemplate.queryForObject("select * from ua where id=?",
                new BeanPropertyRowMapper<>(Ua.class),id);
    }
    public int updateStudent(Ua ua){
        return  jdbcTemplate.update("UPDATE ua SET stuName=?,password=?,cla=?,sex=? WHERE id=?",
                ua.getStuName(),ua.getPassword(),ua.getCla(),ua.getSex(),ua.getId());
    }
}

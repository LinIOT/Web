package cn.edu.student_system.dao;

import cn.edu.student_system.model.Img;
import cn.edu.student_system.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImgDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Img> getAll(){
        return jdbcTemplate.query("select * from img",new BeanPropertyRowMapper<>(Img.class));
    }
    public int addImg(Img img){
        return jdbcTemplate.update("INSERT INTO img(sid,userimg) VALUES (?,?)",
                img.getSid(),img.getUserimg());
    }
}

package cn.edu.student_system.dao;

import cn.edu.student_system.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ScoreDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int addScore(Score score){
        return jdbcTemplate.update("INSERT INTO score(sid,cid,time,score) VALUES (?,?,?,?)",
                score.getSid(),score.getCid(),score.getTime(),score.getScore());
    }
    public int updateScore(Score score){
        return jdbcTemplate.update("UPDATE score SET cid=?,time=?,score=? WHERE sid=?",
                score.getCid(),score.getTime(),score.getScore(),score.getSid());
    }
    public int deleteScoreById(Integer sid){
        return jdbcTemplate.update("DELETE FROM score WHERE sid=?",sid);

    }
    public Score getScoreById(Integer sid){
        return jdbcTemplate.queryForObject("select * from score where sid=?",
                new BeanPropertyRowMapper<>(Score.class),sid);
    }
    public List<Score> getAll(){
        return jdbcTemplate.query("select * from score",new BeanPropertyRowMapper<>(Score.class));
    }
}

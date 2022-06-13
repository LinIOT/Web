package cn.edu.student_system.service;

import cn.edu.student_system.mapper.ScoreMapper;
import cn.edu.student_system.model.SCourse;
import cn.edu.student_system.model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScoreService {
    @Autowired
    ScoreMapper scoreMapper;
    public List<Score> getAll(){
        return scoreMapper.getAllScore();
    }
    public int add(Score score){
        return scoreMapper.addScore(score);

    }
    public int update(Score score ){
        return scoreMapper.updateScore(score);
    }
    public int deleteById(int sid){
        return scoreMapper.deleteById(sid);
    }
    public Score getById(int sid){
        return scoreMapper.getByCId(sid);
    }
}


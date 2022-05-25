package cn.edu.student_system.controller;

import cn.edu.student_system.model.SCourse;
import cn.edu.student_system.model.Score;
import cn.edu.student_system.service.SCourseService;
import cn.edu.student_system.service.ScoreService;
import cn.edu.student_system.util.GeneralResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScoreController {
    @Autowired
    ScoreService scoreService;
    @GetMapping("/scores")
    public GeneralResponse Score(){
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(scoreService.getAll());
        return response;
    }
    @PostMapping("/score/add")
    public GeneralResponse add(@RequestParam int sid, @RequestParam int cid, @RequestParam String time,@RequestParam int score){
        Score score1=new Score();
        score1.setSid(sid);
        score1.setCid(cid);
        score1.setTime(time);
        score1.setScore(score);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(scoreService.add(score1));
        return response;
    }
    @PostMapping("/score/update")
    public GeneralResponse update(@RequestParam int cid, @RequestParam String time,@RequestParam int score){
        Score score1=new Score();
        score1.setCid(cid);
        score1.setTime(time);
        score1.setScore(score);
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(scoreService.update(score1));
        return response;
    }
    @PostMapping("/score/delete")
    public GeneralResponse delete(@RequestParam int sid){
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(scoreService.deleteById(sid));
        return response;
    }
    @GetMapping("/score")
    public GeneralResponse courseById(@RequestParam int sid){
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        List<Score> result=new ArrayList<>();
        result.add(scoreService.getById(sid));
        response.setData(result);
        return response;
    }
}

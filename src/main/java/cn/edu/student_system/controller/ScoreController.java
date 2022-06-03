package cn.edu.student_system.controller;

import cn.edu.student_system.model.SCourse;
import cn.edu.student_system.model.Score;
import cn.edu.student_system.service.SCourseService;
import cn.edu.student_system.service.ScoreService;
import cn.edu.student_system.util.GeneralResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ScoreController {
    private static Logger log = LoggerFactory.getLogger(ScoreController.class);
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
        log.info("成绩add已执行");
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
    @PutMapping("/score/update")
    public GeneralResponse update(@RequestParam int sid,@RequestParam int cid, @RequestParam String time,@RequestParam int score){
        log.info("成绩更新已执行");
        Score score1=new Score();
        score1.setSid(sid);
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
        log.info("成绩记录删除已执行");
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        response.setData(scoreService.deleteById(sid));
        return response;
    }
    @GetMapping("/score")
    public GeneralResponse courseById(@RequestParam int sid){
        log.info("根据学号查询成绩已执行");
        GeneralResponse response=new GeneralResponse();
        response.setSuccess(true);
        List<Score> result=new ArrayList<>();
        result.add(scoreService.getById(sid));
        response.setData(result);
        return response;
    }
}

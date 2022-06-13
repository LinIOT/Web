package cn.edu.student_system.mapper;

import cn.edu.student_system.model.Score;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ScoreMapper {
    @Select("SELECT * FROM score")
    public List<Score> getAllScore();
    @Insert("INSERT INTO score(sid,cid,time,score) VALUES(#{sid},#{cid},#{time},#{score})")
    public int addScore(Score score);
    @Update("UPDATE score SET cid=#{cid},time=#{time},score=#{score} WHERE sid=#{sid}")
    public int updateScore(Score score);
    @Delete("DELETE FROM score WHERE sid=#{sid}")
    public int deleteById(Integer sid);
    @Select("SELECT * FROM score WHERE sid= #{sid}")
    public Score getByCId(Integer sid);
}

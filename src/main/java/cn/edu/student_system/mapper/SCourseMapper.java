package cn.edu.student_system.mapper;

import cn.edu.student_system.model.SCourse;
import cn.edu.student_system.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SCourseMapper {
    @Select("SELECT * FROM scourse")
    public List<SCourse> getAllC();
    @Insert("INSERT INTO scourse(cid,courseName,teacherName) VALUES(#{cid},#{courseName},#{teacherName})")
    public int addSCourse(SCourse sCourse);
    @Update("UPDATE scourse SET courseName=#{courseName},teacherName=#{teacherName} WHERE cid=#{cid}")
    public int updateSCourse(SCourse sCourse);
    @Delete("DELETE FROM scourse WHERE cid=#{cid}")
    public int deleteByCId(Integer cid);
    @Select("SELECT * FROM scourse WHERE cid= #{cid}")
    public SCourse getByCId(Integer cid);
}

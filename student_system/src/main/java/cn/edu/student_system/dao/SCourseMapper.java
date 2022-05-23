package cn.edu.student_system.dao;

import cn.edu.student_system.model.SCourse;
import cn.edu.student_system.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SCourseMapper {
    @Select("SELECT * FROM scourse")
    public List<SCourse> getAll();
    @Insert("INSERT INTO scourse(cid,courseName,teacherName) VALUES(#{cid},#{courseName},#{teacherName}")
    public int addStudent(SCourse sCourse);
    @Update("UPDATE scourse SET courseName=#{courseName},teacherName=#{teacherName} WHERE cid=#{cid}")
    public int updateStudent(SCourse sCourse);
    @Delete("DELETE FROM scourse WHERE cid=#{cid}")
    public int deleteById(Integer Cid);
    @Select("SELECT * FROM scourse WHERE cid= #{cid}")
    public Student getById(Integer Cid);
}

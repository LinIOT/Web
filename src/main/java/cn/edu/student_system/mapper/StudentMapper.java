package cn.edu.student_system.mapper;

import cn.edu.student_system.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    public List<Student> getAll();
    @Insert("INSERT INTO student(id,stuName,password,cla,sex,userimg) VALUES(#{id},#{stuName},#{password},#{cla},#{sex},#{userimg})")
    public int addStudent(Student student);
    @Update("UPDATE student SET stuName=#{stuName},password=#{password},cla=#{cla},sex=#{sex},userimg=#{userimg} WHERE id=#{id}")
    public int updateStudent(Student student);
    @Delete("DELETE FROM student WHERE id=#{id}")
    public int deleteById(Integer id);
    @Select("SELECT * FROM student WHERE id= #{id}")
    public Student getById(Integer id);

}

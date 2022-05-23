package cn.edu.student_system.dao;

import cn.edu.student_system.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StudentMapper {
    @Select("SELECT * FROM student")
    public List<Student> getAll();
    @Insert("INSERT INTO student(id,name,password,cla,sex,imgURL) VALUES(#{id},#{name},#{password},#{cla},#{sex}),#{imgURL}")
    public int addStudent(Student student);
    @Update("UPDATE student SET name=#{name},password=#{password},cla=#{cla},sex=#{sex},imgURL=#{imgURL} WHERE id=#{id}")
    public int updateStudent(Student student);
    @Delete("DELETE FROM student WHERE id=#{id}")
    public int deleteById(Integer id);
    @Select("SELECT * FROM student WHERE id= #{id}")
    public Student getById(Integer id);

}

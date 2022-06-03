package cn.edu.student_system.mapper;

import cn.edu.student_system.model.Ua;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface UaMapper {
    @Select("SELECT * FROM ua")
    public List<Ua> getAllUa();
    @Insert("INSERT INTO ua(id,stuName,password,cla,sex,userimg) VALUES(#{id},#{stuName},#{password},#{cla},#{sex},#{userimg})")
    public int addUa(Ua ua);
    @Select("SELECT * FROM ua WHERE id= #{id}")
    public Ua getById(Integer id);
    @Update("UPDATE ua SET stuName=#{stuName},password=#{password},cla=#{cla},sex=#{sex} WHERE id=#{id}")
    public int updateStudent(Ua ua);
}

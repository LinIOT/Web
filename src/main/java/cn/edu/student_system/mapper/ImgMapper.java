package cn.edu.student_system.mapper;

import cn.edu.student_system.model.Img;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ImgMapper {
    @Select("SELECT * FROM img")
    public List<Img> getAllImg();
    @Insert("INSERT INTO img(sid,userimg) VALUES(#{sid},#{userimg})")
    public int addImg(Img img);
}

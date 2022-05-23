package cn.edu.student_system.dao;

import cn.edu.student_system.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface UserDao {
    public User Login(@Param("userName")String userName,@Param("password")String password );
}

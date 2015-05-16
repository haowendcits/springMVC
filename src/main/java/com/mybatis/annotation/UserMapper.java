package com.mybatis.annotation;

import com.mybatis.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Administrator on 2015/5/16.
 */
public interface UserMapper {

    @Insert("insert into users(name,age) values(#{name},#{age})")
    public int insertUser(User user);

    @Delete("delete from users where id = #{id}")
    public int deleteUserById(int id);

    @Update("update users set name = #{name} , age = #{age} where id = #{id}")
    public int updateUser(User user);

    @Select("select * from users where id = #{id}")
    public User getUserById(int id);

    @Select("select * from users")
    public List<User> getAllUsers();
}

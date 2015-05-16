package com.mybatis.annotation;

import com.mybatis.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

/**
 * Created by Administrator on 2015/5/16.
 */
public class TestCRUDMapper {
    public static void main(String[] args) throws IOException {
        String resource = "conf.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession(true);
        UserMapper mapper = session.getMapper(UserMapper.class);

        User u = new User();
        u.setId(9);
        u.setAge(29);
        u.setName("chentingting");
       // mapper.insertUser(u);
      //  mapper.deleteUserById(2);
       System.out.print( mapper.getAllUsers());
//        mapper.getUserById();
      //  System.out.print( mapper.updateUser(u));
       // testUpdateUser(session);
        session.close();


    }

}

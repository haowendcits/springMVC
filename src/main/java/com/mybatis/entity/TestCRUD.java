package com.mybatis.entity;

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
public class TestCRUD {
    public static void main(String[] args) throws IOException {
        String resource = "conf.xml";
        Reader reader = Resources.getResourceAsReader(resource);
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession(true);
        String statement = "com.mybatis.entity.userMapper" + ".getUser";
        User user = session.selectOne(statement,6);
        System.out.println(user.getName());

        statement = "com.mybatis.entity.orderMapper" + ".getOrder";
        Order order = session.selectOne(statement,1);
        System.out.println(order.getOrderNo());
       // testUpdateUser(session);
        session.close();


    }
    public static void testAddUser(SqlSession session) {
        String statement = "com.mybatis.entity.userMapper" + ".addUser";
        User u = new User();
        u.setAge(56);
        u.setName("zhaoliu");
        session.insert(statement,u);

    }
    public  static void testDelUser(int id,SqlSession  session) {
        String statement = "com.mybatis.entity.userMapper" + ".deleteUser";
        session.delete(statement,id);
    }
    public static void testUpdateUser(SqlSession session) {
        String statement = "com.mybatis.entity.userMapper" + ".updateUser";
        User u = new User();
        u.setId(2);
        u.setAge(99);
        u.setName("xzxyxx");
        session.update(statement,u);
    }
    public static void getAllUsers(SqlSession session){
        String statement = "com.mybatis.entity.userMapper" + ".getAllUsers";
        List<User> list =  session.selectList(statement);

        System.out.println(list.size());

    }
}

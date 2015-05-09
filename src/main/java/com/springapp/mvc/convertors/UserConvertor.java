package com.springapp.mvc.convertors;

import com.springapp.mvc.Address;
import com.springapp.mvc.User;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/5/9.
 */
@Component
public class UserConvertor implements Converter<String,User> {

    @Override
    public User convert(String s) {
if(s != null) {
    String [] vals = s.split("-");

    if(vals != null && vals.length==4) {
        String name = vals[0];
        int age = Integer.valueOf(vals[1]);
        String province = vals[2];
        String city = vals[3];
        Address address = new Address(province,city);
        User u = new User(name,"11",age);
        u.setAddress(address);
        return u;
    }
}
        return null;
    }
}

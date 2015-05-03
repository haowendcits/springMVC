package com.springapp.mvc;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;

@RequestMapping("/world")
@Controller
public class HelloWorld {

    @RequestMapping("/good")
    public String hello() {
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(value = "/good",method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return "success";
    }

    @RequestMapping("/hello/{id}")
    public String restMethod(@PathVariable("id") String id) {
        System.out.println("id====>"+id);
        return "success";

    }

    @RequestMapping("/hello")
    public String resPosttMethod() {
        System.out.println("post");
        return "success";

    }

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.DELETE)
    public String restDeleteMethod(@PathVariable("id") String id) {
        System.out.println("delete"+id);
        return "success";

    }

    @RequestMapping(value = "/hello/{id}",method = RequestMethod.PUT)
    public String restPutMethod(@PathVariable("id") String id) {
        System.out.println("put"+id);
        return "success";

    }


    @RequestMapping(value = "/param")
    public String restPutMethod(@RequestParam("username") String name,@RequestParam(value = "age",required = false,defaultValue = "0") int age) {
        System.out.println(name+","+age);
        return "success";

    }
    @RequestMapping(value = "/testcookie")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String id) {
        System.out.println("cookie:"+id);
        return "success";

    }
    @RequestMapping(value = "/testheader")
    public String tesHeaderValue(@RequestHeader(value = "Connection") String value) {
        System.out.println("Connection:"+value);
        return "success";

    }


    @RequestMapping(value = "/testpojo")
    public String testPojo(User user) {
        System.out.println(user.getName()+user.getAddress().getProvince());
        return "success";

    }
    @RequestMapping(value = "/testservletapi")
    public void testServletAPI(HttpServletRequest req,HttpServletResponse res,Writer out) {
        System.out.println(req+","+res);
        try {
            out.write("hello spring mvc");
        } catch (IOException e) {
            e.printStackTrace();
        }
        // return "success";

    }


    @RequestMapping(value = "/testmodelandview")
    public ModelAndView testModelAndView() {
        String viewName = "success";
       ModelAndView mv = new ModelAndView(viewName);
        mv.addObject("time",new Date());
        return mv;

    }
}
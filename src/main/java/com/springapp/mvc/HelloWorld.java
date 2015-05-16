package com.springapp.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.util.*;

@SessionAttributes(value={"user"},types = {String.class})
@RequestMapping("/world")
@Controller
public class HelloWorld {

    @Autowired
    private ResourceBundleMessageSource messageSource;

    @RequestMapping("/good")
    public String hello() {
        System.out.println("hello");
        return "success";
    }

    @RequestMapping(value = "/good", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return "success";
    }

    @RequestMapping("/hello/{id}")
    public String restMethod(@PathVariable("id") String id) {
        System.out.println("id====>" + id);
        return "success";

    }

    @RequestMapping("/hello")
    public String resPosttMethod() {
        System.out.println("post");
        return "success";

    }

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.DELETE)
    public String restDeleteMethod(@PathVariable("id") String id) {
        System.out.println("delete" + id);
        return "success";

    }

    @RequestMapping(value = "/hello/{id}", method = RequestMethod.PUT)
    public String restPutMethod(@PathVariable("id") String id) {
        System.out.println("put" + id);
        return "success";

    }


    @RequestMapping(value = "/param")
    public String restPutMethod(@RequestParam("username") String name, @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println(name + "," + age);
        return "success";

    }

    @RequestMapping(value = "/testcookie")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String id) {
        System.out.println("cookie:" + id);
        return "success";

    }

    @RequestMapping(value = "/testheader")
    public String tesHeaderValue(@RequestHeader(value = "Connection") String value) {
        System.out.println("Connection:" + value);
        return "success";

    }


    @RequestMapping(value = "/testpojo")
    public String testPojo(@Valid User user,BindingResult result) {
        if(result.getErrorCount() > 0) {
            for(FieldError err :result.getFieldErrors())
                System.out.println(err.getField()+":"+err.getDefaultMessage());

            return "forward:/index.jsp";
        }
        System.out.println(user.getName() + user.getBirth()+","+user.getSalary());
        return "success";

    }

    @RequestMapping(value = "/testservletapi")
    public void testServletAPI(HttpServletRequest req, HttpServletResponse res, Writer out) {
        System.out.println(req + "," + res);
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
        mv.addObject("time", new Date());
        return mv;

    }

    @RequestMapping(value = "/testmap")
    public String testMap(Map<String, Object> map) {
        System.out.print(map.getClass().getName());
        map.put("names", Arrays.asList("Tom", "Jack", "Lucy"));
        return "success";

    }

    @RequestMapping(value = "/testsession")
    public String testSessionAttribute(Map<String, Object> map) {
        User u = new User("zhangsan", "aaa", 20);
        map.put("user", u);
        map.put("school", "ssss");
        return "success";

    }

     @ModelAttribute
    public void getUser(@RequestParam(value = "id", required = false) String id, Map<String, Object> map) {
        if (id != null) {
            User user = new User("1", "zhangsan", "12334", 23);
            map.put("user", user);
        }
    }

    @RequestMapping(value = "/testmoduleattribute")
    public String testModuleAttribute(@ModelAttribute("user") User user) {
        System.out.print(user.getPassword() + "," + user.getAge() + "," + user.getName());
        return "success";

    }

    @RequestMapping(value = "/testhelloview")
    public String testHelloView() {

        return "helloView";
    }

    @RequestMapping(value = "/testredirect")
    public String testRedirect() {
        System.out.println("redirect!!");

        return "redirect:/index.jsp";
    }

    @RequestMapping(value = "/testconversionservice")
    public String testConversionServiceConvertor(@RequestParam("user") User user) {
        System.out.println(user.getName() + user.getAddress().getCity());

        return "redirect:/world/good";
    }

    @ResponseBody
    @RequestMapping(value = "/testjson")
    public List<User> testJson(){
        List<User> list = new ArrayList<User>();
        User u = new User("1","zhangsan","21",12);
        User u2 = new User("2","lisi","12",32);
        list.add(u);
        list.add(u2);
        return list;
    }

    @ResponseBody
     @RequestMapping(value = "/testHttpMessageConvertor")
    public String testHttpMessageConvertor(@RequestBody String body){
        System.out.println(body);

        return "hello world !" + new Date();
    }


    @RequestMapping(value = "/testResponseEntity")
    public ResponseEntity<byte[]> testResponseEntity(HttpSession session) throws IOException {
        byte[] body = null;
        ServletContext ctx = session.getServletContext();
        InputStream in = ctx.getResourceAsStream("/files/123.txt");
        body = new byte[in.available()];
        in.read(body);

        HttpHeaders header = new HttpHeaders();
        header.add("Content-Disposition","attachment;filename=123.txt");
        HttpStatus status = HttpStatus.OK;
       ResponseEntity<byte[]> resp = new ResponseEntity<byte[]>(body,header,status);

        return resp;
    }


    @RequestMapping(value = "/i18n")
    public String testi18n(Locale locale) {
      String val = messageSource.getMessage("i18n.username",null,locale);
        System.out.println(val);
        return "i18n";
    }
}
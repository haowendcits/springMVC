<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2015/5/3
  Time: 21:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
  <script  src="<%=request.getContextPath()%>/js/jquery-2.1.1.min.js"></script>
<script>
  $(function(){
    $("#testjson").click(function(){
      var url = $(this).url;
      var args = {};
      $.post(url,args,function(data){
        for(var i=0;i< data.length;i++) {
          alert(data[i].name);
        }
return false;
      });

    }
    );


  });

</script>
</head>
<body>
<form action="world/good" method="post">

  <input type="submit" value="submit">
</form>

<form action="world/hello" method="post">

  <input type="submit" value="test rest post">
</form>


<form action="world/hello/1" method="post">
  <input type="hidden" name="_method" value="put">
  <input type="submit" value="test rest put">
</form>
<form action="world/hello/1" method="post">
  <input type="hidden" name="_method" value="delete">
  <input type="submit" value="test rest delete">
</form>
<a href="world/param?username=zhangsan">test request param</a>
<a href="world/testheader">test header</a>
<a href="world/testcookie">test cookie</a>


<form action="world/testpojo" method="post">

  username: <input type="text" name="name">
  password: <input type="text" name="password">
  age: <input type="text" name="age">
  province: <input type="text" name="address.province">
  city: <input type="text" name="address.city">
  birth:<input type="text" name="birth">
  salary:<input type="text" name="salary">
   <input type="submit" value="testpojo">
</form>
<a href="world/testservletapi">test servletapi</a>
<a href="world/testmodelandview">test modelandview</a>
<a href="world/testmap">test map</a>
<a href="world/testsession">test session</a><br>
<form action="world/testmoduleattribute" method="post">
  <input type="hidden" name="id" value="1">
  username: <input type="text" name="name" value="zhangsan">
  age: <input type="text" name="age" value="23">

  <input type="submit" value="testmoduleattribute">
</form>
  <br>
<a href="world/testhelloview">test hello view</a>
<a href="world/testredirect">test redirect</a>
<form action="world/testconversionservice" method="post">

  user: <input type="text" name="user" >


  <input type="submit" value="testconversionservice">
</form>
<br>
<a href="world/testjson" id="testjson">test json</a>
<br>
<form action="world/testHttpMessageConvertor" method="post" enctype="multipart/form-data">
  file:<input type="file" name="file">
  Desc:<input type="text" name="desc">


  <input type="submit" value="testHttpMessageConvertor">
</form><br>
<a href="world/testResponseEntity" >testResponseEntity</a>
<a href="world/i18n" >i18n</a>
</body>

</html>

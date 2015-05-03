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
   <input type="submit" value="testpojo">
</form>
<a href="world/testservletapi">test servletapi</a>
<a href="world/testmodelandview">test modelandview</a>
</body>
</html>

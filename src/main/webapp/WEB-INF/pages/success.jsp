<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<body>
	<h1>haha!</h1>
${time}
${names}
	requestScope.user:${requestScope.user}<br>
	sessionScope.user:${sessionScope.user}<br>

	requestScope.school:${requestScope.school}<br>
	sessionScope.school:${sessionScope.school}<br>
   <fmt:message key="i18n.username" ></fmt:message> <br>
	<fmt:message key="i18n.password" ></fmt:message> <br>
</body>
</html>

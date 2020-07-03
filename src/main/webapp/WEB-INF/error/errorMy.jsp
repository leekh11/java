<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>당신만을 위한 에러페이지</title>
</head>
<body>
	<h3>업무적으로 특별한 에러페이지가 필요한경우 해당페이지에 error-page 지정하시면 이쪽으로 옵니다</h3>
	예외 정보
	<ul>
		<li>메시지 : <%=exception.getMessage() %>
		<li>예외타입 : <%=exception.getClass().getName() %>
	</ul>
</body>
</html>
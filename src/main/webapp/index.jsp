<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>input.jsp</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css"></link>
<%@ include file="/WEB-INF/inc/header.jsp"%>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h1>방가방가</h1>

		<h4>
			<a href="cart/cart.html">장바구니</a>
			<a href="board/boardList.html">후기게시판</a>
			<a href="index.html">메인페이지</a>
			<a href="login/loginM.mg">관리자페이지</a>
			
		</h4>

	</div>
</body>
</html>
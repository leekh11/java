<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<meta charset="UTF-8">
<title>board</title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>새글쓰기</h3>

		<div>
			<h3>새글쓰기 실패</h3>
			<p>해당 제목은 이미 사용 중입니다.</p>
			<a href="#" onclick=history.go(-1) class="btn btn-warning btn-sm"> <span
				class="glyphicon glyphicon-list" aria-hidden="true"></span> 뒤로가기
			</a>
		</div>

		<a href="boardList.html" class="btn btn-default btn-sm"> <span
			class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록
		</a>
	</div>
</body>
</html>
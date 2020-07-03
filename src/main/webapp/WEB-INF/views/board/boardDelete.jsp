<%@page import="com.proj.exception.BizPasswordNotMatchedException"%>
<%@page import="com.proj.board.service.BoardServiceImpl"%>
<%@page import="com.proj.board.service.IBoardService"%>
<%@page import="com.proj.exception.BizNotEffectedException"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp"  %>
	<title>boardDelete.jsp </title>
</head>
<body>
	<h3>게시판 정보 삭제</h3>		

	<div>
		<h3>게시판정보 삭제 완료</h3>
	</div>
	
	<%
	
	} catch(Exception e) {
		%>
		<div>
			<h3>게시판정보 삭제 실패</h3>
			<p>비밀번호가 틀린 것 같습니다.</p>
			<a href="#" onclick="history.go(-1)" class="btn btn-default btn-sm">
				<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
				&nbsp;뒤로가기
			</a>
		</div>
	
	
	<a href="boardList.jsp" class="btn btn-default btn-sm">
		<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
		&nbsp;목록
	</a>
</body>
</html>
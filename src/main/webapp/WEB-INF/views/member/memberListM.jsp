<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>16/ memberList.jsp</title>

</head>
<body>
<%-- 	<%@ include file="/WEB-INF/inc/top_menu.jsp"%> --%>

	<div class="container">
		<div class="page-header">
			<h3>회원 목록</h3>
		</div>
	</div>
	<div style="width: 80vw; position: relative; left: 100px">
		<form action="memberRemove.wow" method="post">
			<button type="submit" style="position: relative; left: 0px"
				formaction="memberRemove.wow" class="btn btn-warning btn-sm">
				<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
				삭제
			</button>
			<a href="memberList.wow" class="btn btn-primary btn-sm"> <span
				class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;돌아가기
			</a>
			<table class="table table-striped  table-hover">
				<colgroup>
					<col style="width: 10%" />
					<col style="width: 10%" />
					<col />
					<col style="width: 20%" />
					<col style="width: 20%" />
				</colgroup>
				<thead>
					<tr>
						<th>ID</th>
						<th>회원명</th>
						<th>이메일</th>
						<th>전화번호</th>
						<th>삭제</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="member" items="${memberList}">
						<tr>
							<td><a href="memberView.wow?memId=${member.memId}">
									${member.memId} </a></td>
							<td>${member.memName}</td>
							<td>${member.memEmail}</td>
							<td>${member.memTel}</td>
							<td><input type="checkbox" name="memIds"
								value="${member.memId}"></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>

		</form>
		<nav class="text-center">
			<ul class="pagination">
				<mytag:paging pagingVO="${searchVO}" />
			</ul>
		</nav>
	</div>
</body>
</html>


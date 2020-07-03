<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>noticeList.jsp</title>
</head>
<body>
	<%-- 	<%@ include file="/WEB-INF/inc/top_menu.jsp"%> --%>


	<div class="container">
		<div class="page-header">
			<h3>공지</h3>
		</div>

		<div class="col-sm-2 col-sm-offset-7 text-right"
			style="margin-bottom: 5px;"></div>

		<div style="width: 70vw; position: relative; left: 0px">
			<div style="position: relative; left: -850px">
			<a href="<%=request.getContextPath()%>/manager.mg" class="btn btn-primary btn-sm"> <span
				class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;뒤로가기
			</a> <a href="noticeForm.mg" class="btn btn-primary btn-sm"> <span
				class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;공지등록
			</a>
			</div>
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
						<th>순번</th>
						<th>관리자</th>
						<th>제목</th>
						<th>등록일</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="notice" items="${noticeList}">
						<tr>
							<td>${notice.noticeNo}</td>
							<td>${notice.noticeId}</td>
							<td><a href="noticeView.mg?no=${notice.noticeNo}">
									${notice.noticeTitle} </a></td>
							<td>${notice.noticeRegDate}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<nav class="text-center">
				<ul class="pagination">
					<mytag:paging pagingVO="${vo}" />
				</ul>
			</nav>
		</div>
	</div>
</body>
</html>


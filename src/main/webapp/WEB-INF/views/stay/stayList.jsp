<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>stayList.jsp</title>
</head>
<body>
	<%-- 	<%@ include file="/WEB-INF/inc/top_menu.jsp"%> --%>


	<div class="container">
		<div class="page-header">
			<h3>숙박</h3>
		</div>

		<div class="col-sm-2 col-sm-offset-7 text-right"
			style="margin-bottom: 5px;"></div>

		<div style="width: 70vw; position: relative; left: 0px">
			<div style="position: relative; left: -850px">
			<a href="<%=request.getContextPath()%>" class="btn btn-primary btn-sm"> <span
				class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;뒤로가기
			</a> <a href="noticeForm.mg" class="btn btn-primary btn-sm"> <span
				class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;등록
			</a>
			</div>
			<table class="table table-striped  table-hover">
				<colgroup>
					<col style="width: 15%" />
					<col style="width: 30%" />
					<col style="width: 15%" />
					<col style="width: 30%"/>
					<col style="width: 15%" />
				</colgroup>
				<thead>
					<tr>
						<th>순번</th>
						<th>이미지</th>
						<th>지역</th>
						<th>이름</th>
						<th>조회수</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stay" items="${stayList}">
						<tr>
							<td>${stay.no}</td>
							<td><img src="${stay.imageUrl}" alt="" width=100  height=100></td>
							<td>${stay.areaNm}</td>
							<td><a href="stayView.mg?no=${stay.no}">
									${stay.name} </a></td>
							<td>${stay.hit}</td>
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

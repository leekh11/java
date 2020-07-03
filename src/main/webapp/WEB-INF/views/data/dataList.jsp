<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="mytag" tagdir="/WEB-INF/tags"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>exprList.jsp</title>
</head>
<body>
	<%-- 	<%@ include file="/WEB-INF/inc/top_menu.jsp"%> --%>


	<div class="container">
		<div class="page-header">
			<h3>데이터 리스트</h3>
			<a href="<%=request.getContextPath()%>"
					class="btn btn-primary btn-sm" style="position: relative; left: 60vw; margin: 10px auto; font-size: 1em">뒤로가기
			</a>
		</div>
		<div style="width: 80vw; position: relative; left: 0px">
			<div style="position: relative; left: -850px">

			</div>
		</div>	
	</div>
	
		<div style="position: relative; width: 80vw; text-align: center; left: 0; margin: 0 auto;">
			<div style="width: 15vw; display: inline-block;" >
				<table class="table table-striped table-hover"
					style="text-align: center">
					<colgroup>
						<col />
						<%-- <col style="width: 70%" /> --%>
					</colgroup>
				<thead>
					<tr>
						<th style="text-align: center;">체험</th>
					</tr>
				</thead> 
					<tbody>
						<c:forEach var="expr" items="${exprList}">
							<tr>
								<c:if test="${empty expr.imageUrl}">
									<td>
										<img src="<%=request.getContextPath()%>/images/11.png" width=100 height=100
										onclick="window.open('<%=request.getContextPath()%>/expr/exprView.mg?no=${expr.no}', 'tour' , 'width=800, height=800')">
										<br> ${expr.name}
									</td>
								</c:if>
								<c:if test="${not empty expr.imageUrl}">
									<td>
										<img src="${expr.imageUrl }" width=100
										height=100
										onclick="window.open('<%=request.getContextPath()%>/expr/exprView.mg?no=${expr.no}', 'tour' , 'width=800, height=800')">
										<br>${expr.name}	
									</td>

								</c:if>
								<%-- 							<td>${expr.name}</td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center">
					<a href="<%=request.getContextPath()%>/expr/exprList.mg">더보기>></a>
				</nav>
			</div>
			
			<div style="width: 15vw; display: inline-block;">
				<table class="table table-striped table-hover"
					style="text-align: center">
					<colgroup>
						<col />
						<%-- <col style="width: 70%" /> --%>
					</colgroup>
				<thead>
					<tr>
						<th style="text-align: center;">축제</th>
					</tr>
				</thead> 
					<tbody>
						<c:forEach var="festival" items="${festivalList}">
							<tr>
								<c:if test="${empty festival.imageUrl}">
									<td><img
										src="<%=request.getContextPath()%>/images/11.png" width=100
										height=100
										onclick="window.open('<%=request.getContextPath()%>festivalView.mg?no=${festival.no}', 'tour' , 'width=800, height=800')">
										<br>${festival.name}
									</td>
								</c:if>
								<c:if test="${not empty festival.imageUrl}">
									<td><img src="${festival.imageUrl }" width=100
										height=100
										onclick="window.open('exprView.mg?no=${festival.no}', 'tour' , 'width=800, height=800')">
										<br>${festival.name}
									</td>

								</c:if>
								<%-- 							<td>${expr.name}</td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center">
					<a href="<%=request.getContextPath()%>/festival/festivalList.mg">더보기>></a>
				</nav>
			</div>
			
			<div style="width: 15vw; display: inline-block">
				<table class="table table-striped table-hover"
					style="text-align: center">
					<colgroup>
						<col />
						<%-- <col style="width: 70%" /> --%>
					</colgroup>
				<thead>
					<tr>
						<th style="text-align: center;">맛집</th>
					</tr>
				</thead> 
					<tbody>
						<c:forEach var="food" items="${foodList}">
							<tr>
								<c:if test="${empty food.imageUrl}">
									<td>
									<img
										src="<%=request.getContextPath()%>/images/11.png" width=100
										height=100
										onclick="window.open('exprView.mg?no=${food.no}', 'tour' , 'width=800, height=800')">
										<br>${food.name} 
									</td>
								</c:if>
								<c:if test="${not empty food.imageUrl}">
									<td>
										<img src="${food.imageUrl }" width=100
										height=100
										onclick="window.open('<%=request.getContextPath()%>foodView.mg?no=${food.no}', 'tour' , 'width=800, height=800')">
										<br>${food.name} 
									</td>

								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center">
					<a href="<%=request.getContextPath()%>/food/foodList.mg">더보기>></a>
				</nav>
			</div>
			
						<div style="width: 15vw; display: inline-block;">
				<table class="table table-striped table-hover"
					style="text-align: center">
					<colgroup>
						<col />
						<%-- <col style="width: 70%" /> --%>
					</colgroup>
				<thead>
					<tr>
						<th style="text-align: center;">명소</th>
					</tr>
				</thead> 
					<tbody>
						<c:forEach var="place" items="${placeList}">
							<tr>
								<c:if test="${empty place.imageUrl}">
									<td><img
										src="<%=request.getContextPath()%>/images/11.png" width=100
										height=100
										onclick="window.open('<%=request.getContextPath()%>placeView.mg?no=${place.no}', 'tour' , 'width=800, height=800')">
										<br>${place.name}
								</td>
								</c:if>
								<c:if test="${not empty place.imageUrl}">
									<td><img src="${place.imageUrl }" width=100 height=100
										onclick="window.open('placeView.mg?no=${expr.no}', 'tour' , 'width=800, height=800')">
										<br>${place.name}
									</td>

								</c:if>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center">
					<a href="<%=request.getContextPath()%>/place/placeList.mg">더보기>></a>
				</nav>
			</div>
			
						<div style="width: 15vw; display: inline-block;">
				<table class="table table-striped table-hover"
					style="text-align: center">
					<colgroup>
						<col />
						<%-- <col style="width: 70%" /> --%>
					</colgroup>
				<thead>
					<tr>
						<th style="text-align: center;">숙박</th>
					</tr>
				</thead> 
					<tbody>
						<c:forEach var="stay" items="${stayList}">
							<tr>
								<c:if test="${empty stay.imageUrl}">
									<td><img
										src="<%=request.getContextPath()%>/images/11.png" width=100
										height=100
										onclick="window.open('<%=request.getContextPath()%>/stayView.mg?no=${stay.no}', 'tour' , 'width=800, height=800')">
										<br>${stay.name}
										</td>
								</c:if>
								<c:if test="${not empty stay.imageUrl}">
									<td><img src="${stay.imageUrl }" width=100 height=100
										onclick="window.open('stayView.mg?no=${stay.no}', 'tour' , 'width=800, height=800')">
										<br>${stay.name}
									</td>

								</c:if>
								<%-- 							<td>${expr.name}</td> --%>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<nav class="text-center">
					<a href="<%=request.getContextPath()%>/stay/stayList.mg">더보기>></a>
				</nav>
			</div>
		</div>
	

</body>
</html>


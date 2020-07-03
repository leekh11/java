
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp"  %>
	<title>boardEdit.jsp </title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp" %>
 <div class="container">	
	<h3>게사판 정보 수정</h3>		


	<form action="boardModify.html" method="post">
	<input type="hidden" name="boNum" value="${board.boNum }">
	<table class="table table-striped table-bordered">
	<colgroup>
		<col style="width:20%;"/>
		<col />
	</colgroup>
		<tbody>
			<tr>
				<th>제목</th>
				<td><input type="text" name="boTitle" value="${board.boTitle }" class="form-control input-sm">
				<form:errors path="board.boTitle"/>
				</td>
				
			</tr>

			<tr>
				<th>내용</th>
				<td><textarea name="boContent" rows="" cols="" class="form-control input-sm">${board.boContent }</textarea>
				</td>
			</tr>		
			
			<tr>
				<th>조회수</th>
				<td><input type="text" name="boHit" value="${board.boHit }" class="form-control input-sm"></td>
			</tr>	
				
			<tr>
				<td colspan="2">
					<a href="boardList.html" class="btn btn-default btn-sm">
						<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
						&nbsp;목록
					</a>
					<button type="submit" formaction="boardDelete.html" class="btn btn-danger btn-sm">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						&nbsp;삭제
					</button>
					<button type="submit" formaction="boardModify.html" class="btn btn-primary btn-sm">
						<span class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
						&nbsp;수정
					</button>
				</td>
			</tr>
		</tbody>	
	</table>
	</form>
</div>
	
</body>
</html>
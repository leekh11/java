<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>exprForm.jsp</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>체험작성</h3>
		<form name="frm_member" action="exprRegist.mg" method="post">
			<table class="table table-striped table-bordered">
				<tbody>
					<tr>
						<th>순번</th>
						<td><input type="text" name="no"></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<th>주소</th>
						<td><input type="text" name="add1">
							<input type="text" name="add2">
						</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>
							<textarea rows="" cols="" name="content"></textarea>
						</td>
					</tr>
					<tr>
						<th>좌표</th>
						<td>
							<input type="text" name="mapx">
							<input type="text" name="mapy">
						</td>
					</tr>
					<tr>
						<td colspan="2">
							<div class="pull-left">
								<a href="noticeList.mg" class="btn btn-sm btn-default">목록으로</a>
							</div>
							<div class="pull-right">
								<a href="noticeEdit.mg?no=${notice.noticeNo}"
									class="btn btn-success btn-sm"> <span
									class="glyphicon glyphicon-pencil" aria-hidden="true"></span>
									수정
								</a>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
	</form>
</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<meta charset="UTF-8">
<title>noticeView</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>공지 정보</h3>
		<form action="noticeRegist.mg" method="post">
			<table class="table table-striped table-bordered">
				<tbody>
					<tr>
						<th>공지 번호</th>
						<td>${notice.noticeNo}</td>
					</tr>
					<tr>
						<th>관리자</th>
						<td>${notice.noticeId}</td>
					</tr>
					<tr>
						<th>공지 제목</th>
						<td>${notice.noticeTitle}</td>
					</tr>
					<tr>
						<th>등록일</th>
						<td>${notice.noticeRegDate}</td>
					</tr>
					<tr>
						<th>내용</th>
						<td>${notice.noticeContent}</td>
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
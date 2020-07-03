<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/inc/header.jsp"%>
<title>noticeEdit.jsp</title>
</head>
<body>
	<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
	<div class="container">
		<h3>공지작성</h3>
		<form name="frm_notice" action="noticeModify.mg" method="post" enctype="multipart/form-data">
			<input type="hidden" name="noticeNo" value="${notice.noticeNo}">
			<table class="table table-striped table-bordered">
				<tbody>
				<colgroup>
					<col width="20%" />
					<col />
				<tr>
					<th>관리자 이름</th>
					<td><input type="text" value="${notice.noticeId}"
						name="noticeId" class="form-control input-sm" /></td>
				</tr>
				<tr>
					<th>공지 제목</th>
					<td><input type="text" value="${notice.noticeTitle}"
						name="noticeTitle" class="form-control input-sm" /></td>
				</tr>
				<tr>
					<th>내용</th>
					<td><textarea rows="3" name="noticeContent"
							class="form-control">${notice.noticeContent}</textarea></td>
				</tr>
				<tr>
					<td><a href="noticeList.mg" class="btn btn-default btn-sm">
							<span class="glyphicon glyphicon-list" aria-hidden="true"></span>
							목록으로
					</a></td>
					<td>
						<button type="submit" formaction="noticeRemove.mg"
							class="btn btn-danger btn-sm">
							<span class="glyphicon glyphicon-delete" aria-hidden="true"></span>
							&nbsp;삭제
						</button>
						<button type="submit" formaction="noticeModify.mg"
							class="btn btn-primary btn-sm">
							<span class="glyphicon glyphicon-save" aria-hidden="true"></span>
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

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp"%>
<title>글 등록</title>
<script type="text/javascript">

	$(document).ready(function() {
		//closest : 상위에서 가장 가까운 것 검색
		//find : 하위검색
		
		//추가버튼 클릭
		$('#id_btn_new_file').click(function(){
			$('.file_area').append('<div class="form-inline">'
				+ '<input type="file" name="boFiles" class="form-control">'
				+ ' <button type="button" class="btn_delete btn btn-sm">삭제</button>'
				+ '</div>');
		});	// id_btn_new_file.click
		
		// 삭제버튼 클릭
		$('.file_area').on('click','.btn_delete', function(){
		$(this).closest('div').remove();
		});	// btn_delete.click
	});	// ready

</script>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp" %>

<div class="container">
	<div class="page-header">
		<h3>글 등록</h3>
	</div>
	<div class="row" >
	
	
	<form:form modelAttribute="board" action="boardRegist.html" method="post" enctype="multipart/form-data">
	
	<input type="hidden" name="boId" value="${board.boId }">
	<table class="table table-striped table-bordered ">
		<colgroup>
			<col width="20%" />
			<col/>
		</colgroup>
		
		<tr>
			<th>테마</th>
			<td>
				<select name="boTheme" class="form-control input-sm">
						<option value="">-- 테마 선택 --</option>
						<c:forEach items="${themeList }" var="code">
						<option value="${code.boCode }">${code.boNm }</option>
						</c:forEach>	
				</select>
			</td>
		</tr>
		
		<tr>
			<th>지역</th>
			<td>
				<select name="boArea" class="form-control input-sm">
						<option value="">-- 지역 선택 --</option>
						<c:forEach items="${areaList }" var="code">
						<option value="${code.boCode }">${code.boNm }</option>
						</c:forEach>	
				</select>	
			</td>
		</tr>
		<tr>
			<th>제목</th>
			<td><form:input path="boTitle" cssClass="form-control"/>
				<form:errors path="boTitle"/>
			</td>
		</tr>

		<tr>
			<th>내용</th>
			<td><form:textarea path="boContent" rows="3" cssClass="form-control"/>
			</td>
		</tr>
		
		
		
		<tr>
			<th>첨부파일
				<button type="button" id="id_btn_new_file">추가</button>
			</th>
			<td class="file_area">
				<div class="form-inline">
					<input type="file" name="boFiles" class="form-control">
					<button type="button" class="btn_delete btn btn-sm">삭제</button>
				</div>

			</td>
		</tr>
		
		
		<tr>
			<td colspan="2">
					<div class="pull-left">
						<a href="boardList.html" class="btn btn-sm btn-default">목록으로</a>
					</div>
					<div class="pull-right">
						<button type="submit" class="btn btn-sm btn-primary">저장하기</button>
					</div>
			</td>
		</tr>
	</table>
	</form:form>
	</div>
	
</div>
</body>
</html>



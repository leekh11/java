<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/inc/header.jsp"  %>
	<title>17/ memberEdit.jsp </title>
</head>
<body>
<%@ include file="/WEB-INF/inc/top_menu.jsp"%>
 <div class="container">	
	<h3>회원가입</h3>		
<script type="text/javascript">
/* 	$(document).ready(function() {
		$('form[name=frm_member]').submit(function(e) {
			$f = $(this);
			e.preventDefault();
			if(!/^\w{6,12$}/.test($f.find('[name=memId]').val() ) ){
				console.log(  !/^\w{6,12$}/.test($f.find('[name=memId]').val() )  );
				alert("아이디는 6~12글자로 해주세요!");
				return;
			}
			if(!/^\w{6,12$}/.test($f.find('[name=memPass]').val() ) ){
				alert("비밀번호는 6~12글자로 해주세요!");
				return;
			}
			if(!/^[가-힣]{2,5}$/.test($f.find('[name=memName]').val() ) ){
				alert("올바른 이름 형식이 아니다!");
				return;
			}
			if(!/^/.test($f.find('[name=memMail]').val() ) ){
				alert("올바른 이메일 형식이 아닙니다.!");
				return;
			}
			alert("검증성공");
			return true;
			$f.submit();
		});
	}); */
</script>
	<form name="frm_member" action="memberRegist.wow" method="post">
	<table class="table table-striped table-bordered">
		<tbody>
			<tr>
				<th>아이디</th>
				<td><input type="text" name="memId" pattern="^\w{6,12}$" required="required"  class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td><input type="password" name="memPass" pattern="\w{4,12}" required="required"  class="form-control input-sm" ></td>
			</tr>
			<tr>
				<th>회원명</th>
				<td><input type="text" name="memName" pattern="[가-힣]{2,5}" required="required" class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<select name="memSb" class="form-control input-sm">
						<option value="F">여자</option>
						<option value="M">남자</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>생일</th>
				<td><input type="date" name="memBir" class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>헨드폰</th>
				<td><input type="tel" name="memTel" class="form-control input-sm"></td>
			</tr>
			<tr>
				<th>메일</th>
				<td><input type="tel" name="memEmail" pattern="[\w.]+@\w+(\.\w+){1,4}" required="required" class="form-control input-sm"></td>
			</tr>			
			<tr>
				<td><a href="memberList.wow"
							class="btn btn-default btn-sm"> <span
								class="glyphicon glyphicon-list" aria-hidden="true"></span> 목록</a></td>
				<td><button type="submit" class="btn btn-primary btn-sm">회원가입</button></td>
			</tr>
		</tbody>	
	</table>
	</form>
</div>
</body>
</html>
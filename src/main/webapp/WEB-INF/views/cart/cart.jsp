<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="next" tagdir="/WEB-INF/tags/next" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp" %>
<title>장바구니 목록</title>
<script>
	 $(document).ready(function() {
		// 폼 변수
		var f = document.forms['frm_search'];
		
		// 폼 서브밋 처리
		function fn_submit() {
			f.submit();
		}
				
		// 초기화 버튼 클릭
		$("#id_btn_reset").click(function() {
			f.curPage.value = 1;
			f.searchWord.value = "";
			// TODO : select 박스의 첫번째 option 선택
			f.searchType.options[0].selected = true;
			f.searchCategory.options[0].selected = true;
		});
		
		// 만들기 버튼 클릭
		$("#id_btn_make").click(function() {
			f.curPage.value = 1;
			f.searchWord.value = "";
			// TODO : select 박스의 첫번째 option 선택
			f.searchType.options[0].selected = true;
			f.searchCategory.options[0].selected = true;
		});
		
	// 검색 버튼 클릭
// 		$("form[name=frm_search]").submit(function(e) {
// 			e.preventDefault();
// 			f.areaCode.value = '서울';
// 			f.submit();
// 		}); 
		
	}); 
	
</script>
</head>
<%@ include file="/WEB-INF/inc/top_menu.jsp" %>

<div class="container">
	<div class="page-header">
		<h3><a href="cart.html">장바구니</a></h3>
	</div>
<div class="panel panel-default">
	<div class="panel-body">
		<form name="frm_search" action="cart.html" method="get" class="form-horizontal">
          <div class="form-group">
            <label for="id_areaCode" class="col-sm-2 col-sm-offset-2 control-label">지역</label>
            <div class="col-sm-2">
                <select id="id_areaCode" name="areaCode" class="form-control input-sm">
                    <option value=""> 전체 </option>
                    <c:forEach items="${areaList}" var="area">
                        <option value="${area.areaCode}" >${area.areaName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="col-sm-1 text-right" >
                <button type="submit" class="btn btn-sm btn-primary ">
                    <i class="fa fa-search"></i>
                    &nbsp;&nbsp;검 색
                </button>
            </div>
          </div>
		</form>
	</div>
</div>	
	<div class="form-group">
		<div class="col-sm-3 form-inline" style="margin-bottom: 5px;" >
	        전체 ${count } 건 조회
		</div>
		<div class="col-sm-1 col-sm-offset-6 ">
			 <button type="button" id="id_btn_reset" class="btn btn-sm btn-default ">
	          <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	          &nbsp;&nbsp;선택삭제
	      </button>
		</div>
		<div class="col-sm-1 text-right" >
		    <button type="button" id="id_btn_make" class="btn btn-sm btn-primary ">
		        <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
		        &nbsp;&nbsp;경로만들기
		    </button>
		</div>
	</div>
	
<div class="row">
    
<%-- 
<!-- <div class="row"> -->
<!--     <div class="col-sm-3 form-inline" style="margin-bottom: 5px;" > -->
        전체 ${searchVO.totalRowCount } 건 조회
<!--         <select id="id_rowSizePerPage" name="rowSizePerPage" class="form-control input-sm" > -->
            <option value="10" ${searchVO.rowSizePerPage == 10 ? "selected":"" } >10</option>
            <option value="20" ${searchVO.rowSizePerPage == 20 ? "selected":"" } >20</option>
            <option value="30" ${searchVO.rowSizePerPage == 30 ? "selected":"" } >30</option>
            <option value="50" ${searchVO.rowSizePerPage == 50 ? "selected":"" } >50</option>
<!--         </select> -->
<!--         <button type="button" id="id_btn_rowsize" class="btn btn-sm btn-default "> -->
<!--                &nbsp;&nbsp;선택 -->
<!--                <i class="fa fa-check"></i> -->
<!--         </button> -->
<!--     </div> -->
<!--     <div class="col-sm-2 col-sm-offset-7 text-right" style="margin-bottom: 5px;" > -->
<!--         <a href="freeForm.wow" class="btn btn-sm btn-default" >글쓰기</a> -->
<!--     </div> -->
<!-- </div> --> 
--%>




	<table class="grid table table-striped table-bordered table-hover">
	<colgroup>
		<col width="10%" />
		<col width="5%" />
		<col width="30%" />
		<col width="35%" />
		<col />
		<col width="5%" />
 	</colgroup>
	<thead>
		<tr>
			<th>구분</th>
			<th>번호</th>
			<th>이름</th>
			<th>주소</th>
			<th>이미지</th>
			<th></th>
		</tr>
	</thead>	
	<tbody>

	<c:forEach var="cart" items="${cartList }" >
		<tr class="text-center">
			<td>${cart.tableName }</td>
			<td>${cart.tableNo }</td>
			<td>${cart.name }</td>
			<td>${cart.addr }</td>
			<c:if test="${empty cart.image}">
				<td><img src="<%=request.getContextPath()%>/images/1.png" width=100 height=100 > </td>			
			</c:if>
			<c:if test="${not empty cart.image}">
				<td><img src="${cart.image }" width=100 height=100 > </td>
			
			</c:if>
			<td>
				<input type="checkbox">
			</td>
		</tr>
	</c:forEach>
	</tbody>
	</table>

	<div class="form-group">
		<div class="col-sm-1 col-sm-offset-9 ">
			 <button type="button" id="id_btn_reset" class="btn btn-sm btn-default ">
	          <span class="glyphicon glyphicon-trash" aria-hidden="true"></span>
	          &nbsp;&nbsp;선택삭제
	      </button>
		</div>
		<div class="col-sm-1 text-right" >
		    <button type="button" id="id_btn_make" class="btn btn-sm btn-primary ">
		        <span class="glyphicon glyphicon-map-marker" aria-hidden="true"></span>
		        &nbsp;&nbsp;경로만들기
		    </button>
		</div>
	</div>



	<nav class="text-center">
<%-- 		<next:paging pagingVO="${searchVO }" linkPage="cart.wow" /> --%>
	</nav>
	</div>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="mytag" tagdir="/WEB-INF/tags"%>

<!DOCTYPE html>
<html lang="ko">
<head>
<%@include file="/WEB-INF/inc/header.jsp" %> 
<title>관리자용</title>
</head>
<body>


<%-- <%@ include file="/WEB-INF/inc/top_menu.jsp" %> --%>
<div class="container">
	<div class="page-header">
		<h3>후기게시판 (관리자용) </h3>
	</div>
	
	<!--  조회목록 위의 검색영역 생성 -->
	<div class="panel panel-default">
	  <div class="panel-body">
	    <form name="frm_search" action="boardList.html" method="get" class="form-horizontal">
	        <input type="hidden" name="curPage" value="${boardVO.curPage }">
	        <input type="hidden" name="rowSizePerPage" value="${boardVO.rowSizePerPage }">
	          <div class="form-group">
	            <label for="id_searchType" class="col-sm-2 control-label">검색</label>
	            <div class="col-sm-2">
	                <select id="id_searchType" name="searchType" class="form-control input-sm">			    		
	                    <option value="T" ${boardVO.searchType eq 'T' ? 'selected="selected"' : ''}>제목</option>
	                    <option value="ID" ${boardVO.searchType eq 'ID' ? 'selected="selected"' : ''}>ID</option>
	                    <option value="A" ${boardVO.searchType eq 'A' ? 'selected="selected"' : ''}>지역</option>
	                    <option value="TH" ${boardVO.searchType eq 'TH' ? 'selected="selected"' : ''}>테마</option>
	                </select>
	            </div>
	            <div class="col-sm-2">	
	              <input type="text" name="searchWord" class="form-control input-sm" 
	              		  value="${boardVO.searchWord }" placeholder="검색어" >			      
	            </div>

	          </div>
	          <div class="form-group">
	          	<div class="col-sm-2 col-sm-offset-9 text-right">
	          		<button type="button" id="id_btn_reset" class="btn btn-sm btn-default ">
	                    <i class="fa fa-sync fa-rotate-180"></i>
	                    &nbsp;&nbsp;초기화
	                </button>
	          	</div>
	            <div class="col-sm-1 text-right" >
	                <button type="submit" class="btn btn-sm btn-primary ">
	                    <i class="fa fa-search fa-spin"></i>
	                    &nbsp;&nbsp;검 색
	                </button>
	            </div>
	          </div>
	         </form>
	  </div>
	</div>	
	
	<div class="row">
	    <div class="col-sm-3 form-inline" style="margin-bottom: 5px;" >
	        전체 ${boardVO.totalRowCount} 건 조회
	        <select id="id_rowSizePerPage" name="rowSizePerPage" class="form-control input-sm" >
	            <option value="10" ${boardVO.rowSizePerPage == 10 ?'selected="selected"' : ''} >10</option>
	            <option value="20" ${boardVO.rowSizePerPage == 20 ?'selected="selected"' : ''} >20</option>
	            <option value="30" ${boardVO.rowSizePerPage == 30 ?'selected="selected"' : ''} >30</option>
	            <option value="50" ${boardVO.rowSizePerPage == 50 ?'selected="selected"' : ''} >50</option>
	        </select>
	        <button type="button" id="id_btn_rowsize_change" class="btn btn-sm btn-default ">
               <i class="fa fa-check"></i>
               &nbsp;&nbsp;선택
           </button>
	    </div>
	    <div class="col-sm-2 col-sm-offset-7 text-right" style="margin-bottom: 5px;" >
	        <a href="boardForm.html" class="btn btn-sm btn-default btn-sm btn-primary" >
	        	<span class="glyphicon glyphicon-plus" aria-hidden="true"></span>&nbsp;새글쓰기</a>
	    </div>
	</div>
	
	<form action="boardRemove.mg" method="post">
		<button type="submit" style="position: relative; left: 0px" class="btn btn-warning btn-sm">
		<span class="glyphicon glyphicon-trash" aria-hidden="true"></span>삭제</button>
		<a href="<%=request.getContextPath()%>/manager.mg" class="btn btn-primary btn-sm"> <span
		   class="glyphicon glyphicon-plus-sign" aria-hidden="true"></span>&nbsp;돌아가기
		</a>
	<table class="grid table table-striped table-bordered table-hover">
	<colgroup>
		<col width="7%" />
		<col width="10%" />
		<col width="10%" />
		<col width="30%" />
		<col width="10%" />
		<col width="20%" />
		<col width="20%" />
		<col width="5%" />
	</colgroup>
	<thead>
		<tr>
			<th>글번호</th>
			<th>테마</th>
			<th>지역</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
			<th>check</th>
		</tr>
	</thead>	
	<tbody>
		<c:forEach var="board" items="${boardList}">
			<tr class="text-center">
				<td>${board.boNum}</td>
				<td>${board.boThemeNm}</td>
				<td>${board.boAreaNm}</td>
				<td class="text-left">
					<a href="boardView.html?boNum=${board.boNum}">${board.boTitle} </a>
					<c:forEach var="f" items="${board.attaches}">
						<a href="<c:url value='/attach/download/${f.atchNo}' />" 
						   target="_blank"
						   title="${f.atchOriginalName}">
							 <span class="glyphicon glyphicon-save" aria-hidden="true"></span>
						</a>
					</c:forEach>
				</td>

				<td>${board.boId}</td>
				<td>${board.boRegDate}</td>
				<td>${board.boHit}</td>
				<td><input type="checkbox" name="boNos"
								value="${board.boNum}"> </td>
				</tr>
		</c:forEach>
	</tbody>
	</table>
	</form>




	
	 <!-- 조회목록 아래의 페이지네이션  생성 (페이징)-->
	 
	 
	 <nav class="text-center">
	 <mytag:paging pagingVO="${boardVO }"/>

	</nav> 
		
	
	
</div>
</body>
</html>





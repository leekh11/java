<%@tag import="org.apache.commons.lang3.StringUtils"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="pagingVO" type="com.proj.common.vo.PagingVO" required="true" %>
<%@ attribute name="linkPage" %>

<%-- linkPage = "http://xxx" -> 그대로쓰기
     linkPage = "freeList.jsp" -> 그대로쓰기 (이거함)
     linkPage = "/free/freeList.jsp" -> contextPath 추가 
     --%>



<%-- <c:if test="${fn:startsWith(linkPage, '/'}">
 <c:set var="linkPage" value="${pageContext.request.contextPath}${linkPage}"></c:set>
</c:if> --%>
	<ul class="pagination">
	    <!-- 이전 페이지 firstPage>1--><!-- if문 -->
	    <c:if test="${pagingVO.startPage>1}">
	    <li>
	    	<a href="${linkPage}curPage=${pagingVO.startPage-1}" data-page="${pagingVO.startPage-1}" ><span aria-hidden="true">&laquo;</span>
	    	</a>
	    </li>
    	 </c:if>
	
	    <!-- 페이지 넘버링  --><!-- foreach -->
	    <c:forEach begin="${pagingVO.startPage}" end="${pagingVO.endPage}" var="i">
	    	<c:if test="${pagingVO.curPage ne i}">
	    		<li><a href="${linkPage}?curPage=${i}"  data-page="${i}">${i}</a></li>
	    	</c:if>
	    	<c:if test="${pagingVO.curPage eq i}">
		    	<li class="active"><a href="#">${i}</a></li>
	    	</c:if>
	    </c:forEach>
	
	
	    <!-- 다음  페이지 (lastpage < totalPageCnt) -->
	    <c:if test="${pagingVO.endPage< pagingVO.totalPageCount }">
	     <li><a href="${linkPage}?curPage=${pagingVO.endPage+1}" data-page="${pagingVO.endPage+1}" ><span aria-hidden="true">&raquo;</span></a>
		</c:if>
	</ul>	

		
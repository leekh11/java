<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="pagingVO" required="true" type="com.study.common.vo.PagingVO"%>
<%@ attribute name="linkPage" %>

	<ul class="pagination">
		<!-- 이전 페이지 -->
		<c:if test="${pagingVO.startPage-1 != 0 }">
			<li><a href="${linkPage}?curPage=${pagingVO.startPage-1 }"
				data-page="${pagingVO.startPage-1 }"><span aria-hidden="true">&laquo;</span></a>
		</c:if>
		

		<!-- 페이지 넘버링  -->
		<c:forEach var="i" begin="${pagingVO.startPage}"
			end="${pagingVO.endPage }">
			<c:if test="${pagingVO.curPage == i }">
				<li class="active"><a href="${linkPage}?curPage=${i}"
					data-page="${i}">${i}</a></li>
			</c:if>
			<c:if test="${pagingVO.curPage != i }">
				<li><a href="${linkPage}?curPage=${i}" data-page="${i}">${i}</a></li>
			</c:if>
		</c:forEach>

		<!-- 다음  페이지  -->
		<c:if test="${pagingVO.endPage+1 < pagingVO.totalPageCount }">
			<li><a href="${linkPage}?curPage=${pagingVO.endPage+1 } "
				data-page="${pagingVO.endPage+1 }"><span aria-hidden="true">&raquo;</span></a>
		</c:if>
	</ul>

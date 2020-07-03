<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%-- left.jsp --%>
<div class="left-menu">
	<ul>
		<li>자유게시판</li>
		<li>QnA</li>
		<li>자료실</li>
		<li>질문게시판</li>
		<li>이름 : <%=request.getParameter("name") %></li>
		<li>연령대 : <%=request.getParameter("gen") %></li>
	</ul>
</div>
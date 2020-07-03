<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String ip = request.getRemoteAddr();
	String uri = request.getRequestURI();
	String APP_PATH = request.getContextPath();
	log("ip="+ip+", uri" + uri);
%>
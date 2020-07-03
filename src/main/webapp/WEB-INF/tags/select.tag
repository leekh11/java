<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>
<%@ tag dynamic-attributes="attributeMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="name" required="true" %>
<%@ attribute name="items" type="java.util.Collection" required="true" %>
<%@ attribute name="itemValue" %>
<%@ attribute name="itemLabel" %>
<%@ attribute name="value" %>

<select name="${name }"
	<c:forEach items="${attributeMap}" var="attr">
		${attr.key}=${attr.value}
	</c:forEach>
	>
	<option>--전체--</option>	
	<c:forEach items="${items}" var="code">
		<option value="${code[itemValue]}" ${code[itemValue] eq value ? "selected" : '' }>${code[itemLabel]}</option>
	</c:forEach>
</select>
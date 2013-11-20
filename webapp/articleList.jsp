<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="articleList" class="left">
	<c:forEach var="photoBoard" items="${photoBoards}" varStatus="status">
		<%@ include file="articleForm.jsp" %>
	</c:forEach>
</div>

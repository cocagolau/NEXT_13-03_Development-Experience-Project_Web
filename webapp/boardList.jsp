<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="articleList">
	<c:forEach var="photoBoard" items="${photoBoards}" varStatus="status">
		<%@ include file="show.jsp" %>
	</c:forEach>
</div>

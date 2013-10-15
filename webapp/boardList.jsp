<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../stylesheets/boardList.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/show.css">
</head>
<body>
	<div class="articleList">
		<c:forEach var="photoBoard" items="${photoBoards}" varStatus="status">
			<%@ include file="show.jsp" %>
		</c:forEach>
	</div>
</body>
</html>
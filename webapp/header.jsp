<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div id="statusBar">
	<h1 id="logo">Wiggle.so</h1>
	<div id="status" class="test">
		<div id="date">2013.10.10 <span>(목)</span></div>
		<c:if test= "${not empty sessionScope.userEmail}">
			<div id="action"><a href="#" class="writing">글쓰기</a></div>
		</c:if>
	</div>
	<div id="userStatus">
		<%@ include file = "userStatus.jsp" %>
	</div>
</div>
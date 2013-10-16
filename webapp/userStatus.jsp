<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:choose>
	<c:when test= "${not empty sessionScope.userEmail}">
		<div id="statusInfo" class="alignBottom">
			<a href="board/form" target="_blank">글쓰기</a>
		</div>
		<div id="statusUser" class="alignBottom">
			<%@ include file = "userInfo.jsp" %>	
		</div>
	</c:when>
	
	<c:otherwise>
		<div id="statusUser" class="alignBottom">
			<%@ include file = "signIn.jsp" %>
		</div>
	</c:otherwise>
</c:choose>
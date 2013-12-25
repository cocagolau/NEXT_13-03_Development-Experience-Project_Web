<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${not empty sessionScope.userEmail}">
	<div class="commentsList">
		<c:forEach var="comment" items="${photoBoard.comments}" varStatus="status" >
			<div class="comment">
			<%-- <div id="comment${status.count}"> --%>
				<div class="info">${comment.signBoard.name}</div>
				<div class="contents">${comment.contents}</div>
				
				<c:if test="${comment.signBoard.email == sessionScope.userEmail}" >
					<div class="option">
						<span><a href="baord/comments/<c:out value="${comment.id}" />/modify">수정</a></span>
						<span><a href="board/comments/<c:out value="${comment.id}" />/delete">삭제</a></span>
					</div>
				</c:if>
			</div>	
		</c:forEach>
	</div>
	<div class="writing">
		<form name="commentForm" action="/board/${photoBoard.id}/comments" method="post">
			<input type="hidden" name="id" value="${photoBoard.id}" />
			<span class="info"><input name="sign" type="hidden" value="${sessionScope.userEmail}"/></span>
			<span class="contents"><input name="contents" type="text" placeholder="댓글 달기"/></span>
			<span class="submitBtn"><input type="submit" /></span>
		</form>
	</div>
</c:when>

<c:otherwise>
	<div class="commentsList">
		<c:forEach var="comment" items="${photoBoard.comments}" varStatus="status" >
			<div class="comment">
			<%-- <div id="comment${status.count}"> --%>
				<div class="info">${comment.signBoard.name}</div>
				<div class="contents">${comment.contents}</div>
			</div>	
		</c:forEach>
	</div>
</c:otherwise>
</c:choose>
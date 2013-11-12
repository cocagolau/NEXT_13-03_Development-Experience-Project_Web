<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:choose>
<c:when test="${not empty sessionScope.userEmail}">
	<div class="commentsList">
		<c:forEach var="comment" items="${photoBoard.comments}" varStatus="status" >
			<div id="comment${status.count}">
				<div class="commentWriterProfile">${comment.signBoard.name}</div>
				<div class="commentWriterContents">${comment.contents}</div>
				
				<c:if test="${comment.signBoard.email == sessionScope.userEmail}" >
					<div class="commentWriterOption">
						<span><a href="baord/comments/<c:out value="${comment.id}" />/modify">수정</a></span>
						<span><a href="board/comments/<c:out value="${comment.id}" />/delete">삭제</a></span>
					</div>
				</c:if>
			</div>	
		</c:forEach>
	</div>
	<div class="commentsWritting">
		<form id="commentForm" name="commentForm" action="/board/${photoBoard.id}/comments" method="post">
			<input type="hidden" name="id" value="${photoBoard.id}" />
			<span id="commentInfo"><input name="sign" type="hidden" value="${sessionScope.userEmail}"/></span>
			<span id="commentContents"><input name="contents" type="text" placeholder="댓글 달기"/></span>
			<span id="commentSubmit"><input type="submit" /></span>
		</form>
	</div>
</c:when>

<c:otherwise>
	<div class="commentsList">
		<c:forEach var="comment" items="${photoBoard.comments}" varStatus="status" >
			<div id="comment${status.count}">
				<div class="commentWriterProfile">${comment.signBoard.name}</div>
				<div class="commentWriterContents">${comment.contents}</div>
			</div>	
		</c:forEach>
	</div>
</c:otherwise>
</c:choose>
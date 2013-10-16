<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div class="commentsList">
	<c:forEach var="comment" items="${photoBoard.comments}" varStatus="status" >
		<div class="comment${status.count}">
			<div class="commentWriterProfile">서동규</div>
			<div class="commentWriterContents">${comment.contents}</div>
		</div>	
	</c:forEach>
</div>

<div class="commentsWritting">
	<form name="commentForm" action="/board/${photoBoard.id}/comments" method="post">
		<span id="commentContents"><input name="contents" type="text" placeholder="댓글 달기"/></span>
		<span id="commentSubmit"><input type="submit" /></span>
	</form>
</div>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<div id="article<c:out value="${status.count}" />" class="articleTable">
	<div class="articleRow">
		<div class="leftArticle">
			<img id="profilePhoto" src="images/profile.png" />
		</div>
		<div class="rightArticle">
			<div class="topMenu">
				<div class="name">서동규</div>
				<div class="option">
					<ul>
						<li class="optionItem"><a href="board/form/<c:out value="${photoBoard.id}" />">수정</a></li>
						<li class="optionItem"><a href="board/delete/<c:out value="${photoBoard.id}" />">삭제</a></li>
						<li class="optionItem">""</li>
						<li class="optionItem">∞</li>
					</ul>
				</div>
			</div>
			<div class="contents">
				<div class="photo"><img src="images/<c:out value="${photoBoard.filename}" />"></div>
				<div class="text"><c:out value="${photoBoard.article}" /></div>
			</div>
			<div class="bottomMenu">
				comment 10, quoted 7
			</div>
			<div class="comments">
				<%@ include file="comments.jsp" %>
			</div>
		</div>
	</div>
</div>
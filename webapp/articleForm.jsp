<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import ="java.util.*" %>

<%-- <div id="article<c:out value="${status.count}" />"> --%>

<div class="article">	
	<div class="left">
		<img id="profilePhoto" src="images/profile.png" />
	</div>
	
	
	<div class="right">
		<div class="info">
			<div class="name">${photoBoard.signBoard.name}</div>
				
			<div class="option">
				<ul>
					<c:if test="${photoBoard.signBoard.email == sessionScope.userEmail}">
						<li class="optionItem"><a
							href="board/modify/<c:out value="${photoBoard.id}" />">수정</a></li>
						<li class="optionItem"><a
							href="board/delete/<c:out value="${photoBoard.id}" />">삭제</a></li>
					</c:if>
					<li class="optionItem">""</li>
					<li class="optionItem">∞</li>
				</ul>
			</div>
		</div>
			
		
		<div class="contents">
			<div class="photo">
				<img src="images/<c:out value="${photoBoard.filename}" />">
			</div>
			<div class="text">
				<c:out value="${photoBoard.article}" />
			</div>
		</div>
		
		<div class="status">
			<div>댓글 ${photoBoard.size}</div>
			<div>인용 0</div>
		</div>
		
		<div class="comments">
			<%@ include file="comments.jsp"%>
		</div>
	</div>
</div>


<%-- <div id="article<c:out value="${status.count}" />" class="articleTable">
	<div class="articleRow">
		<div class="leftArticle">
			<img id="profilePhoto" src="images/profile.png" />
		</div>
		<div class="rightArticle">
			<div class="topMenu">
				<div class="name">${photoBoard.signBoard.name}</div>
				<div class="option">
					<ul>
						<c:if
							test="${photoBoard.signBoard.email == sessionScope.userEmail}">
							<li class="optionItem"><a
								href="board/modify/<c:out value="${photoBoard.id}" />">수정</a></li>
							<li class="optionItem"><a
								href="board/delete/<c:out value="${photoBoard.id}" />">삭제</a></li>
						</c:if>
						<li class="optionItem">""</li>
						<li class="optionItem">∞</li>
					</ul>
				</div>
			</div>
			<div class="contents">
				<div class="photo">
					<img src="images/<c:out value="${photoBoard.filename}" />">
				</div>
				<div class="text">
					<c:out value="${photoBoard.article}" />
				</div>
			</div>
			<div class="bottomMenu">comment ${photoBoard.size} --> photoBoard.getSize(), quoted 7</div>
			<div class="comments">
				<%@ include file="comments.jsp"%>
			</div>
		</div>
	</div>
</div> --%>
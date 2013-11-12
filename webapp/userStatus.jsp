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
			<div class="signIn">
				<form name="signInForm" action="sign/in" method="post">
					<span><input name="signInEmail" size="25" type="text" placeholder="이메일" autofocus /></span>
					<span><input name="signInPassword" size="25" type="password" placeholder="비밀번호" /></span>
					<span><input name="signInSubmit" type="submit" value="로그인" /></span>
					<span><a id="signUpBtn" href="#">+</a></span>
				</form>
			</div>
		</div>
	</c:otherwise>
</c:choose>
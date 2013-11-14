<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:choose>
	<c:when test= "${not empty sessionScope.userEmail}">
		<div class="signOutBtn"><a href="#">&#88;</a></div>
		<div class="text"><a href="#">${sessionScope.userName}</a></div>
		<div class="quote"><a href=#>"10"</a></div>
		
		
	</c:when>
	<c:otherwise>
		<div class="text title out">회원가입</div>
		<div class="signUpFormBtn"><a href="#">+</a></div>
		<div class="text signInFormBtn"><a href="#">로그인</a></div>
		<div class="signInBtn out"><a href="#">&#10132;</a></div>
		<div class="signInForm out">
			<form id="signInForm" action="sign/in" method="post">
				<span><input name="signInEmail" size="25" type="text" placeholder="이메일" autofocus /></span>
				<span><input name="signInPassword" size="20" type="password" placeholder="비밀번호" /></span>
			</form>
		</div>
	</c:otherwise>
</c:choose>
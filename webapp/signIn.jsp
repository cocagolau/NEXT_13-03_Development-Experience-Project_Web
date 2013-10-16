<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<div class="signIn">
	<form name="signInForm" action="sign/in" method="post">
		<span><input name="signInEmail" size="25" type="text" placeholder="이메일" autofocus /></span>
		<span><input name="signInPassword" size="25" type="password" placeholder="비밀번호" /></span>
		<span><input name="signInSubmit" type="submit" value="로그인" /></span>
		<span><a href="sign/up" target="_blank">+</a></span>
	</form>
</div>
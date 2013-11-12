<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form name="loginForm" action="/sign" method="post">
	<div id="signUp">
		<h1>가입하기</h1>
		<div><a href="#">X</a></div>
		<div class="form">
			<div><input class="email" name="email" type="text" placeholder="e메일 주소" autofocus/></div>
			<div><input class="password" name="password" type="password" placeholder="비밀번호"/></div>
			<div><input class="password" type="password" placeholder="비밀번호 다시입력" /></div>
			<div>
				<input class="name" name="name" type="text" placeholder="이름"/>
				<a href="#">가입</a>
			</div>
			<div class="facebook"><a href="#">페이스북으로 로그인</a></div>
		</div>
		
	</div>
</form>
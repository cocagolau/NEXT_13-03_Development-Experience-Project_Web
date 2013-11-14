<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form id="signUpForm" action="/sign" method="post">
	<div id="signUp">
		<h1>Welcome :)</h1>
		<div><a href="#" class="closeBtn">X</a></div>
		<div class="form">
			<div><input class="email" name="email" type="text" placeholder="e메일 주소" autofocus/></div>
			<div><input class="name" name="name" type="text" placeholder="이름"/></div>
			<div><input class="password" name="password" type="password" placeholder="비밀번호"/></div>
			<div><input class="password" type="password" placeholder="비밀번호 다시입력" /></div>
			<div><button class="signUpBtn" type="submit" form="signUpForm">가입</button></div>
			<div><button class="facebook" type="button" href="#" >페이스북으로 회원가입</button></div>
			<!-- <div><input class="signUpBtn" type="button" value="가입" /></div>
			<div><input class="facebook" type="button" value="페이스북으로 회원가입" /></div> -->
			<!-- <div><a href="#">가입</a></div>
			<div class="facebook"><a href="#">페이스북으로 회원가입</a></div> -->
		</div>
		
	</div>
</form>
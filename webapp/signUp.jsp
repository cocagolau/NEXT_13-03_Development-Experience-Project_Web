<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../stylesheets/login.css">
</head>

<body>
	<div class="login">
		<form name="loginForm" action="/sign" method="post">
			<div class="loginEmail">
				<input name="email" type="text" placeholder="e메일주소" autofocus />
			</div>
			<div class="loginPassword">
				<input name="password" type="password" placeholder="비밀번호"/>
			</div>
			<div class="loginPasswordRetry">
				<input type="password" placeholder="다시입력" />
			</div>
			<div class="loginName">
				<input name="name" type="text" placeholder="이름"/>			
			</div>
			<div class="loginSubmit">
				<input type="submit" value="가입"/>
			</div>
		</form>
	</div>
</body>
</html>
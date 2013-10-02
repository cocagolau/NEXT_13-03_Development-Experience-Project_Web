<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!--   enctype="multipart/form-data" -->
<form name = "upload_form" action="/board" method="post">
	<table>
		<tr>
			<td><input name="photo" type="file"></td>
		</tr>
		<tr>
			<td><textarea name="article", rows="3", cols="30">지금 무슨 생각을 하고 계시나요?</textarea></td>
		</tr>
		<tr>
			<td><input type="submit" value="게시"></td>
		</tr>
	</table>
</form>

</body>
</html>
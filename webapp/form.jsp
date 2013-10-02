<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form name = "uploadForm" action="/board" method="post" enctype="multipart/form-data">
	제목: <input name="title" type="text" size="50" /><br />
	파일: <input name="file" type="file" size="50" /><br />
	<textarea name="article" rows="5" cols="50">지금 무슨 생각을 하고 계시나요?</textarea><br />
	<input type="submit" value="게시" />
</form>

</body>
</html>
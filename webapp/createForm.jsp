<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../../stylesheets/cssResetStyle.css" />
	<link rel="stylesheet" type="text/css" href="../../stylesheets/form.css" />
</head>

<body>
	<div id="wrap">
		<header>
			글쓰기
		</header>
		
		<div id="container">
			<form name = "uploadForm" action="/board" method="post" enctype="multipart/form-data">
				<div id="articleForm">
					<div id="articleTop">
						<div id="articleId">
							<input name="sign" type="hidden" value="${sessionScope.userEmail}" />
						</div>
					</div>
					<div id="articleText">
						<textarea name="article" rows="5" cols="64" placeholder="지금 무슨 생각을 하고 계시나요?" autofocus></textarea>
					</div>
					<div id="articleBottom">
						<div id="articlePhoto">
							<input name="photo" type="file" size="50" />
						</div>
						<div id="submitArticleForm">
							<input type="submit" value="글쓰기" />
						</div>
					</div>
				</div>
			</form>
		</div>
	
	</div>
</body>
</html>
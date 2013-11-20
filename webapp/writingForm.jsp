<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<form id="writingForm" name = "uploadForm" action="/board" method="post" enctype="multipart/form-data">
	<div id="writing">
		<h1>사진과 글을 공유하세요!</h1>
		<div><a href="#" class="closeBtn">X</a></div>
		<div class="form">
			<div><input name="sign" type="hidden" value="${sessionScope.userEmail}" /></div>
			<div class="uploadBtn"><input name="photo" type="file" size="50" /></div>
			<div class="writingBtn"><input type="submit" value="글쓰기" /></div>
			<div class="article"><textarea name="article" placeholder="지금 무슨 생각을 하고 계시나요?" autofocus></textarea></div>
		</div>
	</div>
</form>
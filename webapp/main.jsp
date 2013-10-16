<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="../stylesheets/cssResetStyle.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/main.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/header.css">
	
	<link rel="stylesheet" type="text/css" href="../stylesheets/boardList.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/show.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/comments.css">
	
	<link rel="stylesheet" type="text/css" href="../stylesheets/signIn.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/userInfo.css">
</head>
<body>

	<div id="wrap">
		<header><%@ include file="header.jsp" %></header>

		<div id="container">
			<div id ="controller">
				<div id="moveLeft">◀</div>
				<div id="moveRight">▶</div>
			</div>
			<div id ="journals">
				<div id="journal" class="journalTable">
					<div class="journalRow">
						<div id="leftColumn" class="journalColumn">
							<!-- journal_left_column / 470px  -->
							<%@ include file="boardList.jsp" %>
						</div>
						<div id="rightColumn" class="journalColumn">
							<!-- journal_right_column / 470px  -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
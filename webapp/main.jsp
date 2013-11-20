<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<meta charset="utf-8">
	<title>We Wiggle so...</title>
	<link rel="stylesheet" type="text/css" href="../stylesheets/cssResetStyle.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/utils.css">
	
	
	<link rel="stylesheet" type="text/css" href="../stylesheets/main.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/header.css">
	
	<link rel="stylesheet" type="text/css" href="../stylesheets/boardList.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/show.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/comments.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/signUpForm.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/writingForm.css">
	<link rel="stylesheet" type="text/css" href="../stylesheets/article.css">
	
	<script type="text/javascript" src="../javascripts/utils.js"></script>
	<script type="text/javascript" src="../javascripts/events.js"></script>
	<script type="text/javascript" src="../javascripts/main.js"></script>
	<script type="text/javascript" src="../javascripts/sign.js"></script>
	<script type="text/javascript" src="../javascripts/boardWriting.js"></script>
</head>
<body>

	<div id="wrap">
		<header><%@ include file="header.jsp" %></header>

		<div id="container">
			<div id ="journals">
				<div id="journal" class="journalTable">
					<div class="journalRow">
						<div id="leftColumn" class="journalColumn">
							<!-- journal_left_column / 470px  -->
							<%@ include file="articleList.jsp" %>
						</div>
						<div id="rightColumn" class="journalColumn">
							<!-- journal_right_column / 470px  -->
						</div>
					</div>
				</div>
			</div>
			<div id ="controller">
				<div id="moveLeft">◀</div>
				<div id="moveRight">▶</div>
			</div>
			<div id="overlay"></div>
		</div>
	</div>

</body>
</html>
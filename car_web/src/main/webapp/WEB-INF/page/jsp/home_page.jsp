<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
	<head>
		<meta charset="utf-8">
		<link href="web/css/home.css" rel="stylesheet" type="text/css" />
		<link href="web/css/menu.css" rel="stylesheet" type="text/css" />
		<link href="web/css/footer.css" rel="stylesheet" type="text/css" />
		<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png" rel="shortcut icon" type="image/png">
		<title>Home page</title>
	</head>
	
	<body>
		<div>
			<div id="wrapper">
			
				<%@include file="/WEB-INF/page/jspf/header_default.jspf" %>
				
				<hr>
				
				<div class="menu_center">
					<%@include file="/WEB-INF/page/jspf/menu.jspf" %>
				</div>
				
				<hr>
	
				<%-- <%@include file="../jspf/msg.jspf"%> --%>
	
				<%@include file="/WEB-INF/page/jspf/photo_description.jspf" %>
			</div>
			
			<div id="foot">
				<jsp:include page="/WEB-INF/page/jspf/footer.jspf" />
			</div>
		</div>
	</body>
</html>
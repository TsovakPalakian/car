<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf8" />
		<link rel="stylesheet" type="text/css" href="web/css/home.css"    />
		<link rel="stylesheet" type="text/css" href="web/css/menu.css"    />
		<link rel="stylesheet" type="text/css" href="web/css/footer.css"  />
		<link href="http://res.cloudinary.com/javadevgroup/image/upload/v1499189950/fidelio_icon_fynnxg.png" rel="shortcut icon" type="image/png">
		<title>Home page</title>
	</head>
	
	<body>
		<div>
			<div id="wrapper">

				<%@include file="/WEB-INF/pages/jspf/header_default.jspf" %>
				
				<hr>
					<div class="menu_center">
						<%@include file="/WEB-INF/pages/jspf/menu.jspf" %>
					</div>
				<hr>
	
				<%-- <%@include file="../jspf/msg.jspf"%> --%>
	
				<%@include file="/WEB-INF/pages/jspf/photo_description.jspf" %>
			</div>
			
			<div id="foot">
				<jsp:include page="/WEB-INF/pages/jspf/footer.jspf" />
			</div>
		</div>
	</body>
</html>
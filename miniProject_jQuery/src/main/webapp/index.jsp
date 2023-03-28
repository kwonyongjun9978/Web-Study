<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MVC</title>
<style>
html, body {
   width: 100%;
   height: 100%;
}
html {
   overflow-y: scroll;
}

#wrap{
   width: 1100px; 
   margin: 0 auto;
}

#header {
   height: 10%;
   text-align: center;
}

#container {
   margin: auto;
   width: 1100px;
   height: 500px;
}

#container:after {
   content: '';
   display: block;
   clear: both;
   float: none;
}

#nav {
   margin-left: 10px;
   width: 25%;
   height: 100%;
   float: left;
}

#section {
   width: 70%;
   height: 100%;
   float: left;
}

#footer {
   width: 1100px;
   height: 10%;
}
</style>
</head>
<body>
<div id="wrap">
	<div id="header">
		<h1><img src="/miniProject_jQuery/img/123456.png" alt="mainImg" 
			onclick="location.href='/miniProject_jQuery/index.jsp'" 
			style="cursor: pointer; border-radius: 50%; border: 1px solid #ccc; margin: 10px; width: 150px; height: 200px;">
		</h1>
		<jsp:include page="./main/menu.jsp" />
	</div>
	
	<div id="container">
		<div id="nav">
			<jsp:include page="./main/nav.jsp" />
		</div>
		
		<div id="section">
			<h3>
				<c:if test="${empty display}">
					<img src="./img/12.gif" style="border-radius: 80%;">
					<c:if test="${sessionScope.memId != null}">
					<h3>누추한분이 이런 귀한곳에...ㅎㅎ</h3>
					</c:if>
				</c:if>
				
				<c:if test="${not empty display}">
					
					<jsp:include page="${display }"/>
				</c:if>
			</h3>
		</div>
	</div>
	<hr/>	
	<div id="footer">
		<h4>용준캠프</h4>
	</div>
</div>
</body>
</html>
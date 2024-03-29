<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<fmt:requestEncoding value="UTF-8" />
<ul>
	<li>이름 : ${param.name }</li><br/>
	
	<li>
	나이 : ${param.age }살
	<c:if test="${param.age>=19 }"><strong>성인</strong></c:if>
	<c:if test="${param.age<19 }"><strong>청소년</strong></c:if>
	</li><br/>
	
	<li>
	색깔 : 
	<c:choose>
		<c:when test="${param.color=='red' }"><strong>빨강</strong></c:when>
		<c:when test="${param.color=='green' }"><strong>초록</strong></c:when>
		<c:when test="${param.color eq 'blue' }"><strong>파랑</strong></c:when>
		<c:when test="${param.color=='magenta' }"><strong>보라</strong></c:when>
		<c:otherwise><strong>하늘</strong></c:otherwise>
	</c:choose>
	</li><br/>
	
	<li>
	취미 : ${paramValues.hobby[0] }
		  ${paramValues.hobby[1] }
		  ${paramValues.hobby[2] }
		  ${paramValues['hobby'][3] }
		  ${paramValues['hobby'][4] }
	</li>
	<li>
	취미 : 
	<c:forEach var="data" items="${paramValues.hobby }">
		${data }
	</c:forEach>
	</li>
</ul>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
<%!
//전역 - 1번만 실행(선언문)
String name = "권용준";
int age = 25;
%>

<%
//지역 - 호출시마다 실행(스크립트릿)
age++;
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>helloJSP</title>
</head>
<body>
<!-- Hello JSP!!<br> -->
<%-- 안녕하세요 JSP!!<br> --%>
나의 이름은 <%=name %> 입니다<br>
<% out.println("나의 이름은 "+name+" 입니다"); %>
<!-- 내 나이는 <%=age %>살 입니다<br> -->
<%-- 내 나이는 <%=age %>살 입니다<br> --%>
</body>
</html>
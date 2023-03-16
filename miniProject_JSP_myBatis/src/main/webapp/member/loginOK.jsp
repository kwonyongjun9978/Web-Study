<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//데이터
	String name = null;
	String id = null;
	
	//세션 불러오기
	name = (String)session.getAttribute("memName");
	id = (String)session.getAttribute("memid"); //로그아웃하기위해서
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인성공</title>
</head>
<body>
<img src="../image/12.gif" width="80" height="80" alt="JUN" onclick="location.href='../index.jsp'" style="cursor: pointer;">
<h3><%=name %>님 로그인</h3>
<br>
<input type="button" value="로그아웃" onclick="location.href='logout.jsp'">
<input type="button" value="회원정보수정" onclick="location.href='updateForm.jsp'">
<input type="button" value="회원탈퇴" onclick="location.href='deleteForm.jsp'">
</body>
</html>
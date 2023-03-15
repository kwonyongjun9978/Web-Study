<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>  
<%@ page import="member.dao.MemberDAO" %> 
<%
//데이터 가져오기
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String pwd = request.getParameter("pwd");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
String name = memberDAO.memberLogin(id,pwd);
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 확인</title>
</head>
<body>
<%
if(name == null){
	//페이지 이동(로그인 실패)
	response.sendRedirect("loginFail.jsp");
}else{
	//세션 생성
	session.setAttribute("memName", name);
	session.setAttribute("memId", id);
	session.setAttribute("memPwd", pwd);
	
	//페이지 이동(로그인 성공)
	response.sendRedirect("loginOK.jsp");
	}
%>
</body>
</html>
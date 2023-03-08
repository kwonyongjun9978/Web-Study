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
//String email = memberDAO.getEmailTo(id,pwd);
MemberDTO memberDTO = memberDAO.getEmailTo(id,pwd);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
<%if(name == null){
	//페이지 이동
	response.sendRedirect("loginFail.jsp");

}else{
	//쿠키
	/*
	Cookie cookie = new Cookie("memName", name);
	cookie.setMaxAge(30*60); //초 단위
	response.addCookie(cookie);//클라이언트에 보내기
	
	Cookie cookie2 = new Cookie("memId", id);
	cookie2.setMaxAge(30*60); //초 단위
	response.addCookie(cookie2);//클라이언트에 보내기
	*/
	
	//세션 생성
	//HttpSession session = request.getSession(); - JSP는 세션객체가 이미 내장객체로 존재한다
	session.setAttribute("memName", name);
	session.setAttribute("memId", id);
	session.setAttribute("memPwd", pwd);
	//session.setAttribute("memEmail", email);
	session.setAttribute("memEmail", memberDTO.getEmail1()+"@"+memberDTO.getEmail2());
	
	//페이지 이동
	response.sendRedirect("loginOK.jsp");
} %>
</body>
</html>
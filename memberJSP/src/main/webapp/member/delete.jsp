<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>  
<%@ page import="member.dao.MemberDAO" %>      
<%
//데이터 가져오기
request.setCharacterEncoding("UTF-8");
String id = (String)session.getAttribute("memId");

//세션
//session.removeAttribute("memName");
//session.removeAttribute("memId");
session.invalidate(); //무효화

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
memberDAO.memberDelete(id);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>
<script type="text/javascript">
window.onload = function(){
	alert("회원탈퇴 완료!!");
	location.href="loginForm.jsp";
}
</script>	
</body>
</html>
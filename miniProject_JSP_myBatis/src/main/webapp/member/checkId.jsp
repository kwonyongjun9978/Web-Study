<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.dao.MemberDAO" %>    
<!DOCTYPE html>
<%
request.setCharacterEncoding("UTF-8");

//데이터
String id = request.getParameter("id");

//DB
MemberDAO memberDAO = MemberDAO.getInstance();
boolean existId = memberDAO.isExistID(id); //아이디가 있다 -> true, 사용 불가능
%>
<html>
<head>
<meta charset="UTF-8">
<title>중복아이디확인</title>
</head>
<body>
<% if(existId){ %>
<form action="checkId.jsp">
<h3><%=id %>는 사용 불가능</h3>
아이디<input type="text" name="id"> <input type="submit" value="중복체크">
</form>
<%}else{%>
<h3><%=id %>는 사용 가능</h3>
<input type="button" value="사용하기" onclick="checkIdClose('<%=id %>')">
<%} %>

<script type="text/javascript">
function checkIdClose(id){
	opener.writeForm.id.value = id
	opener.writeForm.check.value = id
	window.close();
	opener.writeForm.pwd.focus();
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="member.bean.MemberDTO" %>  
<%@ page import="member.dao.MemberDAO" %>      
<%
//데이터 가져오기
request.setCharacterEncoding("UTF-8");

String pwd = request.getParameter("pwd"); //deleteForm에서 넘어온 데이터
System.out.println("pwd = "+pwd); //맨처음에는 pwd가 null

//세션
String id = (String)session.getAttribute("memId");
String memPwd = (String)session.getAttribute("memPwd");

//DB
boolean exist = false;
if(pwd != null){
//MemberDAO memberDAO = MemberDAO.getInstance();
//exist = memberDAO.isExistPwd(id, pwd); //비밀번호가 있으면 true, 없으면 false

if(memPwd.equals(pwd)) exist = true;
}

if(exist) response.sendRedirect("delete.jsp");
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
<style type="text/css">
div#pwdDiv {
   color: red;
   font-size: 8pt;
   font-weight: bold;
}
</style>
</head>
<body>
<form name="deleteForm" method="post" action="deleteForm.jsp">
<div style="text-align: center;">
<img src="../image/12.gif" width="80" height="80" alt="JUN" onclick="location.href='../index.jsp'" style="cursor: pointer;">
 <th>비밀번호 입력 : </th>
  <input type="password" name="pwd" id="pwd">
  <input type="button" value="검색" onclick="searchDelete()">
  <div id="pwdDiv">
  <% if(pwd != null && !exist) { %>
  비밀번호가 맞지 않습니다.
  <%} %>
  </div>
</div>
</form>

<script type="text/javascript">
function searchDelete() {
	   document.getElementById("pwdDiv").innerText = "";
	   
	   if(document.getElementById("pwd").value == "")
	      document.getElementById("pwdDiv").innerText = "비밀번호를 입력하세요";
	   else
	      document.deleteForm.submit();
	}
</script>
</body>
</html>
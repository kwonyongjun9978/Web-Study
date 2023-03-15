<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<style type="text/css">
div{
color: red;
font-size: 8pt;
font-weight: bold;
}
</style>
</head>
<body>
<h3>
<img src="../image/12.gif" width="80" height="80" alt="JUN" onclick="location.href='../index.jsp'" style="cursor: pointer;"> 
로그인
</h3>
 <form name="loginForm" method="post" action="login.jsp">
  <table border="1" cellpadding="5" cellspacing="0">
   <tr>
    <th width="70" align="center">아이디</th>
    <td>
     <input type="text" name="id" id="id" style="width: 100px;">
  	 <div id="idDiv"></div>
    </td>
   </tr>
   
   <tr>
    <th align="center">비밀번호</th>
    <td>
     <input type="password" name="pwd" id="pwd" style="width: 200px;">
  	 <div id="pwdDiv"></div>
    </td>
   </tr>
   
   <tr>
	<td colspan="2" align="center">
	 <input type="button" value="로그인" onclick="checkLogin()"> 
	 <input type="button" value="회원가입" onClick="location.href='writeForm.jsp'">
    </td> 
   </tr>
   
  </table>
 </form>
 <script type="text/javascript">
 function checkLogin(){
		document.getElementById("idDiv").innerText="";
		document.getElementById("pwdDiv").innerText="";
		
		if(document.getElementById("id").value == "") 
			document.getElementById("idDiv").innerText="아이디를 입력하세용";
		else if(document.getElementById("pwd").value == "") 
			document.getElementById("pwdDiv").innerText="비밀번호를 입력하세용";
		else 
			document.loginForm.submit();
	}
 </script>
</body>
</html>
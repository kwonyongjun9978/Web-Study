<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<style type="text/css">
form[name="loginForm"] div{
color: red;
font-size: 8pt;
font-weight: bold;
}
</style>
</head>
<body>
<img src="../img/12.gif" width="80" height="80" alt="JUN" onclick="location.href='../index.jsp'" style="cursor: pointer; border-radius: 80%;">
 <form name="loginForm" method="post" action="/miniProject_jQuery/member/login.do">
  <table border="1" cellpadding="5" cellspacing="0">
   <tr>
    <th width="70" align="center">아이디</th>
    <td>
     <input type="text" name="id" id="id">
  	 <div id="idDiv"></div>
    </td>
   </tr>
   
   <tr>
    <th align="center">비밀번호</th>
    <td>
     <input type="password" name="pwd" id="pwd">
  	 <div id="pwdDiv"></div>
    </td>
   </tr>
   
   <tr>
	<td colspan="2" align="center">
	 <input type="button" value="로그인" onclick="checkLogin()"> 
	 <input type="button" value="회원가입" onClick="location.href='/miniProject_jQuery/member/writeForm.do'">
    </td> 
   </tr>
   
  </table>
 </form>
 <script type="text/javascript" src="../js/member.js">
 </script>
</body>
</html> --%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 화면</title>
<style type="text/css">
form[name="loginForm"] div{
color: red;
font-size: 8pt;
font-weight: bold;
}
</style>
</head>
<body>
<img src="../img/12.gif" width="80" height="80" alt="JUN" onclick="location.href='../index.jsp'" style="cursor: pointer; border-radius: 80%;">
 <form name="loginForm" id="loginForm">
  <table border="1" cellpadding="5" cellspacing="0">
   <tr>
    <th width="70" align="center">아이디</th>
    <td>
     <input type="text" name="id" id="id">
  	 <div id="idDiv"></div>
    </td>
   </tr>
   
   <tr>
    <th align="center">비밀번호</th>
    <td>
     <input type="password" name="pwd" id="pwd">
  	 <div id="pwdDiv"></div>
    </td>
   </tr>
   
   <tr>
	<td colspan="2" align="center">
	 <input type="button" value="로그인" id="loginBtn"> 
	 <input type="button" value="회원가입" onClick="location.href='/miniProject_jQuery/member/writeForm.do'">
    </td> 
   </tr>
   
  </table>
  <br><br>
  
  <div id="loginResult"></div>
 </form>
 <script type="text/javascript" src="../js/jquery-3.6.4.min.js"></script>
 <script>
 $('#loginBtn').click(function(){
	 $('#idDiv').empty();
	 $('#pwdDiv').empty();
	 
	 if($('#id').val() == '' ){
	   $('#idDiv').text('아이디 입력');
	   $('#id').focus();
	 }
	 else if($('#pwd').val() == '' ){
		 $('#pwdDiv').text('비밀먼호 입력');
		 $('#pwd').focus();
	 }else{
		 $.ajax({ //서버요청
			 type: 'post', //'get' or 'post'
			 
			 url: '/miniProject_jQuery/member/login.do',
			 
			 data: 'id='+$('#id').val()+'&pwd='+$('#pwd').val(), //서버로 보낼 데이터(id, pwd)
			 
			 dataType: 'text', //서버로부터 받는 자료형, text, xml, html, json
			 
			 success: function(data){
				 data = data.trim();
				 
				 if(data == 'ok'){
					 location.href='../index.jsp';
				 }else if(data == 'fail'){
					 $('#loginResult').text('응 틀렸어~')
					 $('#loginResult').css('font-size', '12pt')
				 }
			 },
			 
			 error: function(err){
				 
				 console.log(err);
			 }
		 });
	 }
 });
 </script>
</body>
</html>
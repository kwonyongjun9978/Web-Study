<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	//쿠키
	/*
	Cookie[] ar = request.getCookies();

	if(ar != null){
		for(int i=0; i<ar.length; i++){
			if(ar[i].getName().equals("memName")){
				ar[i].setMaxAge(0); //쿠키 삭제
				response.addCookie(ar[i]);//클라이언트에게 보내기
			}
			
			if(ar[i].getName().equals("memId")){
				ar[i].setMaxAge(0); //쿠키 삭제
				response.addCookie(ar[i]);//클라이언트에게 보내기
			}
		}//for
	}//if
	*/
	
	//세션
	//session.removeAttribute("memName");
	//session.removeAttribute("memId");
	session.invalidate();			
%>
<html>
<head>
<meta charset="UTF-8">
<title>로그아웃</title>
</head>
<body>
<h3>로그아웃^^</h3>

<script type="text/javascript">
window.onload = function(){
	alert("로그아웃");
	location.href="../index.jsp";
}
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<div>
	<c:if test="${sessionScope.memId == null}">
	<img src="/miniProject_jQuery/img/login.png" 
		onclick="location.href='/miniProject_jQuery/member/loginForm.do'" 
		style="cursor: pointer; width: 200px;"><br><br>
	<img src="/miniProject_jQuery/img/login2.png" 
		onclick="location.href='/miniProject_jQuery/member/writeForm.do'"
		style="cursor: pointer; width: 200px;"><br><br>	
	</c:if>
	
	<c:if test="${memId != null}">
		<h3>${memName } 어서오렴^^</h3>
		<img src="/miniProject_jQuery/img/login3.png" style="cursor: pointer; width: 200px;" 
		id="logoutBtn">
	</c:if>
</div>

<!-- CDN 방식 -->
<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script>
$('#logoutBtn').click(function(){
	$.ajax({
		type: 'post',
		url: '/miniProject_jQuery/member/logout.do',
		success: function(){
			alert("ㄲㅈ");
			location.href='/miniProject_jQuery/index.jsp';
		},
		error: function(err){
			console.log(err);
		}
	});
});
</script>

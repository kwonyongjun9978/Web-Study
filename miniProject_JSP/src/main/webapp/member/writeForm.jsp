<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
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
<img src="../image/12.gif" width="80" height="80" alt="JUN" onclick="location.href='../index.jsp'" style="cursor: pointer;"> 회원가입
</h3>
 <form name="writeForm" method="post" action="write.jsp">
  <table border="1" cellpadding="5" cellspacing="0">
   <tr>
  	<th width="70" align="center">이름</th>
  	<td>
  	 <input type="text" name="name" id="name" style="width: 70px;" placeholder="이름 입력">
  	 <div id="nameDiv"></div>
  	</td>
   </tr>
   
   <tr>
  	<th align="center">아이디</th>
  	<td>
  	 <input type="text" name="id" size="30" id="id" placeholder="아이디 입력">
  	 <input type="button" value="중복체크" onclick="checkId()">
  	 <div id="idDiv"></div>
  	</td>
   </tr>
   
   <tr>
  	<th align="center">비밀번호</th>
  	<td>
  	 <input type="password" name="pwd" id="pwd" size="40">
  	 <div id="pwdDiv"></div>
  	</td>
   </tr>
   
   <tr>
  	<th align="center">재확인</th>
  	<td>
  	 <input type="password" name="repwd" id="repwd" size="40">
   </tr>
   
   <tr>
  	<th align="center">성별</th>
  	<td>
	 <input type="radio" name="gender" id="gender m" value="0" checked="checked">
	 <label for="gender m">남자</label>
	 <input type="radio" name="gender" id="gender w" value="1">
	 <label for="gender w">여자</label>
  	</td>
   </tr>
   
   <tr>
  	<th align="center">이메일</th>
  	<td>
  	 <input type="text" name="email1" style="width: 120px;">
  	 @
  	 <input type="text" name="email2" id="email2" style="width: 120px;">
  	  <select name="email3" style="width:100px;" id="email3" onchange="select()"> <!-- 자바스크립트 함수 호출 -->
  	  	 <option value="">직접입력</option>
		 <option value="naver.com">naver.com</option>
		 <option value="gmail.com">gmail.com</option>
		 <option value="nate.com">nate.com</option>	
	  </select>
  	</td>
   </tr>
   
   <tr>
  	<th align="center">휴대폰</th>
  	<td>
  	 <select name="tel1" style="width:100px;">
  	  <option value="010">010</option>
	  <option value="011">011</option>
	  <option value="019">019</option>
	  <option value="019">070</option>		
	 </select>
	 -
	 <input type="text" name="tel2" style="width:70px;">
	 -
	 <input type="text" name="tel3" style="width:70px;">
  	</td>
   </tr>
   
   <tr>
  	<th align="center">주소</th>
  	<td>
  	 <input type="text" name="zipcode" id="zipcode" size="5" placeholder="우편 번호" readonly>
  	 <input type="button" value="우편번호검색" onclick="execDaumPostcode()">
  	 <br>
  	 <input type="text" name="addr1" id="addr1" style="width:400px;" placeholder="주소" readonly>
  	 <br>
  	 <input type="text" name="addr2" id="addr2" style="width:400px;" placeholder="상세주소">
  	</td>
   </tr>
   
   <tr>
	<td colspan="2" align="center">
	 <input type="button" value="회원가입" onclick="checkWrite()"> 
	 <input type="reset" value="다시작성">
    </td> 
   </tr>
  </table>
 </form>
 <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
 
 <!-- 절대 주소
<script type="text/javascript" src="http://localhost:8080/memberServlet/js/member.js">
 -->
 <!-- 상대 주소 -->
<script type="text/javascript" src="../js/member.js"></script>
<script type="text/javascript">
function checkId(){
	var id = document.getElementById("id").value;
	
	document.getElementById("idDiv").innerText="";
		
	if(id == "") 
		document.getElementById("idDiv").innerHTML="<font color='magenta'>먼저 아이디를 입력하세요</font>"
	else
		window.open("./checkId.jsp?id=" + id, "checkId", "width=500 height=150 left=900 top=200")
}
</script>
</body>
</html>
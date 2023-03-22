<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<style type="text/css">
body{
background-color: black;
color : yellow;
}
div{
color : red;
font-size: 8pt;
font-weight: bold;
}
</style>
</head>
<body>
<h3>글쓰기</h3>
<form name="boardWriteForm" method="post" action="/mvcBoard/board/boardWrite.do">
<table border="1" cellpadding="5" cellspacing="0">
 <tr>
   <th align="center">제목</th>
   <td>
    <input type="text" name="subject" id="subject" style="width: 450px;" placeholder="제목입력">
  	<div id="subjectDiv" ></div>
   </td>
 </tr>
 
 <tr>
  <th align="center">내용</th>
  <td>
   <textarea type="text" name="content" id="content" cols="65" rows="15"></textarea>
   <div id="contentDiv"></div>
  </td>
 </tr>
 
 <tr>
  <td colspan="2" align="center">
   <input type="button" value="글쓰기" onclick="checkBoardWrite()"> 
   <input type="reset" value="다시작성">
  </td> 
 </tr>
</table>
</form>
<script type="text/javascript">
function checkBoardWrite(){
	document.getElementById("subjectDiv").innerText="";
	document.getElementById("contentDiv").innerText="";
	
	if(document.getElementById("subject").value == ""){ 
		document.getElementById("subjectDiv").innerText="제목을 입력하세요";
		document.boardWriteForm.subject.focus();}
	else if(document.getElementById("content").value == ""){ 
		document.getElementById("contentDiv").innerText="내용을 입력하세요";
	    document.boardWriteForm.content.focus();}
	else
		document.boardWriteForm.submit();
}
</script>
</body>
</html>
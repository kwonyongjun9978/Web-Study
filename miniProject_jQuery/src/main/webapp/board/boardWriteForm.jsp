<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>

</head>
<body>
<h3>글쓰기</h3>
<form id="boardWriteForm" method="post" action="/miniProject_jQuery/board/boardWrite.do">
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
   <input type="button" value="글쓰기" id="boardWriteBtn"> 
   <input type="reset" value="다시작성">
  </td> 
 </tr>
</table>
</form>
<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript" src="../js/member.js"></script>

</body>
</html>
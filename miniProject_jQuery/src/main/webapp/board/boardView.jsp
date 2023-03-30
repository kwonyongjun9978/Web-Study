<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성한 글 확인</title>
</head>
<body>
<input type="hidden" id="pg" value="${pg }">
<input type="hidden" id="seq" value="${seq }">
<img src="../img/12.gif" width="70" height="70" alt="별가" 
onclick="location.href='../index.jsp'" style="cursor: pointer; border-radius: 50%;"> 
<table width="450" border="2" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
<tr>
  <td colspan="3" >
   <h2 id="subject"></h2>
  </td>
 </tr>
 
 <tr>
 	<td width="150" align="center"></td>
 	<td width="150" align="center"></td>
 	<td width="150" align="center"></td>
 </tr>
 
 <tr>
 	<td colspan="3" height="200" valign="top">
 		<div style="width: 100%; height: 100%; overflow: auto;"> <!-- 밑으로 긴 글일때 스크롤바가 생성 -->
 			<pre id="content" style="white-space: pre-line; word-break: break-all;"></pre>
 		</div>
 	</td>
 </tr>
</table>
<input type="button" value="목록" onclick="history.go(-1)">

<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="../js/boardView.js"></script>
</body>
</html>
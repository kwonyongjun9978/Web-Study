<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성한 글 확인</title>
</head>
<body>
<form id="boardViewForm" >
<input type="text" id="pg" name="pg" value="${requestScope.pg }">
<input type="text" id="seq" name="seq" value="${seq }">
<input type="text" id="memId" value="${memId }">
<img src="../img/12.gif" width="70" height="70" alt="별가" 
onclick="location.href='../index.jsp'" style="cursor: pointer; border-radius: 50%;"> 
<table width="450" border="2" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
<tr>
  <td colspan="3" >
   <h2><span id="subjectSpan"></span></h2>
  </td>
 </tr>
 
 <tr>
 	<td width="150" align="center">글번호 : <span id="seqSpan"></span></td>
 	<td width="150" align="center">작성자 : <span id="idSpan"></span></td>
 	<td width="150" align="center">조회수 : <span id="hitSpan"></span></td>
 </tr>
 
 <tr>
 	<td colspan="3" height="200" valign="top">
 		<div style="width: 100%; height: 100%; overflow: auto;"> <!-- 밑으로 긴 글일때 스크롤바가 생성 -->
 			<pre id="content" style="white-space: pre-line; word-break: break-all;"></pre>
 				<span id="contentSpan"></span>
 		</div>
 	</td>
 </tr>
</table>
<input type="button" value="목록" 
onclick="location.href='/miniProject_jQuery/board/boardList.do?pg=${pg }'">

<span id="boardViewSpan">
	<input type="button" value="글수정" id="boardUpdateFormBtn">
	<input type="button" value="글삭제" id="boardDeleteBtn">
</span>

	<input type="button" value="답글" id="boardReplyFormBtn">
</form>

<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="../js/boardView.js"></script>
</body>
</html>
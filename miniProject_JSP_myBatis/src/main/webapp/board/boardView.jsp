<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="board.dao.BoardDAO"%>
<%@page import="board.bean.BoardDTO"%>
    
<%
	//데이터
	int seq = Integer.parseInt(request.getParameter("seq"));
	int pg = Integer.parseInt(request.getParameter("pg"));
	
	//DB
	BoardDAO boardDAO = BoardDAO.getInstance();
	BoardDTO boardDTO = boardDAO.getBoard(seq);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>작성한 글 확인</title>
<style type="text/css">
div{
	font-size: 8pt;
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<%if(boardDTO != null){ %>
<form name="boardViewForm" method="post" action="">
<h3>
	<img src="../image/12.gif" width="70" height="70" alt="별가" 
	onclick="location.href='../index.jsp'" style="cursor: pointer;"> 작성한 글확인
</h3>
<table  width="450" border="2" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
 <tr>
  <td colspan="3">
   <h2><%=boardDTO.getSubject() %></h2>
  </td>
 </tr>
 
 <tr>
 	<td width="150" align="center">글번호 : <%=boardDTO.getSeq() %></td>
 	<td width="150" align="center">작성자 : <%=boardDTO.getId() %></td>
 	<td width="150" align="center">조회수 : <%=boardDTO.getHit() %></td>
 </tr>
 
 <tr>
 	<td colspan="3" height="200" valign="top">
 		<div style="width: 100%; height: 100%; overflow: auto;"> <!-- 밑으로 긴 글일때 스크롤바가 생성 -->
 			<pre style="white-space: pre-line; word-break: break-all;"><%=boardDTO.getContent() %></pre>
 		</div>
 	</td>
 </tr>
</table>
<input type="button" value="목록" onclick="history.go(-1)">
</form>
<%} %>
</body>
</html>
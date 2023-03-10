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
<title>작성한 글확인</title>
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
<table border="1" cellpadding="5" cellspacing="0">
 <tr>
   <th align="center">제목</th>
   <td>
    <input type="text" name="subject" id="subject" size="50" value="<%=boardDTO.getSubject() %>">
  	<div id="subjectDiv" ></div>
   </td>
 </tr>
 
 <tr>
  <th align="center">내용</th>
  <td>
   <textarea type="text" name="content" id="content" cols="65" rows="15"><%=boardDTO.getContent() %></textarea>
   <div id="contentDiv"></div>
  </td>
 </tr>
 
 <tr>
  <td colspan="2" align="center">
   <input type="button" value="목록" onclick=""> 
  </td> 
 </tr>
</table>
</form>
<%} %>
</body>
</html>
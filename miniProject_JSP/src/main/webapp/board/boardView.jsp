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
</head>
<body>
<%if(boardDTO != null){ %>
<form name="boardViewForm" method="post" action="">
작성한 글확인
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
   <textarea type="text" name="content" id="content" cols="65" rows="15" value="<%=boardDTO.getContent() %>"></textarea>
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
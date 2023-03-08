<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.List" %> 
<% 
//데이터

//DB
BoardDAO boardDAO = BoardDAO.getInstance();
List<BoardDTO> list = boardDAO.boardList();

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
</head>
<body>
<h3>
<img src="../image/12.gif" width="80" height="80" alt="JUN" onclick="location.href='../index.jsp'" style="cursor: pointer;"> 목록
</h3>
<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>	
	
	<% if(list != null){ %>
		<% for(BoardDTO boardDTO : list) { %>
			<tr>
				<td align="center"><%=boardDTO.getSeq() %></td>
				<td><%=boardDTO.getSubject() %></td>
				<td align="center"><%=boardDTO.getId() %></td>
				<td align="center"><%=boardDTO.getHit() %></td>
				<td align="center"><%=boardDTO.getLogtime() %></td>
			</tr>
		<%}//for %>
	<%}//if %>		
</table>
</body>
</html>
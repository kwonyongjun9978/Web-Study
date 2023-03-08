<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.List" %> 
<%@page import="java.text.SimpleDateFormat"%>

<% 
		//데이터
		int pg = Integer.parseInt(request.getParameter("pg")); 
		
		//페이징 처리 - 1페이지당 5개씩
		/*
		      startNum  endNum 
		 pg=1 rn>=1 and rn<=5
		 pg=2 rn>=6 and rn<=10
		 pg=3 rn>=11 and rn<=15
		 */
		
		int endNum = pg*5;
		int startNum = endNum-4;

		//DB
		BoardDAO boardDAO = BoardDAO.getInstance();
		List<BoardDTO> list = boardDAO.boardList(startNum, endNum);
		
		//총글수
		int totalA = boardDAO.getTotalA();
		System.out.println(totalA);
		
		//총 페이지수
		int totalP = (totalA+4)/5 ;

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>목록</title>
<style type="text/css">
.subjectA:link{color: black; text-decoration: none;}
.subjectA:visited{color: black; text-decoration: none;}
.subjectA:hover{color: hotpink; text-decoration: underline;}
.subjectA:active{color: black; text-decoration: none;}
</style>
<style>
#currentpagingdiv {float: left; border: 1px red solid; width: 20px; height: 20px; margin-left: 5px; text-align: center;}
#pagingDiv {float: left; width: 20px; height: 20px; margin-left: 5px; text-align: center;}
#currentpaging {color: red; text-decoration: none;}
#paging {color: black; text-decoration: none;}
</style>
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
	<% for(int i=1; i<=totalP; i++) {
		if(i == pg)
			out.print("<div id='currentPagingDiv'><a id='currentPaging' href='/miniProject_JSP/board/boardList.jsp?pg=" + i +"'>" + i + "</a></div>");
		else
			out.print("<div id='pagingDiv'><a id='paging' href='/miniProject_JSP/board/boardList.jsp?pg=" + i +"'>" + i + "</a></div>");
	}%>
	<% if(list != null){ %>
		<% for(BoardDTO boardDTO : list) { %>
			<tr>
				<td align="center"><%=boardDTO.getSeq() %></td>
				<td><a class="subjectA" href=""><%=boardDTO.getSubject() %></a></td>
				<td align="center"><%=boardDTO.getId() %></td>
				<td align="center"><%=boardDTO.getHit() %></td>
				<td align="center">
				<%=new SimpleDateFormat("yyyy.MM.dd.").format(boardDTO.getLogtime())%>
				</td>
			</tr>
		<%}//for %>
	<%}//if %>		
</table>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %> 
<%@ page import="java.util.ArrayList" %> 
<%@ page import="java.util.List" %> 
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="board.bean.BoardPaging"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
#currentPaging{
	color:red;
	border: 1px solid red;
	padding: 5px 5px; /* top, bottom, left, right */
	margin: 5px; /* top, right, bottom, left */
	cursor: pointer;
}
#paging{
	color:black;
	padding: 5px;
	margin: 5px;
	cursor: pointer;
}
</style>
</head>
<body>
<h3>목록</h3>
<table border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>	

<c:if test="${list != null}">
<c:forEach var="boardDTO" items="${list}">
			<tr>
				<td align="center">${boardDTO.seq}</td>
				<td align="center">${boardDTO.subject}</td>
				<td align="center">${boardDTO.id}</td>
				<td align="center">${boardDTO.hit}</td>
				<td align="center">${SimpleDateFormat("yyyy.MM.dd").format(boardDTO.logtime)}</td>
			</tr>
</c:forEach>
</c:if>
</table>
<div style="margin-top: 15px; width: 850px; text-align: center;">
 ${boardPaging.getPagingHTML() }
</div>
<script type="text/javascript">
function boardPaging(pg){
	location.href = "/mvcBoard/board/boardList.do?pg=" +pg;
}
</script>
</body>
</html>
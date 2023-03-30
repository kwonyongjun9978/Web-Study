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
#boardListTable th{
	font-size: 12pt;
}

#boardListTable td{
	font-size: 12pt;
}
</style>
</head>
<body>
<h3>목록</h3>

<input type="text" id="pg" value="${pg }">
<input type="text" id="memId" value="${memId }">
<table id="boardListTable" border="1" cellpadding="5" cellspacing="0" frame="hsides" rules="rows">
	<tr>
		<th width="100">글번호</th>
		<th width="300">제목</th>
		<th width="150">작성자</th>
		<th width="100">조회수</th>
		<th width="150">작성일</th>
	</tr>	

	<!-- 동적처리 -->
</table>
<div id="boardPagingDiv" style="margin-top: 15px; width: 850px; text-align: center;"></div>
<script type="text/javascript">
function boardPaging(pg){
	location.href = "boardList.do?pg=" +pg;
}
</script>
<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script src="../js/boardList.js"></script>
</body>
</html>
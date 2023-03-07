<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %>      
<%
//데이터
request.setCharacterEncoding("UTF-8");

String subject = request.getParameter("subject");
String content = request.getParameter("content");
String name = (String)session.getAttribute("memName");
String id = (String)session.getAttribute("memId");
String email = (String)session.getAttribute("memEmail");

BoardDTO boardDTO = new BoardDTO();
boardDTO.setName(name);
boardDTO.setEmail(email);
boardDTO.setId(id);
boardDTO.setSubject(subject);
boardDTO.setContent(content);

//DB 연동(+ .jar파일 lib폴더에 복사)
BoardDAO boardDAO = BoardDAO.getInstance();
int su =boardDAO.boardWrite(boardDTO);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<% if(su>0){ %>
<h3>글작성 성공</h3>
<%}else {%>
<h3>글작성 실패</h3>
<%} %>
</body>
</html>
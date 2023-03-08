<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="board.bean.BoardDTO" %>
<%@ page import="board.dao.BoardDAO" %> 
<%@ page import="java.util.Map" %>  
<%@ page import="java.util.HashMap" %>      
<%
request.setCharacterEncoding("UTF-8");
//데이터를 가져옴(boardWriteForm에서)
String subject = request.getParameter("subject");
String content = request.getParameter("content");
//세션을 통해서 데이터를 가져옴(톰켓 서버에서)
String name = (String)session.getAttribute("memName");
String id = (String)session.getAttribute("memId");
String email = (String)session.getAttribute("memEmail");

/*
//BoardDTO에 데이터 저장
BoardDTO boardDTO = new BoardDTO();
boardDTO.setName(name);
boardDTO.setEmail(email);
boardDTO.setId(id);
boardDTO.setSubject(subject);
boardDTO.setContent(content);  
*/

//map에 데이터 저장
Map<String, String> map = new HashMap<String, String>();
map.put("id", id);
map.put("name", name);
map.put("email", email);
map.put("subject", subject);
map.put("content", content);

//DB 연동
BoardDAO boardDAO = BoardDAO.getInstance();
//int su =boardDAO.boardWrite(boardDTO);
boardDAO.boardWrite(map);
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>
<script type="text/javascript">
window.onload=function(){
alert("글작성 완료");
location.href="./boardList.jsp";
}
</script>
</body>
</html>
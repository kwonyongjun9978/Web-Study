<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>답글쓰기</title>
<style>
#boardWriteForm div{
	font-size:8pt;
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
<h3>답글쓰기</h3>
<form id="boardReplyForm">
<input type="hidden" name="pg" value="${pg }"/>
<input type="hidden" name="seq" value="${seq }"/>
<table border="1" cellpadding="5" cellspacing="0">
 <tr>
   <th align="center">제목</th>
   <td>
    <input type="text" name="subject" id="subject" style="width: 450px;" placeholder="제목입력">
  	<div id="subjectDiv" ></div>
   </td>
 </tr>
 
 <tr>
  <th align="center">내용</th>
  <td>
   <textarea type="text" name="content" id="content" cols="65" rows="15"></textarea>
   <div id="contentDiv"></div>
  </td>
 </tr>
 
 <tr>
  <td colspan="2" align="center">
   <input type="button" value="답글쓰기" id="boardReplyBtn"> 
   <input type="reset" value="다시작성">
  </td> 
 </tr>
</table>
</form>
<script src="http://code.jquery.com/jquery-3.6.4.min.js"></script>
<script type="text/javascript">
$(function(){
   $('#boardReplyBtn').click(function(){
      $('#subjectDiv').empty();
      $('#contentDiv').empty();
      
      if($('#subject').val() == ''){
         $('#subjectDiv').text('제목을 입력하세요');
         $('#subjectDiv').focus();
      }
      else if($('#content').val() == ''){
         $('#contentDiv').text('내용을 입력하세요');
         $('#contentDIv').focus();
      }else {
         $.ajax({
            type: 'post',
            url: '/miniProject_jQuery/board/boardReply.do',
            data: $('#boardReplyForm').serialize(), //seq, pg, subject, content
            /*2. 'subject='+$('#subject').val()+'&content='+$('#content').val() */
            /*3. {'subject': $('#subject').val(), 'content': $('#content').val()}  */
            success: function(){
               alert('답글작성 완료!!');
               location.href='/miniProject_jQuery/board/boardList.do?pg='+${pg};
            },
            error: function(err){
               console.log(err);
            }
            
         });
      }
   });
});
</script>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="jstlResult.jsp">
	<table border="2" cellpadding="5" cellspacing="0">
		<tr>
  			<th width="70" align="center">이름</th>
  			<td>
  	 			<input type="text" name="name" id="name" style="width: 70px;" placeholder="이름 입력">
  			</td>
   		</tr>
   		
   		<tr>
  			<th width="70" align="center">나이</th>
  			<td>
  	 			<input type="text" name="age" id="age" style="width: 70px;" placeholder="나이 입력">
  			</td>
   		</tr>
   		
   		<tr>
			<th align="center">색깔</th> 
			<td>
				<select name="color" style="width:100px;">
					<optgroup label="색깔골라봐~">
						<option value="red">빨강</option>
						<option value="green">초록</option>
						<option value="blue">파랑</option>
						<option value="magenta">보라</option>
						<option value="cyan">하늘</option>
					</optgroup>
				</select>
			</td>
		</tr>
		
		<tr>
			<th align="center">취미</th> 
			<td>
				<input type="checkbox" name="hobby" id="hobby_1" value="독서">
				<label for="hobby_1">독서</label>
				<input type="checkbox" name="hobby" id="hobby_2" value="영화">
				<label for="hobby_2">영화</label>
				<input type="checkbox" name="hobby" id="hobby_3" value="음악">
				<label for="hobby_3">음악</label>
				<input type="checkbox" name="hobby" id="hobby_4" value="게임">
				<label for="hobby_4">게임</label>
				<input type="checkbox" name="hobby" id="hobby_5" value="쇼핑">
				<label for="hobby_5">쇼핑</label>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="SEND"> 
				<input type="reset" value="CANCEL">
			</td> 
		</tr>
	</table>
</form>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="elInputForm" method="get" action="elResult.jsp">
	<table border="1">
		<tr>
			<td width="70" align="center">X</td>
			<td>
				<input type="text" name="x" placeholder="X값을 입력하세요">
			</td>	
		</tr>
		
		<tr>
			<td align="center">Y</td> 
			<td>
				<input type="text" name="y" placeholder="Y값을 입력하세요">
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="계산">
				<input type="reset" value="취소">
			</td>
		</tr>
	</table>
</form>
</body>
</html>
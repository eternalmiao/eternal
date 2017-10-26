<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加</title>
</head>
<body>
	<form name="form" action="add.action?type=${type}">
	<table align="center" border="5" width="30%">
		<tr>
			<td colspan="2" align="center">添加${title}</td>
		</tr>
		<tr>
			<td>${title}</td>
			<td>
				<input type="text" name="value"/>
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="添加">
			</td>
		</tr>
	</table>
	</form>
</body>
</html>
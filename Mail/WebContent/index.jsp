<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>垃圾邮件过滤系统</title>
	</head>

	<frameset rows="70,*,50" frameborder="no">
		  <frame src="head.jsp" name="topFrame" scrolling="no" noresize="noresize"/>
		  <frameset cols="193,*" frameborder="no">
			    <frame src="left.jsp" name="leftFrame" scrolling="no" noresize="noresize" />
			    <frame src="search.action" name="mainFrame" scrolling="yes" noresize="noresize" />
		  </frameset>
		  <frame src="filter.action" name="filterFrame" scrolling="no" noresize="noresize"/>
		  <noframes>
			<body>您的浏览器无法处理框架！</body>
		  </noframes>
	</frameset>
	
</html>
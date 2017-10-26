<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>Login</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
</script>
<meta name="keywords"
	content="Flat Dark Web Login Form Responsive Templates, Iphone Widget Template, Smartphone login forms,Login form, Widget Template, Responsive Templates, a Ipad 404 Templates, Flat Responsive Templates" />
<link href="css/style2.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link
	href='http://fonts.useso.com/css?family=PT+Sans:400,700,400italic,700italic|Oswald:400,300,700'
	rel='stylesheet' type='text/css'>
<link href='http://fonts.useso.com/css?family=Exo+2' rel='stylesheet'
	type='text/css'>
<!--//webfonts-->
<script src="js/jquery-1.8.3.js"></script>
<style type="text/css">
	.white{
		color:white;
	}
</style>
</head>
<body>
	<script>
		$(document).ready(function(c) {
			$('.close').on('click', function(c) {
				$('.login-form').fadeOut('slow', function(c) {
					$('.login-form').remove();
				});
			});
		});
	</script>
	<!--SIGN UP-->
	<h1>Shopin后台管理登录</h1>
	<div class="login-form">
		<div class="close"></div>
		<div class="head-info">
			<label class="lbl-1"> </label> <label class="lbl-2"> </label> <label
				class="lbl-3"> </label>
		</div>
		<div class="clear"></div>
		<div class="avtar">
			<img src="images/avtar.png" />
		</div>
		<form action=" MgrLogin.do" method="post">
			<input type="text" class="text" name="Username"
				onfocus="this.value = '';"
				onblur="if (this.value == '') {this.value = 'Username';}">
				<c:if test="${requestScope.error==1 }">
				<br />
				<lable class="white">密码错误</lable>
				</c:if>
				<c:if test="${requestScope.error==2 }">
				<br />
				<lable class="white">用户不存在</lable>
				</c:if>
			<div class="key">
				<input type="password" name="Password" onfocus="this.value = '';"
					onblur="if (this.value == '') {this.value = 'Password';}">
				
			</div>
			<div class="signin">
			<input type="submit" value="登录">
		</div>
		</form>
	
	</div>
	<div class="copy-rights">
		<p>
			Copyright &copy; 2015.Company name All rights reserved.BUG
		</p>
	</div>

</body>
</html>
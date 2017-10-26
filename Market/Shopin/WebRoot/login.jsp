<%@page import="cn.bug.bean.*"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" errorPage="404.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>登录</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<!--theme-style-->
<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />	
<!--//theme-style-->
<script src="js/jquery-1.8.3.js"></script>
<!--- start-rate---->
<script src="js/jstarbox.js"></script>
	<link rel="stylesheet" href="css/jstarbox.css" type="text/css" media="screen" charset="utf-8" />
		<script type="text/javascript">
			jQuery(function() {
			jQuery('.starbox').each(function() {
				var starbox = jQuery(this);
					starbox.starbox({
					average: starbox.attr('data-start-value'),
					changeable: starbox.hasClass('unchangeable') ? false : starbox.hasClass('clickonce') ? 'once' : true,
					ghosting: starbox.hasClass('ghosting'),
					autoUpdateAverage: starbox.hasClass('autoupdate'),
					buttons: starbox.hasClass('smooth') ? false : starbox.attr('data-button-count') || 5,
					stars: starbox.attr('data-star-count') || 5
					}).bind('starbox-value-changed', function(event, value) {
					if(starbox.hasClass('random')) {
					var val = Math.random();
					starbox.next().text(' '+val);
					return val;
					} 
				})
			});
		});
		</script>
<!---//End-rate---->
</head>
<body>
<!--header-->
<jsp:include page="header.jsp" flush="true"></jsp:include>
<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1>登录</h1>
		<em></em>
		<h2><a href="index.jsp">主页</a><label>/</label>登录</a></h2>
	</div>
</div>
<!--login-->
<div class="container">
		<div class="login">
		
			<form action="Login.do" method="post">
			<div class="col-md-6 login-do">
				<label id="ck_name" style="color: gray;"></label>
				<div class="login-mail">
					<input type="text" placeholder="Email/phone/name" required="" id="uname" name="uname" onblur="checkName()">
				
					<i  class="glyphicon glyphicon-envelope"></i>
				</div>
				<label id="ck_psw" style="color: gray;">
					<c:if test="${requestScope.errorPSW!=null }">
					<%=request.getAttribute("errorPSW") %>
					</c:if>
				</label>
				<div class="login-mail">
					<input type="password" placeholder="Password" required="" id="uPSW" name="password">
					<i class="glyphicon glyphicon-lock"></i>
				</div>
				   <a class="news-letter " href="#">
						 <label class="checkbox1"><input type="checkbox" name="ck_signPSW" value="1"><i> </i>记住密码</label>
					   </a>
				<label class="hvr-skew-backward">
					<input type="submit" value="登录"/>
				</label>
			</div>
			<script type="text/javascript">
			<!-- 自检用户是否已注册 -->
				function checkName(){
					$.ajax({
						type:"post",
						url:"CheckNameServlet",
						data:"ucount="+$("#uname").val(),
						dataType:"text",
						success: function(json){
							$("#ck_name").text(json);
						}
					});
				}
				
			</script>
			<div class="col-md-6 login-right">
				 <h3>Completely Free Account</h3>
				 
				 <p>Pellentesque neque leo, dictum sit amet accumsan non, dignissim ac mauris. Mauris rhoncus, lectus tincidunt tempus aliquam, odio 
				 libero tincidunt metus, sed euismod elit enim ut mi. Nulla porttitor et dolor sed condimentum. Praesent porttitor lorem dui, in pulvinar enim rhoncus vitae. Curabitur tincidunt, turpis ac lobortis hendrerit, ex elit vestibulum est, at faucibus erat ligula non neque.</p>
				<a href="register.jsp" class=" hvr-skew-backward">注册</a>

			</div>
			
			<div class="clearfix"> </div>
			</form>
		</div>

</div>

<!--//login-->

			<!--brand-->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
	<!--//content-->
		<!--//footer-->

		<!--//footer-->

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/bootstrap.min.js"></script>
 
</body>
</html>

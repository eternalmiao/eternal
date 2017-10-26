<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
		<title>结算</title>
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
		<script type="application/x-javascript">
			addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); }
		</script>
		<!--theme-style-->
		<link href="css/style4.css" rel="stylesheet" type="text/css" media="all" />
		<!--//theme-style-->
		<script src="js/jquery.min.js"></script>
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
				<h1>结算</h1>
				<em></em>
				<h2><a href="index.html">主页</a><label>/</label>结算</h2>
			</div>
		</div>
		
		<!--login-->	
		<div class="container">
			<div class="login">
				<form action="CheckOut.do" method="post">
					<h4>填写订单信息：</h4>
					<div class="col-md-6 login-do">
						<div class="login-mail">
							<input name="receiver" type="text" value="${sessionScope.ShopUser.uname}"  placeholder="收件人姓名">
							<i class="glyphicon glyphicon-user"></i>
						</div>
						<div class="login-mail">
							<input name="rephone" type="text" value="${sessionScope.ShopUser.phone}" placeholder="收件人电话">
							<i class="glyphicon glyphicon-phone"></i>
						</div>
						<div class="login-mail">
							<input name="oaddress" type="text" value="${sessionScope.ShopUser.address}" placeholder="收件人地址">
							<i class="glyphicon glyphicon-envelope"></i>
						</div>
						<div style="text-align: left;margin-bottom: 30px;">
							<p class="money">
								<span>实付款：</span>
								<strong class="realpay" style="color: red;font-size: large;">${param.sum}</strong>
							</p>
						</div>
						<label class="hvr-skew-backward">
							<input type="submit" value="提交订单">
						</label>
					</div>
					<div class="clearfix"> </div>
				</form>
			</div>
		</div>

		<!--//login-->

		<!--brand-->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
		<!--//brand-->
		<!--//content-->
		<!--//footer-->
		
		<!--//footer-->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

		<script src="js/simpleCart.min.js">
		</script>
		<!-- slide -->
		<script src="js/bootstrap.min.js"></script>

	</body>

</html>
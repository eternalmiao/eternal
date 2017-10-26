<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE html>
<html>

	<head>
		<title>修改信息</title>
		<link href="css/bootstrap.css" rel="stylesheet" type="text/css" media="all" />
		<!-- Custom Theme files -->
		<!--theme-style-->
		<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
		<!--//theme-style-->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="keywords" content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
		<script src="js/checkform.js"></script>
		<script type="application/x-javascript">
			addEventListener("load", function() {
				setTimeout(hideURLbar, 0);
			}, false);

			function hideURLbar() {
				window.scrollTo(0, 1);
			}
		</script>
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
						if (starbox.hasClass('random')) {
							var val = Math.random();
							starbox.next().text(' ' + val);
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
				<h1>信息修改</h1>
				<em></em>
				<h2><a href="index.html">主页</a><label>/</label>信息修改</a></h2>
			</div>
		</div>

		<div class="contact">

			<div class="contact-form">
				<div class="container">
					<form action="UpdateInfo.do" method="post">
						<div class="col-md-6 login-do">
							<div class="login-mail">
								<input type="text" placeholder="Name" required="" name="up_name" value="${sessionScope.ShopUser.uname }" >
								<i class="glyphicon glyphicon-user"></i>
							</div>
							<div class="login-mail">
								<input type="text" placeholder="Phone Number" required="" name="up_phone" value="${sessionScope.ShopUser.phone }">
								<i class="glyphicon glyphicon-phone"></i>
							</div>
							<div class="login-mail">
								<input type="text" placeholder="Email" required="" name="up_email" value="${sessionScope.ShopUser.email }">
								<i class="glyphicon glyphicon-envelope"></i>
							</div>
							<div class="login-mail">
								<input type="text" placeholder="Address" required="" name="up_address" value="${sessionScope.ShopUser.address }">
								<i class="glyphicon glyphicon-map-marker"></i>
							</div>
							<div class="login-mail">
								<input type="password" placeholder="Password" required="" name="up_password" >
								<i class="glyphicon glyphicon-lock"></i>
							</div>
							<label class="hvr-skew-backward">
							<input type="submit" value="完成">
				</label>

						</div>
						<div class="clearfix"> </div>
					</form>
				</div>
			</div>
		</div>

		<!--//contact-->
		<!--brand-->
		
		<!--//brand-->
	
		<!--//content-->
		<!--//footer-->
		<jsp:include page="footer.jsp" flush="true"></jsp:include>
		<!--//footer-->
		<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

		<script src="js/simpleCart.min.js">
		</script>
		<!-- slide -->
		<script src="js/bootstrap.min.js"></script>

	</body>

</html>

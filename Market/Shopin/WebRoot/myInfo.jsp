<%@page import="cn.bug.dao.impl.ShopUserDaoImpl"%>
<%@page import="cn.bug.dao.ShopUserDao"%>
<%@page import="cn.bug.bean.ShopUser"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>

<head>
<title>个人主页</title>
<link href="css/bootstrap.css" rel="stylesheet" type="text/css"
	media="all" />
<!-- Custom Theme files -->
<!--theme-style-->
<link href="css/style.css" rel="stylesheet" type="text/css" media="all" />
<!--//theme-style-->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords"
	content="Shopin Responsive web template, Bootstrap Web Templates, Flat Web Templates, AndroId Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<style type="text/css">
.hvrr-skew-backward a,.hvr-skew-backward a {
	color: white;
	text-decoration: none;
}
</style>
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
<link rel="stylesheet" href="css/jstarbox.css" type="text/css"
	media="screen" charset="utf-8" />
<script type="text/javascript">
	
	jQuery(function() {
		jQuery('.starbox')
				.each(
						function() {
							var starbox = jQuery(this);
							starbox
									.starbox(
											{
												average : starbox
														.attr('data-start-value'),
												changeable : starbox
														.hasClass('unchangeable') ? false
														: starbox
																.hasClass('clickonce') ? 'once'
																: true,
												ghosting : starbox
														.hasClass('ghosting'),
												autoUpdateAverage : starbox
														.hasClass('autoupdate'),
												buttons : starbox
														.hasClass('smooth') ? false
														: starbox
																.attr('data-button-count') || 5,
												stars : starbox
														.attr('data-star-count') || 5
											})
									.bind(
											'starbox-value-changed',
											function(event, value) {
												if (starbox.hasClass('random')) {
													var val = Math.random();
													starbox.next().text(
															' ' + val);
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
			<h1>个人信息</h1>
			<em></em>
			<h2>
				<a href="index.html">主页</a><label>/</label>个人信息</a>
			</h2>
		</div>
	</div>

	<div class="contact">

		<div class="contact-form">
			<div class="container">
				<div class="col-md-6 contact-left">
					<div class="address">
						<div class=" address-grid ">
							<i class="glyphicon glyphicon-user"></i>
							<div class="address1">
								<h3>用户名:</h3>
								<p>${sessionScope.ShopUser.uname }</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class=" address-grid">
							<i class="glyphicon glyphicon-map-marker"></i>
							<div class="address1">
								<h3>地址:</h3>
								<p>${sessionScope.ShopUser.address }</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class=" address-grid ">
							<i class="glyphicon glyphicon-phone"></i>
							<div class="address1">
								<h3>
									手机号码:
									<h3>
										<p>${sessionScope.ShopUser.phone }</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class=" address-grid ">
							<i class="glyphicon glyphicon-envelope"></i>
							<div class="address1">
								<h3>Email:</h3>
								<p>${sessionScope.ShopUser.email }</p>
							</div>
							<div class="clearfix"></div>
						</div>
						<label class="hvr-skew-backward"> <a href="updateInfo.jsp">修改信息</a>
						</label> <label class="hvrr-skew-backward"> <a href="Order.do">查看订单</a>
						</label>
					</div>
				</div>
				<div class="col-md-6 contact-top">
					<div class="facts">
						<p>There are many variations of passages of Lorem Ipsum
							available, but the majority have suffered alteration in some
							form, by injected humour, or randomised words which don't look
							even slightly believable. If you are going to use a passage of
							Lorem Ipsum, you need to be sure there isn't anything
							embarrassing hidden in the middle of text. All the Lorem Ipsum
							generators on the Internet tend to repeat predefined chunks as
							necessary, making this the first true generator on the Internet.
							It uses a dictionary of over 200 Latin words, combined</p>
						<ul>
							<li><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Research</li>
							<li><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Design
								and Development</li>
							<li><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Porting
								and Optimization</li>
							<li><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>System
								integration</li>
							<li><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Verification,
								Validation and Testing</li>
							<li><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>Maintenance
								and Support</li>
						</ul>
					</div>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>

	<!--//contact-->
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

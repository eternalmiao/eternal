<%@page import="cn.bug.framework.GetPhoto"%>
<%@page import="cn.bug.bean.Orther"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" errorPage="404.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html>
<html>
<head>
<title>个人订单</title>
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
<script type="application/x-javascript">
	 addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 
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
	function submit_comm(id)
	{
		var c=document.getElementById("in_comm");
		var s=document.getElementById("in_score");
		var des="AddComm.do"+"?content="+c.value+"&oid="+id+"&cscore="+s.value;
		location.href=des;		
	}
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
			<h1>个人订单</h1>
			<em></em>
			<h2>
				<a href="Index.do">主页</a><label>/</label>个人订单</a>
			</h2>
		</div>
	</div>
	<!--login-->
	<script>
		$(document).ready(function(c) {
			$('.close1').on('click', function(c) {
				$('.cart-header').fadeOut('slow', function(c) {
					$('.cart-header').remove();
				});
			});
		});
	</script>
	<script>
		$(document).ready(function(c) {
			$('.close2').on('click', function(c) {
				$('.cart-header1').fadeOut('slow', function(c) {
					$('.cart-header1').remove();
				});
			});
		});
	</script>
	<script>
		$(document).ready(function(c) {
			$('.close3').on('click', function(c) {
				$('.cart-header2').fadeOut('slow', function(c) {
					$('.cart-header2').remove();
				});
			});
		});
	</script>
	<div class="container">
		<div class="check-out">
			<div class="bs-example4" data-example-id="simple-responsive-table">
				<div class="table-responsive">
					<table class="table-heading simpleCart_shelfItem" >
						<tr>
							<th class="table-grid">商品</th>

							<th>价格</th>
							<th>购买数量</th>
							<th>总价</th>
							<th>订单状态</th>
						</tr>
						<c:forEach items="${oAndcs }" var="oc">
							<tr class="cart-header">

								<td class="ring-in"><a href="SingleShow.do?gid=${oc.order.it.goods.gid }" class="at-in"><img
										src="${oc.order.it.goods.imgUrl }/1.jpg" class="img-responsive" alt=""></a>

									<div class="sed">
										<h5>
											<a href="SingleShow.do?gid=${oc.order.it.goods.gid }">${oc.order.it.goods.gname }</a>
										</h5>
										<p>${oc.order.it.goods.brand.bname }</p>

									</div>
									<div class="clearfix"></div>
								<td>${oc.order.it.goods.new_price }</td>
								<td>${oc.order.price/oc.order.it.goods.new_price }</td>
								<td class="item_price">${oc.order.price }</td>
								<td>${list[oc.order.ostatus] }</td>
								<c:if test="${oc.order.ostatus==1 }">
									<td><a class="item_add hvr-skew-backward" href="ChangeStatus.do?ostatus=2&oid=${oc.order.oid }">确认收货</a></td>
								</c:if>
								<c:if test="${oc.order.ostatus==2 }">
									<td><a class="item_add hvr-skew-backward" href="ChangeStatus.do?ostatus=3&oid=${oc.order.oid }">申请退还货</a></td>
								</c:if>
							</tr>
							<c:choose>
								<c:when test="${oc.order.ostatus==2 }">
									<tr>
										<td><textarea name="comm" cols="60" rows="5" id="in_comm">请输入你的评价</textarea></td>
									<td>请选择星级：<select name="csc" id="in_score">
										<option value="1">1星</option>
										<option value="2">2星</option>
										<option value="3">3星</option>
										<option value="4">4星</option>
										<option value="5">5星</option>
									</select></td>
									<td><input type="button" value="评论" onclick="submit_comm(${oc.order.oid})" id="sendcomm"/></td>					
									</tr>
								</c:when>
								<c:when test="${oc.order.ostatus==5&&oc.comm!=null }">
									<tr>
										<td>评论:<p>${oc.comm.content }</p></td>
									</tr>
								</c:when>
							</c:choose>
						</c:forEach>
					</table>
					<center>
						<a href="Order.do?index=1">首页</a>
						<a href="Order.do?index=${pageIndex-1 }">上一页</a>
						<a href="Order.do?index=${pageIndex+1 }">下一页</a>
					</center>
				</div>
			</div>
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

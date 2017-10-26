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
    
<title>Wishlist</title>
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
		<h1>愿望清单</h1>
		<em></em>
		<h2><a href="index.html">Home</a><label>/</label>愿望清单</h2>
	</div>
</div>

<!--login-->

	<c:if test="${!empty sessionScope.Wishlist}">
		<c:forEach var="wishlist" items="${sessionScope.Wishlist}" varStatus="i">
			<script>$(document).ready(function(c) {
					$('#close${wishlist.wid}').on('click', function(c){
						$('.cart-header${wishlist.wid}').fadeOut('slow', function(c){
							$('.cart-header${wishlist.wid}').remove();
						});
						});	  
					});
			</script>
		</c:forEach>
	</c:if>


	<div class="container">
		<div class="check-out">
			<div class="bs-example4" data-example-id="simple-responsive-table">
				<div class="table-responsive">
					<table class="table-heading simpleCart_shelfItem">
						<tr>
							<th class="table-grid">商品信息</th>
							<th>单价</th>
						</tr>				
						<c:if test="${!empty sessionScope.Wishlist}">
							<c:forEach var="wishlist" items="${sessionScope.Wishlist}" varStatus="i">
								<tr class="cart-header${wishlist.wid}">
									<td class="ring-in">
										<a href="SingleShow.do?gid=${wishlist.goods.gid }" class="at-in"><img src="${wishlist.goods.imgUrl}/1.jpg" class="img-responsive" alt="商品"></a>
										<div class="sed">
											<h5><a href="SingleShow.do?gid=${wishlist.goods.gid }">${wishlist.goods.gname}</a></h5>
											<p>${wishlist.goods.description}</p>
										</div>
										<div class="clearfix"> </div>
									</td>
									<td>
										<div class="old_price" style="text-decoration: line-through;">${wishlist.goods.old_price}</div>
										<div class="new_price" style="color: red;">${wishlist.goods.new_price}</div>
									</td>
									<td class="add-check">
										<a id="close${wishlist.wid}" class="item_remove hvr-skew-backward" href="DelWishlist.do?wid=${wishlist.wid}">删除</a>
									</td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
			
				</div>
			</div>
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
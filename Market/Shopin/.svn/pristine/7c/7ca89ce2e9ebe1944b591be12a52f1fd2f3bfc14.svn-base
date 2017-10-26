<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
<title>购物车</title>
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
		<script type="text/javascript">
	$(document).ready(function(){
          var total = 0;
          var item = $(".item_price");
          for(var i=0; i<item.size(); i++) {
        	  total += parseFloat(item.get(i).innerHTML, 10);
          }
          $(".sum").text("￥" + total);          
        	    
          $("#checkout").attr("href", function(i,origValue){
        	      return origValue + "?sum=" + total; 
          });
        
        	
    }
	);
    </script>
<!---//End-rate---->
</head>
<body>
<!--header-->
<jsp:include page="header.jsp" flush="true"></jsp:include>

<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1>购物车</h1>
		<em></em>
		<h2><a href="index.html">主页</a><label>/</label>购物车</h2>
	</div>
</div>

<!--login-->

	<c:if test="${!empty sessionScope.CartList}">
		<c:forEach var="cart" items="${sessionScope.CartList}" varStatus="i">
			<script>$(document).ready(function(c) {
					$('#close${cart.caid}').on('click', function(c){
						$('.cart-header${cart.caid}').fadeOut('slow', function(c){
							$('.cart-header${cart.caid}').remove();
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
						<th>尺码</th>
						<th>单价</th>
						<th>数量</th>
						<th>总价</th>
					</tr>				
					<c:if test="${!empty sessionScope.CartList}">
						<c:forEach var="cart" items="${sessionScope.CartList}" varStatus="i">
							<tr class="cart-header${cart.caid}">
								<td class="ring-in">
									<a href="SingleShow.do?gid=${cart.inventory.goods.gid }" class="at-in"><img src="${cart.inventory.goods.imgUrl}/1.jpg" class="img-responsive" alt="商品"></a>
									<div class="sed">
										<h5><a href="SingleShow.do?gid=${cart.inventory.goods.gid }">${cart.inventory.goods.gname}</a></h5>
										<p>${cart.inventory.goods.description}</p>
									</div>
									<div class="clearfix"> </div>
								</td>
								<td>${cart.inventory.gsize}</td>
								<td>
									<div class="old_price" style="text-decoration: line-through;">${cart.inventory.goods.old_price}</div>
									<div class="new_price" style="color: red;">${cart.inventory.goods.new_price}</div>
								</td>
								<td>
				 					<div class="quantity"> 
										<div class="quantity-select">                           
											<div class="entry value-minus">&nbsp;</div>
											<div class="entry value" id="${cart.caid}"><span>${cart.canum}</span></div>
											<div class="entry value-plus active">&nbsp;</div>
										</div>
									</div>
								</td>
								<td class="item_price">${cart.inventory.goods.new_price * cart.canum}</td>
								<td class="add-check">
									<a class="item_add hvr-skew-backward"  href="AddToWishlist.do?caid=${cart.caid}&gid=${cart.inventory.goods.gid}">移入收藏夹</a>
									<a id="close${cart.caid}" class="item_remove hvr-skew-backward" href="DelCart.do?caid=${cart.caid}">删除</a>
								</td>
							</tr>
						</c:forEach>
					</c:if>
				</table>
			</div>
		</div>
		<div style="overflow: hidden;">
			<div style="float: left;">
				<span>合计（不含运费）：</span>
				<strong><em class="sum" style="color: red"></em></strong>
			</div>
			<div class="produced" style="float:right; position: relative;">
					<a id="checkout" href="checkout.jsp" class="hvr-skew-backward">结算</a>
			</div>
		</div>
	</div>
</div>
 	<script>
	    $('.value-plus').on('click', function(){
	    	var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
	    	divUpd.text(newVal);
	   		var caid = divUpd.attr("id");
	   		changeCanum(caid, newVal);
	    });
	
	    $('.value-minus').on('click', function(){
	    	var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
	    	if(newVal>=1) {
	    		divUpd.text(newVal);
		   		var caid = divUpd.attr("id");
		   		changeCanum(caid, newVal);
	    	}

	    });
	     
    	function changeCanum(caid, newVal){
    		$.ajax({
    		type:"post",
    		url:"ChangeCanumServlet",
    		data : "caid=" + caid + "&canum=" + newVal,
    		dataType:"text",
    		success:function(json){
    			window.location.href="Cart.do";
    		}
    		});
    	}    
	</script>
	
	
	
<!--//login-->


<!--brand-->
<jsp:include page="footer.jsp" flush="true"></jsp:include>
<!--//brand-->

	<!--//content-->
	<!--//footer-->
	
		<!--//footer-->
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->

	<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/bootstrap.min.js"></script>
</body>
</html>
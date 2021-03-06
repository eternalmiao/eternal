<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>商品详情</title>
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
<link href="css/form.css" rel="stylesheet" type="text/css" media="all" />

		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<style type="text/css">
			.choosesize{
				color: black;
				border: #333333;
				border-color: black; 
				border-style: double; 
				border-top-width: 1px; 
				border-right-width: 1px; 
				border-bottom-width: 1px; 
				border-left-width: 1px;		
			}
			.cho{
				color: red;
				border: #333333;
				border-color: red; 
				border-style: double; 
				border-top-width: 1px; 
				border-right-width: 1px; 
				border-bottom-width: 1px; 
				border-left-width: 1px;
			}
		</style>
		<script type="text/javascript">
			function addcart(){
				var cart = document.getElementsByClassName("cho");
				var buynum = document.getElementById("buynum");
				if(cart.length>0)
				{
					alert("已加入购物车！");
					location.href="Single.do?dowork=cart&buynum="+buynum.innerText+"&size="+cart[0].innerText+"&gid="+${goods.gid};
				}
				else{
					var size = document.getElementById("size");
					size.innerText="请先选择您的码数！";
				}
			}
			function choose(num)
			{	
				var good= document.getElementById(num);
				var size = document.getElementById("size");
				var ch = document.getElementsByClassName("cho");
				if(ch.length>0)
				{
					ch[0].setAttribute("class","choosesize");
				}
				size.innerText="";
				good.setAttribute("class","cho");
				checkSize(num);
			}
		   	function checkSize(num){
		    	//声明此为ajax异步刷新,ajax是jQuery的记得导入包
		    	//格式：$.ajax({type,url,data,dataType,success:function(json)});
		    		$.ajax({
		    		//type  请求的类型   get或者post，
		    		type:"post",
		    		//ajax提交到哪里
		    		url:"SingleSizeServlet",
		    		//提交的参数，一种是text 还有json的写法
		    		data : "size="+num+"&gid="+${goods.gid },
		    		//返回数据的类型    text，xml，json
		    		dataType:"text",
		    		//ajax成功之后的回调函数，json为ajax返回的数据
		    		success:function(json){
		    		//	$("#cheacks").text(json);
		    		//	alter("a");
		    		$("#checksize").text(json);
		    		}
		    		});
		    	}
		</script>
</head>
</head>
<body>
<!--header-->
<jsp:include page="header.jsp" flush="true"></jsp:include>
<!--banner-->
<div class="banner-top">
	<div class="container">
		<h1>单品详情</h1>
		<em></em>
		<h2><a href="index.html">主页</a><label>/</label>单品</a></h2>
	</div>
</div>
<div class="single">

<div class="container">
<div class="col-md-9">
	<div class="col-md-5 grid">		
		<div class="flexslider">
			  <ul class="slides">
			    <li data-thumb="${img[0] }">
			        <div class="thumb-image"> <img src="${img[0] }" data-imagezoom="true" class="img-responsive"> </div>
			    </li>
			    <li data-thumb="${img[1] }">
			         <div class="thumb-image"> <img src="${img[1] }" data-imagezoom="true" class="img-responsive"> </div>
			    </li>
			    <li data-thumb="${img[2] }">
			       <div class="thumb-image"> <img src="${img[2] }" data-imagezoom="true" class="img-responsive"> </div>
			    </li> 
			  </ul>
		</div>
	</div>	
<div class="col-md-7 single-top-in">
						<div class="span_2_of_a1 simpleCart_shelfItem">
				<h3>${goods.gname } </h3>
				<p class="in-para">专柜品质，纯棉质量，立体裁剪，今日特价冲量秒杀</p>
			    <div class="price_single">
				  <span class="reducedfrom item_price">￥${goods.new_price }</span>
				  <p style="text-decoration:line-through">￥${goods.old_price }</p>
				 <div class="clearfix"></div>
				</div>
				<h4 class="quick">请选择您的码数：</h4>
					<c:if test="${!empty requestScope.inve}">
						<c:forEach var="in" items="${requestScope.inve}" varStatus="i" >
							<c:choose>
								<c:when test="${in.gsize=='S' }">
									<label class="choosesize" onclick="choose('S')" id="S" >S</label>&nbsp;&nbsp;
								</c:when>
								<c:when test="${in.gsize=='M' }">
									<label class="choosesize" onclick="choose('M')" id="M">M</label>&nbsp;&nbsp;
								</c:when>
								<c:when test="${in.gsize=='L' }">
									<label class="choosesize" onclick="choose('L')" id="L">L</label>&nbsp;&nbsp;
								</c:when>
								<c:when test="${in.gsize=='XL' }">
									<label class="choosesize" onclick="choose('XL')" id="XL">XL</label>&nbsp;&nbsp;
								</c:when>
								<c:when test="${in.gsize=='XXL' }">
									<label class="choosesize" onclick="choose('XXL')" id="XXL">XXL</label>&nbsp;&nbsp;
								</c:when>
							</c:choose>							
						</c:forEach>
					</c:if>
				<label style="color: red" id="size"></label>
	
	
			    <div class="wish-list">
				 	<ul>
				 		<li class="wish">
				 		<c:if test="${wish==0 }">
					 		<a href="Single.do?dowork=wishlist&gid=${goods.gid }">
					 		<span class="glyphicon glyphicon-check" aria-hidden="true"></span>添加收藏</a>				 		
				 		</c:if>
				 		<c:if test="${wish==1 }">
					 		<a>
					 		<span class="glyphicon glyphicon-check" aria-hidden="true"></span>已收藏</a>				 		
				 		</c:if>
				 		</li>
				 	</ul>
				 </div>
				 <div class="quantity"> 
								<div class="quantity-select">                           
									<div class="entry value-minus">&nbsp;</div>
									<div class="entry value"><span>1</span></div>
									<div class="entry value-plus active">&nbsp;</div>
								</div>
								<li>库存：<label id="checksize">${numcount }</label></li>
								<label id="buynum" hidden="hidden">1</label>
							</div>
							<!--quantity-->
	<script>
    $('.value-plus').on('click', function(){
    	var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)+1;
    	var num = document.getElementById("checksize");
    	if(newVal<=num.innerText)divUpd.text(newVal);
    	var buy = document.getElementById("buynum");
    	buy.innerText=newVal;
    });

    $('.value-minus').on('click', function(){
    	var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10)-1;
    	if(newVal>=1) divUpd.text(newVal);
    	var buy = document.getElementById("buynum");
    	buy.innerText=newVal;
    });
	</script>
	<!--quantity-->
				 
			    <a onclick="addcart()" class="add-to item_add hvr-skew-backward">加入购物车</a>
			<div class="clearfix"> </div>
			</div>
		
					</div>
			<div class="clearfix"> </div>
			<!---->
			<div class="tab-head">
			 <nav class="nav-sidebar">
		<ul class="nav tabs">
          <li class="active"><a href="#tab1" data-toggle="tab" style="color: black" >商品详情</a></li>
          <li class=""><a href="#tab2" data-toggle="tab" style="color: black" >商品预览</a></li> 
          <li class=""><a href="#tab3" data-toggle="tab" style="color: black" >商品评论</a></li>  
		</ul>
	</nav>
	<div class="tab-content one">
<div class="tab-pane active text-style" id="tab1">
 	<div class="facts">
		<p style="color: black">${goods.description }</p>
										<ul style="font-size: large;">
											<li style="color: red" ><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>服装类型：${goods.type.tname }</li>											
											<li style="color: red"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>适用人群：
													<c:choose>
														<c:when test="${goods.gcategories==1 }">
														男装
														</c:when>
														<c:when test="${goods.gcategories==2}">
														女装
														</c:when>
														<c:otherwise>
														童装
														</c:otherwise>
													</c:choose>
														</li>
											<li style="color: red"><span class="glyphicon glyphicon-ok" aria-hidden="true"></span>服装品牌：${goods.brand.bname }</li>
										</ul>						        
	</div>

</div>
<div class="tab-pane text-style" id="tab2">
	
									<div class="facts">									
										<p style="color: black">以下为服装的参考图片：</p>
										<ul>
											   <c:if test="${!empty requestScope.imli}">
											      <c:forEach var="ima" items="${requestScope.imli}" varStatus="i" >
													<li><img src="${ima }" ></li>
											      </c:forEach>
											   </c:if>
										</ul>
							        </div>	

</div>
<div class="tab-pane text-style" id="tab3">

									 <div class="facts">
									 	<p style="color: black">以下为商品的评论：</p>
									 	<c:if test="${!empty requestScope.comlist}">
											<c:forEach var="com" items="${requestScope.comlist}" varStatus="i" >
									 	 	<hr>					
											<ul>
												<li style="color: black; font-size: large;">${com.content }</li>
												<li>评分：${com.csore }&nbsp&nbsp&nbsp&nbsp&nbsp时间：${com.ctime }&nbsp&nbsp&nbsp&nbsp&nbsp码数：${com.gOrder.it.gsize }<div align="right">用户:${com.user.uname }</div></li>											
											</ul>
											</c:forEach>
										</c:if> 
							     </div>	    
							     </div>	

 </div>
  
  </div>
  <div class="clearfix"></div>
  </div>
			<!---->	
</div>
<!----->

	</div>
	</div>
			<!--brand-->
<jsp:include page="footer.jsp" flush="true"></jsp:include>
	<!--//content-->
		<!--//footer-->

		<!--//footer-->
<script src="js/imagezoom.js"></script>

	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script defer src="js/jquery.flexslider.js"></script>
<link rel="stylesheet" href="css/flexslider.css" type="text/css" media="screen" />

<script>
// Can also be used with $(document).ready()
$(window).load(function() {
  $('.flexslider').flexslider({
    animation: "slide",
    controlNav: "thumbnails"
  });
});
</script>

	<script src="js/simpleCart.min.js"> </script>
<!-- slide -->
<script src="js/bootstrap.min.js"></script>


</body>
</html>
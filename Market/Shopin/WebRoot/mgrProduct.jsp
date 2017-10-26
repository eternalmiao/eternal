<%@page import="cn.bug.bean.Manager"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN"
"http://www.w3.org/TR/html4/strict.dtd">


<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>商品管理</title>
		<link type="text/css" rel="stylesheet" href="css/style1.css" />
		<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
		<script type="text/javascript" src="js/menu.js"></script>
		<style type="text/css">
			table{
				border: none;
				border-style: solid;
				border-collapse: collapse;
				/*margin: 0px;*/
			}
			td,th{
				border: solid #000 1px;
			}
		</style>
	<script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript">
	function findGoods() {
		var gca = document.getElementById("gcategories").value;
		var gty = document.getElementById("gtype").value;
		var brand = document.getElementById("brand").value;

		var gca_flag = document.getElementById("gcategories").selectedIndex;
		var gty_flag = document.getElementById("gtype").selectedIndex;
		var brand_flag = document.getElementById("brand").selectedIndex;
		location.href = "MgrProduct.do?gcategories=" + gca + "&gtype=" + gty
				+ "&brand=" + brand + "&gca_flag=" + gca_flag + "&gty_flag="
				+ gty_flag + "&brand_flag=" + brand_flag;
	}
	
	//$("#dele_btn").click(function(){
   // alert("段落被点击了。");
	//});
	function deleGood(gid){
		alert("是否删除？"+gid);
		location.href="MgrProductDele.do?GoodId="+gid;
	}
	window.onload = function() {
		var flag1 =
<%=request.getAttribute("gca_flag")%>
	var flag2 =
<%=request.getAttribute("gty_flag")%>
	var flag3 =
<%=request.getAttribute("brand_flag")%>
	document.getElementById("gcategories").selectedIndex = flag1;
		document.getElementById("gtype").selectedIndex = flag2;
		document.getElementById("brand").selectedIndex = flag3;
	}
</script>
	</head>

	<body>
	
		<div class="top"></div>
		<div id="header">
			<div class="logo">Shopin后台管理系统</div>
			<div class="navigation">
				<ul>
					<li>欢迎您！</li>
					<li><a href="">${mgr.mname}</a></li>
					<li><a href="mgrchangepsw.jsp">修改密码</a></li>
					<li><a href="MgrCancel.do">退出</a></li>
				</ul>
			</div>
		</div>
		<div id="content">
			<div class="left_menu">
				<ul id="nav_dot">

					<li>
						<h4 class="M2"><span></span>订单处理</h4>
						<div class="list-item none">
							<a href="CheckCommand.do?ostatus=0">待发货</a>
							<a href="CheckCommand.do?ostatus=1">发货中</a>
							<a href="CheckCommand.do?ostatus=2">已收货</a>
							<a href="CheckCommand.do?ostatus=5">已评价</a>
							<a href="CheckCommand.do?ostatus=3">退换货中</a>
							<a href="CheckCommand.do?ostatus=4">已退款</a>
						</div>
					</li>
					<li>
						<h4 class="M3"><span></span>商品管理</h4>
						<div class="list-item none">
							<a href="MgrProduct.do">商品查询</a>
							<a href="AddGoodsShow.do">添加商品</a>
								<a href="TrendShow.do">推荐商品</a>
						</div>
					</li>
					
				</ul>
			</div>
			<div class="m-right">
				<div class="right-nav">
					<ul>
						<li><img src="images/home.png"></li>
						<li style="margin-left:25px;">您当前的位置：</li>
						<li><a href="#">商品管理</a></li>
					</ul>
				</div>
				<div class="main">
						<lable>种类</lable>
	<select id="gcategories">
		<option value="">所有种类</option>
		<option value="1">男</option>
		<option value="2">女</option>
		<option value="3">儿童</option>
	</select>
	<lable>类型</lable>
	<select id="gtype">
		<option value="">所有类型</option>
		<c:forEach items="${requestScope.gList}" var="Glists">
			<option value="${Glists.tid}">${Glists.tname}</option>
		</c:forEach>
	</select>
	<lable>品牌</lable>
	<select id="brand">
		<option value="">所有品牌</option>
		<c:forEach items="${requestScope.bList }" var="Blists">
			<option value="${Blists.bid }">${Blists.bname}</option>
		</c:forEach>
	</select>
	<input type="button" value="确定" onclick="findGoods()">
	<hr />
	<table border="1" width="60%"  style="text-align:center;">
		<tr>
			<th>商品编号</th>
			<th>商品种类</th>
			<th>商品类型</th>
			<th>商品品牌</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>商品库存</th>
			<th>操作</th>
		</tr>
		<c:forEach items="${pageGDs.list}" var="Good">
			<tr>
				<td><a href="">${Good.gid}</a></td>
				<td>${GCA[(Good.gcategories)-1]}</td>
				<td>${Good.type.tname }</td>
				<td>${Good.brand.bname }</td>
				<td>${Good.gname }</td>
				<td>${Good.new_price}</td>
				<td><a href="MgrInventory.do?gid=${Good.gid }">查看库存</a></td>
				<td><input type="button" value="删除" id="dele_btn" onclick="deleGood(${Good.gid})">
				&nbsp;&nbsp;<a href="UpdateGoodsShow.do?gid=${Good.gid }">修改</a>
				&nbsp;&nbsp;<a href="AddToTrend.do?gid=${Good.gid }">加入推荐</a></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a
			href="MgrProduct.do?gca_flag=${gca_flag}&&gty_flag=${gty_flag}&&brand_flag=${brand_flag}
			&&gcategories=${gcategories }&&gtype=${gtype }&&brand=${brand }
			&&index=1">首页</a>
		<c:if test="${pageGDs.pageIndex>1}">
			<a
			href="MgrProduct.do?gca_flag=${gca_flag}&&gty_flag=${gty_flag}&&brand_flag=${brand_flag}
			&&gcategories=${gcategories }&&gtype=${gtype }&&brand=${brand }
			&&index=${pageGDs.pageIndex-1 }">上一页</a>
		</c:if>
		<c:if test="${pageGDs.pageIndex<=1}">
			<label>上一页</label>
		</c:if>
		<c:if test="${pageGDs.pageIndex<pageGDs.pageCount}">
			<a
			href="MgrProduct.do?gca_flag=${gca_flag}&&gty_flag=${gty_flag}&&brand_flag=${brand_flag}
			&&gcategories=${gcategories }&&gtype=${gtype }&&brand=${brand }
			&&index=${pageGDs.pageIndex+1 }">下一页</a>
		</c:if>
		<c:if test="${pageGDs.pageIndex>=pageGDs.pageCount}">
			<label>下一页</label>
		</c:if>
		<a
			href="MgrProduct.do?gca_flag=${gca_flag}&&gty_flag=${gty_flag}&&brand_flag=${brand_flag}
			&&gcategories=${gcategories }&&gtype=${gtype }&&brand=${brand }
			&&index=${pageGDs.pageCount}">末页</a>
		<label>当前是${requestScope.pageGDs.pageIndex}页/共${requestScope.pageGDs.pageCount}页</label>
	</div>
				</div>
			</div>
		</div>
		<div class="bottom"></div>
		<div id="footer">
			<p class="footer-class">Copyright &copy; 2016.Company name All rights reserved.BUG</p>
		</div>
		<script>
			navList(12);
		</script>
	</body>

</html>

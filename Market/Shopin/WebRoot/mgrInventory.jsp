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
		<title>库存管理</title>
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
						<li><a href="#">库存管理</a></li>
					</ul>
				</div>
	<div class="main">
	<form action="InventorySave.do?gid=${goods.gid }" method="post">
	<table border="1" width="60%"  style="text-align:center;">
		<tr>
			<th>商品编号</th>
			<th>商品种类</th>
			<th>商品类型</th>
			<th>商品品牌</th>
			<th>商品名称</th>
			<th>商品价格</th>
			<th>尺寸</th>
			<th>库存</th>
		</tr>
		<tr>
				<td><a href="">${goods.gid}</a></td>
				<td>${GCA[(goods.gcategories)-1]}</td>
				<td>${goods.type.tname }</td>
				<td>${goods.brand.bname }</td>
				<td>${goods.gname }</td>
				<td>${goods.new_price}</td>
				<td>S</td>
				<c:set var="flag" value="true" />
				<c:forEach items="${ilist }" var="inv">
				<c:if test="${flag }">
						<c:if test="${inv.gsize eq 'S' }">
							<td><input type="text" name="S" value="${inv.gnum }"></td>
							<c:set var="flag" value="false"></c:set>
						</c:if>
						
				</c:if>
				</c:forEach>
				<c:if test="${flag}">
							<td><a href="AddInventory.do?gid=${goods.gid }&size=S">添加</a></td>
				</c:if>
			</tr>
			<tr>
				<td><a href="">${goods.gid}</a></td>
				<td>${GCA[(goods.gcategories)-1]}</td>
				<td>${goods.type.tname }</td>
				<td>${goods.brand.bname }</td>
				<td>${goods.gname }</td>
				<td>${goods.new_price}</td>
				<td>M</td>
				<c:set var="flag" value="true" />
				<c:forEach items="${ilist }" var="inv">
				<c:if test="${flag }">
						<c:if test="${inv.gsize eq 'M' }">
							<td><input type="text" name="M" value="${inv.gnum }"></td>
							<c:set var="flag" value="false"></c:set>
						</c:if>
						
				</c:if>
				</c:forEach>
				<c:if test="${flag}">
							<td><a href="AddInventory.do?gid=${goods.gid }&size=M">添加</a></td>
				</c:if>
			</tr>
			
			<tr>
				<td><a href="">${goods.gid}</a></td>
				<td>${GCA[(goods.gcategories)-1]}</td>
				<td>${goods.type.tname }</td>
				<td>${goods.brand.bname }</td>
				<td>${goods.gname }</td>
				<td>${goods.new_price}</td>
				<td>L</td>
				<c:set var="flag" value="true" />
				<c:forEach items="${ilist }" var="inv">
				<c:if test="${flag }">
						<c:if test="${inv.gsize == 'L' }">
							<td><input type="text" name="L" value="${inv.gnum }"></td>
							<c:set var="flag" value="false"></c:set>
						</c:if>
						
				</c:if>
				</c:forEach>
				<c:if test="${flag }">
							<td><a href="AddInventory.do?gid=${goods.gid }&size=L">添加</a></td>
				</c:if>
			</tr>
			
			<tr>
				<td><a href="">${goods.gid}</a></td>
				<td>${GCA[(goods.gcategories)-1]}</td>
				<td>${goods.type.tname }</td>
				<td>${goods.brand.bname }</td>
				<td>${goods.gname }</td>
				<td>${goods.new_price}</td>
				<td>XL</td>
				<c:set var="flag" value="true" />
				<c:forEach items="${ilist }" var="inv">
				<c:if test="${flag }">
						<c:if test="${inv.gsize eq'XL' }">
							<td><input type="text" name="XL" value="${inv.gnum }"></td>
							<c:set var="flag" value="false"></c:set>
						</c:if>
						
				</c:if>
				</c:forEach>
				<c:if test="${flag }">
							<td><a href="AddInventory.do?gid=${goods.gid }&size=XL">添加</a></td>
				</c:if>
			</tr>
			
			<tr>
				<td><a href="">${goods.gid}</a></td>
				<td>${GCA[(goods.gcategories)-1]}</td>
				<td>${goods.type.tname }</td>
				<td>${goods.brand.bname }</td>
				<td>${goods.gname }</td>
				<td>${goods.new_price}</td>
				<td>XXL</td>
				<c:set var="flag" value="true" />
				<c:forEach items="${ilist }" var="inv">
				<c:if test="${flag }">
						<c:if test="${inv.gsize eq'XXL' }">
							<td><input type="text" name="XXL" value="${inv.gnum }"></td>
							<c:set var="flag" value="false"></c:set>
						</c:if>
						
				</c:if>
				</c:forEach>
				<c:if test="${flag}">
							<td><a href="AddInventory.do?gid=${goods.gid }&size=XXL">添加</a></td>
				</c:if>
			</tr>
			
				
			
	</table>
	<div>
	<br>
		<input type="submit" value="  保存    ">
	</div>
	</form>
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

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
		<title>订单管理</title>
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
		<script type="text/javascript">
			window.onload=function()
			{
				var va=<%=request.getAttribute("ostatus") %>
				if(va==null)
				{
					va=0;
				}
				var op=document.getElementsByTagName("option");
				for(var i=0;i<op.length;i++)
				{
					if(va==op[i].value)
					{
						op[i].selected="selected";		
					}
				}
			}
		
			function select_status()
			{
				var status=document.getElementById("order_status").value;
				location.href="CheckCommand.do?ostatus="+status;
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
						<li><a href="#">订单处理</a></li>
					</ul>
				</div>
		<div class="main">
			<select id="order_status" onchange="select_status()">
				<option value="0">待发货</option>
				<option value="1">已发货</option>
				<option value="2">交易完成</option>
				<option value="3">申请退货</option>
				<option value="4">已退款</option>
				<option value="5">已评价</option>
			</select><br />
		 <br />
		 <table border="1px" width="60%"  style="text-align:center;">
			<tr >
				<th>商品名称</th>
				<th>商品尺寸</th>
				<th>收货人</th>
				<th>送货地址</th>
				<th>联系电话</th>
				<th>下单时间</th>
				<th>下单用户</th>
				<th></th>
			</tr>
			<c:forEach items="${oAndcs }" var="oc">
				<c:set value="${oc.order.ostatus }" var="status" scope="page"/>
				<tr>
					<td>${oc.order.it.goods.gname }</td>
					<td>${oc.order.it.gsize }</td>
					<td>${oc.order.receiver }</td>
					<td>${oc.order.oaddress }</td>
					<td>${oc.order.rephone }</td>
					<td>${oc.order.otime }</td>
					<td>${oc.order.user.uname }</td>
				<c:if test="${oc.order.ostatus==0 }">
					<td><a href="ChangeStatus.do?ostatus=1&oid=${oc.order.oid }">确认发货</a></td>
				</c:if>
				<c:if test="${oc.order.ostatus==3 }">
					<td><a href="ChangeStatus.do?ostatus=4&oid=${oc.order.oid }">确认退款</a></td>
				</c:if>
				</tr>
				<c:if test="${oc.order.ostatus==5&&oc.comm!=null }">
					<tr >
						<td colspan="7">评论:<p>${oc.comm.content }</p></td>
					</tr>
				</c:if>
			</c:forEach>
		</table>
		<center>
			<a href="CheckCommand.do?ostatus=${status }&index=1">首页</a>
			<a href="CheckCommand.do?ostatus=${status }&index=${order_pb.pageIndex-1 }">上一页</a>
			<a href="CheckCommand.do?ostatus=${status }&index=${order_pb.pageIndex+1 }">下一页</a>
			<a href="CheckCommand.do?ostatus=${status }&index=${order_pb.pageCount}">末页</a>
		</center>
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

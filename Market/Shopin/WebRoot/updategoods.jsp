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
    <title>修改商品</title>
    <link type="text/css" rel="stylesheet" href="css/style1.css" />
	<script type="text/javascript" src="js/jquery-1.8.3.js"></script>
	<script type="text/javascript" src="js/menu.js"></script>   
	<script type="text/javascript">
	 function addphoto(){
		 var photo = document.getElementsByName("hi");
		 photo[0].removeAttribute("hidden");
		 photo[0].removeAttribute("name");
	 }
	 window.onload = function(){
	 	var gcategories = document.getElementsByName("gcategories");	 	
	 	gcategories[0].selectedIndex =${goods.gcategories }-1;
	 }
	 function deletephoto(num)
	 {
	 	location.href="DeletePhoto.do?gid="+${goods.gid}+"&num="+num;
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
						<li><a href="#">修改密码</a></li>
					</ul>
				</div>
				<div class="main">
		<form action="UpdateGoods.do?gid=${goods.gid }" method="post"  enctype="multipart/form-data">
  		<table>
  			<c:forEach var="i" begin="1" end="${length }" step="1">
			<tr>
  				<td>
  				<input name="photo" hidden="hidden" value="${photo[i-1].getName() }"/>
  				</td>
  			</tr>				
			</c:forEach>
  			<tr>
  				<td>商品编号：</td>
  				<td><input disabled="" name="id" value="${goods.gid }"/></td>
  			</tr>
  			<tr>
  				<td>适合人群：</td>
  				<td>
  					<select name="gcategories">						
						<option value="1">男装</option>
						<option value="2">女装</option>
						<option value="3">童装</option>
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>服装类型：</td>
  				<td>
  					<select name="gtype">
  						<option value="${goods.type.tid }">${goods.type.tname }</option>
  						<c:forEach items="${Gtype }" var="gtype">
  							<option value="${gtype.tid }">${gtype.tname }</option>
  						</c:forEach>  						
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>品牌：</td>
  				<td>
  					<select name="brand">
  						<option value="${goods.brand.bid }">${goods.brand.bname }</option>  						
  						<c:forEach items="${Brand }" var="brand">
  							<option value="${brand.bid }">${brand.bname }</option>
  						</c:forEach>  
  					</select>
  				</td>
  			</tr>
  			<tr>
  				<td>商品名称：</td>
  				<td><input name="gname" required="" value="${goods.gname }"/></td>
  			</tr>
  			<tr>
  				<td>原价：</td>
  				<td><input name="old_price" required="" value="${goods.old_price }"/></td>
  			</tr>
  			<tr>
  				<td>现价：</td>
  				<td><input name="new_price" required="" value="${goods.new_price }"/></td>
  			</tr>
			<tr>
				<td ><label>详细描述:</label></td>
				<td >
					<textarea name="description" cols="22" rows="5" required="">${goods.description }</textarea>
				</td>				
			</tr>
			<c:forEach var="i" begin="1" end="${length }" step="1">
			<tr>
				<td colspan="2" align="center">
					<img alt="" src="${img[i-1]}" height="100" width="100">
					<label>${photo[i-1].getName() }</label>
					<input type="button" onclick="deletephoto(${i})" value="删除图片"/>
				</td>
			<tr>
			<tr>
  				<td>修改图片${i }：</td>
  				<td><input type="file" name="photo${i }" onblur="update(${i})"/></td>
  			</tr>				
			</c:forEach>
  			<c:forEach var="i" begin="${length+1 }" end="20" step="1">   			 
  			<tr hidden="hidden" name="hi">
  				<td>添加图片${i}：</td>
  				<td><input type="file" name="photo${i }" /></td>
  			</tr>
			</c:forEach>
			<tr>
  				<td colspan="2" align="center">
  					<input type="button" value="继续添加图片" onclick="addphoto()" />
  				</td>
  			</tr>
  			<tr>
  				<td colspan="2" align="center">
  					<input type="submit" value="保存" />
  					<input type="button" value="返回" onclick="location.back();" />
  				</td>
  			</tr>
  		</table>
  	</form>
  	<br><br><br><br><br><br><br><br>
    
						
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

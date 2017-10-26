<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="cn.bean.User"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<HEAD>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="css/globle_v1.css" type=text/css rel=stylesheet>
		<link href="css/skin_blue.css" rel="stylesheet" type="text/css" id="lnkSkin">

		<META content="MSHTML 6.00.6000.16809" name=GENERATOR>
	</HEAD>
	<BODY class=HeadBdWp>
	

		<DIV class=HeadWp>
			<DIV class=HeadThemeWp>
				<DIV class=HeadWpInner>
					<H1 class="Mylogo">
						<A href="index.jsp" target="_top">
						<IMG class=imgLogo src="images/logo.png" height="60" width="180" border=0 >
						</A>
					</H1>
					<SPAN class=UserInfo>
						<B>${user.email}</B>
						&nbsp;&nbsp;[&nbsp;
						<A href="index.jsp" target="_top">邮箱首页</A>
						<A id=lnkLogout title=安全退出邮箱 href="login.jsp" target="_top">退出</A>&nbsp;]
					</SPAN>
<!-- 					<FORM name=search action=# method=post>
						<SPAN class=SearchBar>
							<A class="SchMenuBtn fRi" title=高级搜索  href="#"></A>
								<INPUT class="SchBtn fRi" title=立即搜索 type=submit value="">
								<INPUT class="Ipt fRi" maxLength=50 value=搜索邮件... name=keyword>
						</SPAN>
					</FORM> -->
					
<!-- 					<SPAN class=Extra>
						<A href="#">设置</A>&nbsp;|&nbsp;
						<A href="#" >帮助</A>
					</SPAN> -->
					<DIV class="InfoTips_Wp InfoTips_Scs" id=dvSuccessMsg style="DISPLAY: none">
						<DIV class=InfoTips>
							<B class="F1Img cnL"></B>
							<SPAN class=Txt id=spnSuccessText></SPAN>
							<B class="F1Img cnR"></B>
						</DIV>
					</DIV>
					<DIV class="InfoTips_Wp InfoTips_War" id=dvErrorMsg style="DISPLAY: none">
						<DIV class=InfoTips>
							<B class="F1Img cnL"></B>
							<SPAN class=Txt id=spnErrorText></SPAN>
							<B class="F1Img cnR"></B>
						</DIV>
					</DIV>
				</DIV>
			</DIV>
		</DIV>
	</BODY>

</HTML>
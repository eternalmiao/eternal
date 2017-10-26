<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>

	<HEAD>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="css/globle_v1.css" type=text/css rel=stylesheet>
		<link href="css/skin_blue.css" rel="stylesheet" type="text/css" id="lnkSkin">
	</HEAD>
	
	<BODY>
		<DIV class=SidebarWp>
			<DIV class=SidebarThemeWp>
				<DIV class=SidebarWpInner>
					<TABLE class=tbSB height="100%" cellSpacing=0 cellPadding=0 width="100%" border=0>
						<TBODY>
							<TR>
								<TD class=tbSbTop>
									<!-- 收写信大按钮 -->
									<H1 class=BigBtnWp>
										<A class=aShouXIN id=lnkInbox title=收信  href="search.action" target="mainFrame" >
										<B>收信</B>
										</A>
										<A class=aXieXIN title=写信 href="write.jsp" target = "mainFrame"><B>写信</B></A>
									</H1>
								</TD>
							</TR>
							<TR>
								<TD class=tbSbMid>
									<!-- 主体列表 开始 -->
									<DIV class=Sb_ConWp>
										<DIV class=Sb_ConWpIn>
											<!-- 文件夹 开始 -->
											<DIV class="PanelWp Panel_Fld">
												<!-- 内容部分（折叠时隐藏） -->
												<DIV class=PanelCon id=dvSysFolder>
													<UL id=ulSysFolder>

														<LI class="Fld_Inbox New">
															<B class=icoFld></B>
															<A class=fileItem id=lnk1 title=收件箱 href="search.action" target="mainFrame"><SPAN class=JQ>收件箱</SPAN></A>&nbsp;

														</LI>
														
														<LI class=Fld_Spam>
															<B class=icoFld></B>
															<A class=fileItem id=lnk5 title=垃圾邮件 href="spam.action" target="mainFrame"><SPAN class=JQ>垃圾邮件</SPAN></A>&nbsp;

														</LI>
													</UL>
												</DIV>
											</DIV>
											<!-- 文件夹 结束 -->
											<!-- 分隔线 -->
											<DIV class=Sb_Line></DIV>
											<!-- 邮箱功能 开始 -->
											<DIV class="PanelWp Panel_Ftr">
												<!-- 内容部分 -->
												<DIV class=PanelCon>
													<UL>
														<LI class=Fld_Addr>
															<B class=icoFld></B>
															<A class=fileItem id=lnkAddress href="function.action" target="mainFrame"><SPAN class=JQ>过滤功能设置</SPAN></A>
														</LI>
														<LI class=Fld_Addr>
															<B class=icoFld></B>
															<A class=fileItem id=lnkAddress href="white.action?page.pageIndex=1" target="mainFrame"><SPAN class=JQ>白名单管理</SPAN></A>
														</LI>
														<LI class=Fld_Addr>
														<B class=icoFld></B>
															<A class=fileItem id=lnkAddress href="black.action?page.pageIndex=1" target="mainFrame"><SPAN class=JQ>黑名单管理</SPAN></A>
														</LI>
														<LI class=Fld_Addr>
															<B class=icoFld></B>
															<A class=fileItem id=lnkAddress href="keyword.action?page.pageIndex=1" target="mainFrame"><SPAN class=JQ>关键字管理</SPAN></A>
														</LI>
													</UL>
												</DIV>
											</DIV>
											<!-- 邮箱功能 结束 -->
											<!-- 分隔线 -->
											<DIV class=Sb_Line></DIV>
											<!-- 自定义文件夹 开始 -->
											<DIV class="PanelWp Panel_PslFld">
												<!-- 标题部分 -->
												<!-- 折叠时把icoOpen换成icoCls -->
												<H2 class=PanelTT>
													<A class="icoOpCls icoOpen" title=折叠 href="javascript:void(0)"></A>
													&nbsp;
													<A class=TTxt title=进入文件夹管理页面 href="#" >自定义文件夹</A>
													&nbsp;
													<SPAN class=Extra>
														[<A title=新建文件夹 href="javascript:void(0)">新建</A>]
													</SPAN>
												</H2>
												<!-- 内容部分（折叠时隐藏） -->
												<DIV class="PanelCon PanelScl" id=dvDefinedFolder>
													<UL id=ulDefFolder>

													</UL>
												</DIV>
											</DIV>
											<!-- 自定义文件夹 结束 -->
										</DIV>
									</DIV>
									<!-- 主体列表 结束 -->
								</TD>
							</TR>
						</TBODY>
					</TABLE>
				</DIV>
			</DIV>
		</DIV>
	</BODY>
</HTML>
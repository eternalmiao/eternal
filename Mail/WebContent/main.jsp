<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<HTML>
	<HEAD>
		<TITLE>收件箱</TITLE>
		<META http-equiv=Content-Type content="text/html; charset=gb2312">
		<LINK href="css/globle_v1.css" type=text/css rel=stylesheet>
		<LINK href="css/inbox.css" type=text/css rel=stylesheet>
		<link href="css/skin_blue.css" rel="stylesheet" type="text/css" id="lnkSkin">
	
		<script type="text/javascript">
			function paging(num)
			{
			  var number = ${page.pageCount};
			  if(num==0)
			  {
			    alert("当前已经是第一页!");
			  }
			  else if(num>number)
			  {
			    alert("当前已经是最后一页!");
			  }
			  else
			  {
				    var url="search.action?page.pageIndex=" + num;
				    location.href=url;
			  }
			}
			
			function ajax(){
			    var url="search.action?page.pageIndex=" + num;
			    location.href=url;
			}
			
		</script>		
	
	
	</HEAD>

	<BODY class="All_C_Page Inbox">
		<FORM id=oFormMessage action=# method=post>
			<INPUT id=oFormAction type=hidden>
			<DIV class=ContentWp>
			
				<DIV class=ContentThemeWp>
				
					<DIV class=gTitle>
						<B class=mTT>收件箱</B>&nbsp;&nbsp;(共&nbsp;
						<B id=oTotal>${page.rowCount}</B>&nbsp;封，其中&nbsp;
						<A title="" href="#">未读邮件</A>&nbsp;
						<B class=fnt_Red id=oTotalUnRead>${page.rowCount}</B>&nbsp;封)
					</DIV>
			
					<DIV class="gToolbar gTbrTop">
					
						<INPUT class="Btn BtnNml" type=button value="删 除" >
						<INPUT class="Btn BtnNml" type=button value="举报垃圾邮件" >
						
						<DIV class=Extra>
							<SPAN class=Txt>
								${page.pageIndex}/${page.pageCount}页&nbsp;&nbsp;
								<A href="javascript:paging(1)">首页</A>&nbsp;&nbsp;
								<A href="javascript:paging(${page.pageIndex-1})">上页</A>&nbsp;&nbsp;
								<A href="javascript:paging(${page.pageIndex+1})">下页</A>&nbsp;&nbsp;
								<A href="javascript:paging(${page.pageCount})">末页</A>
							</SPAN>
						</DIV>
						
					</DIV>
					
					<DIV class=Ibx_Main_Wp>
						<TABLE class="Ibx_gTable F2Img Ibx_gTable_TT" id=oTableHead>
							<TBODY>
								<TR>
									<TH class=Ibx_Th_F></TH>
									<TH class=Ibx_Th_Chkbx>
										<INPUT id=oFormCheckAll title=全选/不选　本页所有邮件 type=checkbox>
									</TH>
									<TH class=Ibx_Th_icoInfo>
										<B class=icoIbx title=邮件类型></B>
									</TH>
									<TH class=Ibx_Th_From>发件人</TH>
									<TH class=Ibx_Th_Subject>主题</TH>
									<TH class=Ibx_Th_Date>日期</TH>
								</TR>
							</TBODY>
						</TABLE>
						<DIV class="Ibx_Lst_dWp dWpOpen">
							<TABLE class="Ibx_gTable Ibx_gTable_Con" id=oTableCOUNT0>
								<TBODY>
									<s:iterator value="page.list">
									<TR class="I_Mark0 I_UnRd">
										<TD class=Ibx_Td_F>&nbsp;</TD>
										<TD class=Ibx_Td_Chkbx>
											<INPUT title=选择/不选 type=checkbox>
										</TD>
										<TD class=Ibx_Td_icoInfo>
											<B class="icoIbx "></B>
										</TD>
										<TD class="Ibx_Td_From">
											<A href="read.action?id=<s:property value="id"/>"><s:property value="sender"/></A>
										</TD>
										<TD class="Ibx_Td_Subject">
											<A href="read.action?id=<s:property value="id"/>"><s:property value="subject"/></A>
										</TD>
										<TD class="Ibx_Td_Date">
											<A href="read.action?id=<s:property value="id"/>"><s:property value="date"/></A>
										</TD>
									</TR>
									</s:iterator>
								</TBODY>
							</TABLE>
						</DIV>
						<H4 class=Ibx_Lst_bExtra id=oH4Check>
							选择：
							<A href="#" type=all>全选</A>&nbsp;-&nbsp;
							<A href="#" type=reverse>反选</A>&nbsp;-&nbsp;
						</H4>
					</DIV>
					
					<DIV class="gToolbar gTbrBtm">

						<INPUT class="Btn BtnNml" type=button value="删 除" >
						<INPUT class="Btn BtnNml" type=button value="举报垃圾邮件" >
			
						<DIV class=Extra>
							<SPAN class=Txt>
								${page.pageIndex}/${page.pageCount}页&nbsp;&nbsp;
								<A href="javascript:paging(1)">首页</A>&nbsp;&nbsp;
								<A href="javascript:paging(${page.pageIndex-1})">上页</A>&nbsp;&nbsp;
								<A href="javascript:paging(${page.pageIndex+1})">下页</A>&nbsp;&nbsp;
								<A href="javascript:paging(${page.pageCount})">末页</A>
							</SPAN>
						</DIV>
						
					</DIV>
					
				</DIV>
				
			</DIV>
			
		</FORM>
		
	</BODY>

</HTML>
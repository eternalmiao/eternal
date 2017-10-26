<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>列表管理</title>
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
				    var url="white.action?page.pageIndex=" + num;
				    location.href=url;
			  }
			}
			
			function ajax(){
			    var url="white.action?page.pageIndex=" + num;
			    location.href=url;
			}
			
			var selectState = false; 
			function AllCheck(thisform){
			    for (var i = 0; i < thisform.elements.length; i++)  
			    {  
			      // 提取控件    
			      var checkbox = thisform.elements[i];  
			      checkbox.checked = !selectState;  
			    }  
			    selectState = !selectState;  
			  } 
			
			
		</script>
	</head>
	
	<body>

	<div id="content">  
  	<form> 
	<table id="list_tb" border="1">
    	<caption>${title}列表管理</caption>
        <thead>
        	<tr>
                <th width="4%">序号</th>
                <th width="4%">选择</th>
                <th width="70%">名单</th>
                <th width="26%">操作</th>
            </tr>
        </thead>
        <tbody>
       		<s:iterator value="page.list">
	        	<tr align='center'>
	                <td><s:property value="id"/></td>
	                <td><input name="id" type="checkbox" value=""></td>
	                <td align="center"><s:property value="value"/></td>
	                <td><a href="">编辑</a> <a href="">删除</a></td>    
	           </tr>
            </s:iterator>
            
            <tr>
            	<td colspan="7">&nbsp;
                    <input name="" type="button" onClick="AllCheck(this.form);return false;" value="全选">                  
                   	<a href="title.action?type=${type}">&nbsp;添加&nbsp;</a>
    			</td>
               </tr>
              <tr>  
                <td colspan="7">  
                    <a href="javascript:paging(1)">首页</a>
                    <a href="javascript:paging(${page.pageIndex-1})" >上一页</a>
                    <a href="javascript:paging(${page.pageIndex+1})" >下一页</a>
                    <a href="javascript:paging(${page.pageCount})" >尾页</a>
                   	 共${page.rowCount}条纪录，当前第${page.pageIndex}/${page.pageCount}页，每页${page.pageSize}条纪录
                </td>
            </tr>
        </tbody>
    </table>  
   </form> 
</div>



</body>
</html>
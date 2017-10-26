<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>读邮件</title>
		
		<style>
			.button {
			background-color: #ECE9D8;
			height: 30px;
			width: 86px;
			border: thin none #ECE9D8;
			}
		</style>
	</head>

	<body>
		<div  style="background-color: #F7F7F7;">
      		<table>	
      		    <tr>
       				<td align="left" colspan="2" style="font-size: larger;large;font-weight: bold;">
       					${mail.subject}
       				</td>
     		    </tr>
      		
     			<tr>
       				<td align="left">发件人：</td>
      				<td>
      					${mail.sender}
      				</td>
     		    </tr>
     		    
     			<tr>
       				<td align="left">日    期：</td>
       				<td>
       					${mail.date}
       				</td>
     			</tr>
 
     			<tr>
       				<td align="left">收件人：</td>
       				<td>
	            		${mail.recipient}
      				</td>
     			</tr>
     			<tr>
       				<td colspan="2"></td>
     			</tr>
      		</table>	
		</div>
      	<HR align="left" width="90%" color=#080808 SIZE=2 />
      	${mail.content}	
		<HR align="left" width="90%" color=#080808 SIZE=2 />
		<input type="button" class="button" onclick="javascript:history.back(-1);" value="返回">
	</body>

</html>

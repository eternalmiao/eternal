<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
		<title>写邮件</title>
		
		<style>
			.border {
				border: 1px solid #c0c0c0;
				height: 25px;
				width:  100%;
			}
			.button {
				background-color: #ECE9D8;
				height: 30px;
				width: 86px;
				border: thin none #ECE9D8;
			}
			
		</style>
	
 		<link href="./css/pop.css" rel="stylesheet" type="text/css" />
		<link href="./styles/simditor.css" rel="stylesheet" type="text/css" />
		
		<script type="text/javascript" src="./scripts/jquery.min.js"></script>
		<script type="text/javascript" src="./scripts/module.js"></script>
		<script type="text/javascript" src="./scripts/hotkeys.js"></script>
		<script type="text/javascript" src="./scripts/uploader.js"></script>
		<script type="text/javascript" src="./scripts/simditor.js"></script>
	</head>

	<body>
		<form id="form" name="form" method="post" action="send.action">
      		<table>	
     			<tr>
       				<td align="right">收件人：</td>
      				<td>
      					<input name="recipent" type="text" class="border" id="recipent" />
      				</td>
     		    </tr>
     		    
     			<tr>
       				<td align="right">主题：</td>
       				<td>
       					<input name="subject" type="text" class="border" id="subject"/>
       				</td>
     			</tr>
 
     			<tr>
       				<td></td>
       				<td>
	            		<textarea id="editor" name="content" style="height: 40%"></textarea>
      				</td>
     			</tr>

     			<tr>
       				<td></td>
       				<td align="left">
       					发件人: ${user.email}&nbsp;&nbsp;&nbsp;&nbsp;
         				<input name="submit" type="submit" class="button" value="发送"/>
         				<input name="reset" type="reset" class="button" value="清空"/>
         			</td>
     			</tr>
      		</table>
		</form>
	</body>

	<script type="text/javascript" src="./scripts/texteditor.js"></script>
</html>

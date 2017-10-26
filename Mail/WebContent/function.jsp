<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>过滤功能设置</title>
</head>
<script type="text/javascript">
	function load() {
		var whitenum = ${func.white};
		var white=document.form.white;
		if(whitenum == 1) {
			white[0].checked=true;
		} else {
			white[1].checked=true;
		}
		
		var blacknum = ${func.black};
		var black=document.form.black;
		if(blacknum == 1) {
			black[0].checked=true;
		} else {
			black[1].checked=true;
		}
		
		var keywordnum = ${func.keyword};
		var keyword=document.form.white;
		if(keywordnum == 1) {
			keyword[0].checked=true;
		} else {
			keyword[1].checked=true;
		}
		
		var bayesnum = ${func.bayes};
		var bayes=document.form.white;
		if(bayesnum == 1) {
			bayes[0].checked=true;
		} else {
			bayes[1].checked=true;
		}
		
	}
</script>


<body>

	<form name="form" action="change.action">
	<table align="center" border="5" width="50%">
		<tr>
			<td colspan="2" align="center">过滤功能设置</td>
		</tr>
		<tr>
			<td>白名单过滤</td>
			<td>
				<input type="radio" name="white" id="white" value=1/>开启
				<input type="radio" name="white" id="white" value=0/>关闭
			</td>
		</tr>
		
		<tr>
			<td>黑名单过滤</td>
			<td>
				<input type="radio" name="black" id="black" value=1/>开启
				<input type="radio" name="black" id="black" value=0/>关闭
			</td>
		</tr>
		
		<tr>
			<td>关键字过滤</td>
			<td>
				<input type="radio" name="keyword" id="keyword" value=1/>开启
				<input type="radio" name="keyword" id="keyword" value=0/>关闭
			</td>
		</tr>
		
		<tr>
			<td>贝叶斯过滤</td>
			<td>
				<input type="radio" name="bayes" id="bayes" value=1/>开启
				<input type="radio" name="bayes" id="bayes" value=0/>关闭
			</td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="保存"/>
				<input type="button" value="返回"/>
			</td>
			
		</tr>
		
		
	</table>
	</form>
</body>
</html>
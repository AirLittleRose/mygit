<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>mygit</title>

</head>
<body>
	<div id="w_user">
	
		<form action="login.action?op=login" method="post">
			用户名：<input type="text" name="uname" id="uname" /><br/>
			密    码：<input type="password" name="upass" id="upass" /><br/>
			<input type="submit" value="登录"/>
		</form>
	
	</div>
	

</body>
</html>
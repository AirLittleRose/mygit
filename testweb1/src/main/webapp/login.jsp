<%@page import="com.yc.bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta>
<title>Insert title here</title>

<script type="text/javascript" src="js/jquery-1.9.1.js">
	</script>
	
<script type="text/javascript">
	$(function(){
		$("#loginButton").bind("click",function(){
			$.ajax({
				type : "post",
				url : "login.action?op=login",
				data : $("#loginForm").serialize(),
				dataType : "json",
				success : function(data){
					$("#w_user").html('');
					$("#w_user").html(
							"<div>欢迎您</div>"
					);
				}
			});
		});
	});
	
</script>
</head>
<body>
	<div id="w_user">
	
		<form id="loginForm" method="post">
			用户名：<input type="text" name="uname" id="uname" /><br/>
			密    码：<input type="password" name="upass" id="upass" /><br/>
			<input id="loginButton" type="submit" value="登录"/>
		</form>
	
	</div>
	

</body>
</html>
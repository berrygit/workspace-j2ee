<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<style> 
#warp {
  position:absolute;
  width:500px;
  height:200px;
  left:50%;
  top:50%;
  margin-left:-250px;
  margin-top:-110px;
  border: solid 1px black;
}
</style> 
</head>
<body>
	<div id="warp">
	登陆系统
	<form action="verifyLogin" method="post">
		用户名：<input type="text" name="userName"><br>
		密码：<input type="password" name="passWord"><br>
		<input type="submit" value="登录">
		<input type="reset" value="重置">
	</form>
	<div align="right"><a href="register">注册</a></div>
	</div>
</body>
</html>
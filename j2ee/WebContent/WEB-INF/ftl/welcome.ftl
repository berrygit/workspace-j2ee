<#assign s=JspTaglibs["/WEB-INF/struts-tags.tld"] />
<html>
<head>
<title>登录页面</title>
</head>
<body>
登陆<br>
<@s.form action="Login.action">
 <@s.textfield name="username" label="用户名"/>
 <@s.textfield name="password" label="密码"/>
 <@s.submit value="提交"/>
</@s.form>
提示：${name1}=${name2}
</body>
</html>
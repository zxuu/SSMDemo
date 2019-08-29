<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登录</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">

	<script src="js/jquery-3.2.1.min.js"></script>
	<script src="js/echarts.all.js"></script>
	<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>

  </head>
  
  <body>
  
 
  
    <form action="login" method="post">
		<div class="login_row login_row_text">
			<label id="login_lab_user" class="login_lab">账号</label>
			<input id="loginname" class="itext" type="text" name="id" tabindex="1" autocomplete="off"
			placeholder="用户名">
		</div>
		<div class="login_row login_row_text">
			<label id="login_lab_pwd" class="login_lab">密码</label>
			<input id="signpwd" class="itext" type="password" name="password" tabindex="2" autocomplete="off"
			placeholder="密码">
		</div>
		
		<div class="login_row">
			<input id="loginbut" type="submit" name="login_sub" value="登       录" tabindex="4">
		</div>
		<div id="meserror">
			<ul id="meserrorul">
			</ul>
		</div>
		
		
	</form>
	
	


   
	
  </body>
</html>
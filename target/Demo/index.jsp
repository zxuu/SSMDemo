<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <link href="css/styles.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
  <div class="container-fluid">
   <div class="col-sm-9 col-md-10 main">
 <div class="panel panel-success">
  <div class="panel-heading">
            <h3 class="panel-title">幼儿后台管理</h3>
        </div>
        <div class="panel-body">
    <form action="login" method="post">
    <table class="addTable">
	
		<tr>
                        <td>用户名：</td>
                        <td><input type="text" name="id" id="loginname" placeholder="请在这里输入用户名"></td>
                    </tr>
                    <tr>
		
	
			<tr>
                        <td>密码：</td>
                        <td><input type="password" name="password" id="signpwd" placeholder="请在这里输入密码"></td>
                    </tr>
                    <tr>
		
	 <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">登 陆</button>
                        </td>
                    </tr>
		</table>
		
	</form>
	
</div>	
</div>	

  </div>
	</div>
  </body>
</html>
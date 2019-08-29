<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<html lang="en">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=UTF-8">
		<meta charset="utf-8">
		<title>Dashboard with Off-canvas Sidebar</title>
		<meta name="generator" content="Bootply" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href="css/bootstrap.min.css" rel="stylesheet">
		<!--[if lt IE 9]>
			<script src="//html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<![endif]-->
		<link href="css/styles.css" rel="stylesheet">
		<script>
        $(function () {
            $("ul.pagination li.disabled a").click(function () {
                return false;
            });
            $("#addForm").submit(function () {
                if (!checkEmpty("student_id", "学号"))
                    return false;
                if (!checkEmpty("name", "姓名"))
                    return false;
                if (!checkEmpty("age", "年龄"))
                    return false;
                return true;
            });
        });
        function del() {
            var msg = "您真的确定要删除吗？\n\n请确认！";
            if (confirm(msg) == true) {
                return true;
            } else {
                return false;
            }
        }
        function checkEmpty(id, name) {
            var value = $("#" + id).val();
            if (value.length == 0) {
                alert(name + "不能为空");
                $("#" + id).focus();
                return false;
            }
            return true;
        }
    </script>
	</head>
	<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">婴幼儿状态查看系统</a>
        </div>
        <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Settings</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
</nav>



<div class="container-fluid">
      
      <div class="row row-offcanvas row-offcanvas-left">
        
         <div class="col-sm-3 col-md-2 sidebar-offcanvas" id="sidebar" role="navigation">
           
            <ul class="nav nav-sidebar">
              <li class="active"><a href="listBaby">概览</a></li>
              <li><a href="http://bootstrapzero.com" target="_ext">状态查看</a></li>
              <li><a href="zhe" target="_ext">数据分析</a></li>
              <li><a href="toAdd" target="_ext">新增幼儿</a></li>
            </ul>
     <!--        <ul class="nav nav-sidebar">
              <li><a href="">Nav item</a></li>
              <li><a href="">Nav item again</a></li>
              <li><a href="">One more nav</a></li>
              <li><a href="">Another nav item</a></li>
              <li><a href="">More navigation</a></li>
            </ul>
            <ul class="nav nav-sidebar">
              <li><a href="">Nav item again</a></li>
              <li><a href="">One more nav</a></li>
              <li><a href="">Another nav item</a></li>
            </ul> -->
          
        </div><!--/span-->
        
        <div class="col-sm-9 col-md-10 main">
          
          <!--toggle sidebar button-->
          <p class="visible-xs">
            <button type="button" class="btn btn-primary btn-xs" data-toggle="offcanvas"><i class="glyphicon glyphicon-chevron-left"></i></button>
          </p>
        
          
        





    <div class="panel panel-success">
      <div class="panel-heading">
            <h3 class="panel-title">增加幼儿</h3>
        </div>
       <div class="panel-body">
 	
            <form method="post" id="addForm" action="addBaby" role="form">
                <table class="addTable">
                    <tr>
                        <td>学号：</td>
                        <td><input type="text" name="id" id="id" placeholder="请在这里输入编号"></td>
                    </tr>
                    <tr>
                        <td>姓名：</td>
                        <td><input type="text" name="name" id="name" placeholder="请在这里输入名字"></td>
                    </tr>
                    <tr>
                        <td>年龄：</td>
                        <td><input type="text" name="age" id="age" placeholder="请在这里输入年龄"></td>
                    </tr>
                    <tr>
                        <td>性别：</td>
                        <td><input type="radio" checked class="radio radio-inline" name="sex" value="男"> 男
                            <input type="radio" class="radio radio-inline" name="sex" value="女"> 女
                        </td>
                    </tr>
                 
                    <tr class="submitTR">
                        <td colspan="2" align="center">
                            <button type="submit" class="btn btn-success">提 交</button>
                        </td>
                    </tr>

                </table>
            </form>
       
    </div>

</div>
 </div>
 </div>
</div>
 
        
	<!-- script references -->
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>
</body>
</html>
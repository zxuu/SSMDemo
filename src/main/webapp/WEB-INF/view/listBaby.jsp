<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          
		  <h1 class="page-header">
           	 信息总览
            <!-- <p class="lead">(<a href="http://www.bootply.com/128936">with off-canvas sidebar</a>)</p> -->
          </h1>
<script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts-all-3.js"></script>
          <div class="row placeholders">
            <div id="main" style="width:300px;height:300px;" class="col-xs-6 col-sm-3 placeholder text-center">
            </div>
            <div id="age" class="col-xs-6 col-sm-3 placeholder text-center"style="width:300px;height:300px;">
            </div>
            <div id="sum"class="col-xs-6 col-sm-3 placeholder text-center" style="width:300px;height:300px;">
            </div>
          </div>
          <hr>

          <h2 class="sub-header">幼儿信息</h2>
          <div class="table-responsive">
          <!--   <div class="listDIV"> -->
    <table class="table table-striped table-bordered table-hover table-condensed">

        <caption>幼儿列表 - 共${page.total}人</caption>
        <thead>
        <tr class="success">
            <th>传感器编号</th>
            <th>姓名</th>
            <th>年龄</th>
            <th>性别</th>
         

            <th>编辑</th>
            <th>删除</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${babys}" var="s" varStatus="status">
            <tr>
                <td>${s.id}</td>
                <td>${s.name}</td>
                <td>${s.age}</td>
                <td>${s.sex}</td>
            

                <td><a href="editBaby?id=${s.id}"><span class="glyphicon glyphicon-edit"></span> </a></td>
                <td><a href="deleteBaby?id=${s.id}" onclick="javascript:return del();"><span
                        class="glyphicon glyphicon-trash"></span> </a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
<!-- </div> -->

<nav class="pageDIV">
    <ul class="pagination">
        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a href="?page.start=0">
                <span>«</span>
            </a>
        </li>

        <li <c:if test="${!page.hasPreviouse}">class="disabled"</c:if>>
            <a href="?page.start=${page.start-page.count}">
                <span>‹</span>
            </a>
        </li>

        <c:forEach begin="0" end="${page.totalPage-1}" varStatus="status">

            <c:if test="${status.count*page.count-page.start<=30 && status.count*page.count-page.start>=-10}">
                <li <c:if test="${status.index*page.count==page.start}">class="disabled"</c:if>>
                    <a
                            href="?page.start=${status.index*page.count}"
                            <c:if test="${status.index*page.count==page.start}">class="current"</c:if>
                    >${status.count}</a>
                </li>
            </c:if>
        </c:forEach>

        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?page.start=${page.start+page.count}">
                <span>›</span>
            </a>
        </li>
        <li <c:if test="${!page.hasNext}">class="disabled"</c:if>>
            <a href="?page.start=${page.last}">
                <span>»</span>
            </a>
        </li>
    </ul>
</nav>
            
              
           

          </div>

          <a href="http://www.bootply.com/gkTHCwjLO9">Get the Source Code</a> | <a href="http://bootstrap.theme.cards">More free Bootstrap themes</a>
          
      </div><!--/row-->
	</div>
</div><!--/.container-->

<footer>
  <p class="pull-right">©2016 Company</p>
</footer>
        
	<!-- script references -->
	<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    option = {
        title : {
            text: '性别',
            subtext: '比例',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: [
                <c:forEach items="${babys}" var="s">
                    ["${s.sex}"],
                </c:forEach>
            ]
        },
        series : [
            {
                name: '性别',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                    /* <c:forEach items="${babys}" var="s">
                    {value:"${s.id}", name:"${s.sex}"},
                    </c:forEach> */
                    {value:"${male}", name:"男"},
                    {value:"${female}", name:"女"},
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('age'));

    // 指定图表的配置项和数据
    option = {
        title : {
            text: '年龄',
            subtext: '比例',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: [
                <c:forEach items="${babys}" var="s">
                    ["${s.age}"],
                </c:forEach>
            ]
        },
        series : [
            {
                name: '年龄',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                 <c:forEach items="${babys}" var="s">
                    {value:"1", name:"${s.age}"},
                    </c:forEach> 
                   
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('sum'));

    // 指定图表的配置项和数据
    option = {
        title : {
            text: '人数',
            subtext: '总数',
            x:'center'
        },
        tooltip : {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            orient: 'vertical',
            left: 'left',
            data: [
               
                    ["总人数"]
              
            ]
        },
        series : [
            {
                name: '人数',
                type: 'pie',
                radius : '55%',
                center: ['50%', '60%'],
                data:[
                
                    {value:"${page.total}", name:"人数"},
                   
                   
                ],
                itemStyle: {
                    emphasis: {
                        shadowBlur: 10,
                        shadowOffsetX: 0,
                        shadowColor: 'rgba(0, 0, 0, 0.5)'
                    }
                }
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
		<script src="//ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
		<script src="js/bootstrap.min.js"></script>
		<script src="js/scripts.js"></script>
		
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
	</body>
</html>
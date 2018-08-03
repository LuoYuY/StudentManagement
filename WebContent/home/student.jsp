<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html><head>
<title>学生页面</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="keywords" content="Learn Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/home/services_files/bootstrap-3.css" rel="stylesheet" type="text/css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/home/services_files/jquery.js"></script>
<script src="${pageContext.request.contextPath}/home/services_files/bootstrap.js"></script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/home/services_files/style.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="services_files/jquery.css">
<link href="${pageContext.request.contextPath}/home/services_files/css.css" rel="stylesheet" type="text/css">
<!----font-Awesome----->
<link href="${pageContext.request.contextPath}/home/services_files/font-awesome.css" rel="stylesheet"> 
<!----font-Awesome----->
<script>
$(document).ready(function(){
    $(".dropdown").hover(            
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideDown("fast");
            $(this).toggleClass('open');        
        },
        function() {
            $('.dropdown-menu', this).stop( true, true ).slideUp("fast");
            $(this).toggleClass('open');       
        }
    );
});
</script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
	<div class="container">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
	        <a class="navbar-brand" href="index.html">学生成绩管理系统</a>
	    </div>
	    <!--/.navbar-header-->
	    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" style="height: 1px;">
	        <ul class="nav navbar-nav">
		        <li class="dropdown">
		            <a href="${pageContext.request.contextPath}/queryStudent.do?luoyy_sno=${luoyy_sno}"><i class="fa fa-user"></i><span>用户</span></a>
		        
		        </li>
		        <li class="dropdown">
		            <a href="${pageContext.request.contextPath}/logout.do"><i class="fa fa-user"></i><span>退出登录</span></a>
		        </li>
		     </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
</nav>


    <!-- //banner -->
	<div class="services">
	   <div class="container">
		
	   	  <h1>学生用户功能</h1>
	   	  <div class="service_box1">
	   	    <div class="col-md-6">
                <div class="service_1">
                    <div class="service_1-left">
                       <span class="icon_5"><i class="fa fa-users"> </i></span>
                    </div>
                    <div class="service_1-right">
                       <h5><a target="_blank" href="${pageContext.request.contextPath}/queryStudent.do?luoyy_sno=${luoyy_sno}">查询个人基本信息</a></h5>
                        <p>学号 姓名 性别 出生年月 生源所在地 已修学分 专业号 班级号</p>
                    </div>
                </div>
            </div>
             <div class="col-md-6">
                <div class="service_1">
                    <div class="service_1-left">
                       <span class="icon_5"><i class="fa fa-phone"> </i></span>
                    </div>
                    <div class="service_1-right">
                       <h5><a href="${pageContext.request.contextPath}/home/queryClass.jsp">查询各班开课情况</a></h5>
                        <p></p>
                    </div>
                </div>
            </div>
            <div class="clearfix"> </div>
	   </div>
	   <div class="service_box1">
	   	    <div class="col-md-6">
                <div class="service_1">
                    <div class="service_1-left">
                       <span class="icon_5"><i class="fa fa-star"> </i></span>
                    </div>
                    <div class="service_1-right">
                       <h5><a href="${pageContext.request.contextPath}/student/showMyCourses.jsp?luoyy_sno=${luoyy_sno}">查询所学课程</a></h5>
                        <p>支持按学期查询</p>
                    </div>
                </div>
            </div>
             <div class="col-md-6">
                <div class="service_1">
                    <div class="service_1-left">
                       <span class="icon_5"><i class="fa fa-globe"> </i></span>
                    </div>
                    <div class="service_1-right">
                       <h5><a target="_blank" href="${pageContext.request.contextPath}/student/queryMyScore.jsp?luoyy_sno=${luoyy_sno}">查询成绩</a></h5>
                        <p>支持按学期查询</p>
                    </div>
                </div>
            </div>
            <div class="clearfix"> </div>
	   </div>
	</div>
	<div id="extwaiimpotscp" style="display:none" v="{4170" f="ZXpReE56Qm1ZV0ZoTFdWbE9EY3ROR0V3WlMxaU5UZGhMVEZoWldNME9USTRNamc0TjMwPQ==" q="d5266df3" c="50.12" i="53.23" u="0.664" s="66b0a006" w="false" vn="0trzh"></div></div>

    <div class="footer">
    	<div class="container">
			<div class="copy">
		       <p>Copyright © 2018软件工程1601骆雨颖</a></p>
	        </div>
    	</div>
    </div>

 </body></html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>本课程平均分</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Learn Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/home/css/bootstrap-3.1.1.min.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/home/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/home/js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/home/css/style.css" rel='stylesheet' type='text/css' />
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/jquery.countdown.css" />
<link href='https://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700' rel='stylesheet' type='text/css'>
<!----font-Awesome----->
<link href="${pageContext.request.contextPath}/home/css/font-awesome.css" rel="stylesheet"> 
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
		            <a href="${pageContext.request.contextPath}/home/teacher.jsp"><i class="fa fa-user"></i><span>用户</span></a>
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

<!-- banner -->
  <div class="courses_banner">
  	<div class="container">
  		<h3>课程平均分</h3>
  		<p class="description">
        </p>
        <div class="breadcrumb1">
        
            <ul>
                <li class="icon6"><a href="${pageContext.request.contextPath}/home/teacher.jsp">教师管理页面</a></li>
                <li class="current-page">课程平均分</li>
            </ul>
        </div>
  	</div>
  </div>


	
    <!-- //banner -->
	<div class="admission">
	   <div class="container">
	   	    <dl class="faq-list">
	   	    <dt class="faq-list_h">
				<h4 class="marker">课程编号</h4>
				<h4><span style="color:white">hahahahaha</span>${course.luoyy_cno}</h4>
				</dt>
	   	    	<dt class="faq-list_h">
				<h4 class="marker">课程名</h4>
				<h4><span style="color:white">hahahahaha</span>${course.luoyy_cname}</h4>
				</dt>
				<dt class="faq-list_h">
				<h4 class="marker">学时</h4>
				<h4><span style="color:white">hahahahaha</span>${course.luoyy_ctime}</h4>
				</dt>
				<dt class="faq-list_h">
				<h4 class="marker">考查类型</h4>
				<h4><span style="color:white">hahahahaha</span>${course.luoyy_ctype}</h4>
				</dt>
				<dt class="faq-list_h">
				<h4 class="marker">平均分</h4>
				<h4><span style="color:white">hahahahaha</span>${equalScore}</h4>
				</dt>

          </dl>
	   </div>
	</div>
    <div class="footer">
    	
    		<div class="copy">
		       <p>Copyright &copy; 2018.软件工程1601骆雨颖</p>
	        </div>
    	</div>
    </div>
</body>
</html>	
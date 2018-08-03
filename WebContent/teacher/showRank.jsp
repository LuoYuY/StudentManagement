<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>成绩排名</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Learn Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/home/css/bootstrap2-3.1.1.min.css" rel='stylesheet' type='text/css' />
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/home/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/home/js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/home/css/style2.css" rel='stylesheet' type='text/css' />
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
		            <a href="${pageContext.request.contextPath}/queryTeacher.do?luoyy_tno=${luoyy_tno}"><i class="fa fa-user"></i><span>用户</span></a>
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
  		<h3>所授课程成绩排名</h3>
  		<p class="description">
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="${pageContext.request.contextPath}/home/teacher.jsp">教师管理页面</a></li>
                <li class="current-page">所授课程成绩排名</li>
            </ul>
        </div>
  	</div>
   </div>
    <!-- //banner -->
	<div class="courses_box1">
	   <div class="container">

		<div class="col-md-9">
			<div class="course_list">
		
			
                <div class="table-header clearfix">
                	
                    <div class="id_col">姓名</div>
					<div class="id_col">得分</div>
                	<div class="duration_col">排名</div>
                   
    			</div>
                <ul class="table-list">
				 <c:forEach var="item" items="${rankList}">
                    <li class="clearfix">
    					
						<div class="id_col">${item.luoyy_sname}</div>
						<div class="id_col">${item.luoyy_score}</div>
        				<div class="duration_col">${item.num}</a></div>
						
    				</li>
					</c:forEach>
    			</ul>
               </div>
		    </div>
		    <div class="clearfix"> </div>
	   </div>
	</div>
    <div class="footer">
    	<div class="container">
    		<div class="copy">
		       <p>Copyright &copy; 2018.骆雨颖</p>
	        </div>
    	</div>
    </div>

</body>
</html>	
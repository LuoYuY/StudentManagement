<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<title>为教师排课</title>
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

<%
    String mess=(String)request.getAttribute("message");
System.out.print("mess"+mess);
    if("".equals(mess)||mess==null){}
 else{%>
    <script type="text/javascript">
        alert("<%=mess%>");
</script>

<% request.setAttribute("Message",""); }%>


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
		       
		     </ul>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
	    <!--/.navbar-collapse-->
</nav>



<nav class="navbar nav_bottom" role="navigation">
 <div class="container">
  
    <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
        <ul class="nav navbar-nav nav_1">
            <li><a href="${pageContext.request.contextPath}/admin/manager.jsp">主页</a></li>
            <li><a href="about.html">About</a></li>

            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">学生管理<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
                <li><a href="${pageContext.request.contextPath}/student/addStudent.jsp">增加学生信息</a></li>
                <li><a href="${pageContext.request.contextPath}/student/deleteStudent.jsp">删除学生信息</a></li>
                <li><a href="${pageContext.request.contextPath}/student/queryStudent.jsp">查看学生信息</a></li>
				<li><a href="${pageContext.request.contextPath}/student/queryStudent.jsp">修改学生信息</a></li>
              </ul>
            </li>

			<li><a href="${pageContext.request.contextPath}/showArea.do">查看生源地信息</a></li>
			
			
			<li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">排课管理<span class="caret"></span></a>
              <ul class="dropdown-menu" role="menu">
               
                    <li><a href="${pageContext.request.contextPath}/teacher/addTeach.jsp">为教师排课</a></li>
              </ul>
            </li>
             
        </ul>
      </div><!-- /.navbar-collapse -->
   </div>
</nav>



<form action="${pageContext.request.contextPath}/addTeach.do" method="post">
	<input type="text" name="luoyy_tno" placeholder="教师编号">
	<input type="text" name="luoyy_cno" placeholder="课程编号">
	<input type="text" name="luoyy_term" placeholder="学期">
	<select name="luoyy_classno" id="luoyy_classno" >
					<option value="1601">1601班</option>
					<option value="1602">1602班</option>
	</select>
	<select name="luoyy_mno" id="luoyy_mno">
		<option value="2681">计算机学院</option>
		<option value="2417">机械学院</option>
	</select>
	<input type="submit" name="sbmbtn" value="插入">
	
</form>
</body>
</html>
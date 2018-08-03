<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<title>更新成绩</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="keywords" content="Learn Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design">
<script async="" src="https://www.google-analytics.com/analytics.js"></script><script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
<link href="${pageContext.request.contextPath}/home/css/bootstrap2-3.1.1.min.css" rel="stylesheet" type="text/css">
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="${pageContext.request.contextPath}/home/js/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/home/js/bootstrap.min.js"></script>
<!-- Custom Theme files -->
<link href="${pageContext.request.contextPath}/home/css/style2.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/home/css/jquery.countdown.css">

<link href="https://fonts.googleapis.com/css?family=PT+Sans+Narrow:400,700" rel="stylesheet" type="text/css">
<!----font-Awesome----->
<link href="css/font-awesome.css" rel="stylesheet"> 
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

<%request.setAttribute("Message","");}%>

<nav class="navbar navbar-default" role="navigation">
	<div class="container">
	    <div class="navbar-header">
	        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
	        </button>
	        
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
  <div>
  	<div class="container">
  		
  		<p class="description">
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="${pageContext.request.contextPath}/home/teacher.jsp">教师管理页面</a></li>
                <li class="icon6"><a href="${pageContext.request.contextPath}/teacher/addReport.jsp">更新成绩页面</a></li>
                
                <li class="current-page">个人信息</li>
            </ul>
        </div>
  	</div>
  </div>


<div class="details">
       <div class="container">
	   
		<form action="${pageContext.request.contextPath}/updateReports.do">
		<input type="hidden" name="init" value="false">
		 <div class="col-sm-10 dropdown-buttons">   
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="input-group">
    		  
                <input class="form-control has-dark-background" name="luoyy_cno" value="${report.luoyy_cno}" readonly="readonly"  type="text">
              </div>
			</div>
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="input-group">
			     <input class="form-control has-dark-background" name="luoyy_term" value="${report.luoyy_term}" readonly="readonly"  type="text">
              </div>
			</div>
    	   <div class="col-sm-3 dropdown-button">           			
    		  <div class="input-group">
                <input class="form-control has-dark-background" name="luoyy_tno" value="${report.luoyy_tno}" readonly="readonly" type="text">
              </div>
			</div>
		    <div class="col-sm-3 dropdown-button">
			   <div class="input-group">
                <input class="form-control has-dark-background" name="luoyy_sno" value="${report.luoyy_sno}" readonly="readonly" type="text">
              </div>
			</div>
			<div class="clearfix"> </div>
		  </div> 
		  <div class="col-sm-2 submit_button"> 
			   
		   </div>
		   
		   <div class="clearfix"> </div>
	     
	   
		 <div class="col-sm-10 dropdown-buttons">   
			<div class="col-sm-3 dropdown-button">  
			  <div class="input-group">
                 <input style="margin-left: 10px;margin-top: 10px;float:right" class="form-control has-dark-background" name="luoyy_score" value="${report.luoyy_score}" required="" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')" type="text">
              </div>         			

			</div>

			<div class="clearfix"> </div>
		  </div> 
		  <div class="col-sm-2 submit_button"> 
			   <input type="submit" value="修改">
		   </div>
		   </form>
		   <div class="clearfix"> </div>
	     </div>
     </div>

</body>
</html>
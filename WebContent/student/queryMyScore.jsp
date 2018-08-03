<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="manage.model.Score"%>
<%@ page import="java.util.ArrayList"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Courses</title>
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

<!-- banner -->
  <div class="courses_banner">
  	<div class="container">
  		<h3>成绩查询</h3>
  		<p class="description">
        </p>
        <div class="breadcrumb1">
            <ul>
                <li class="icon6"><a href="${pageContext.request.contextPath}/home/student.jsp">学生管理页面</a></li>
                <li class="current-page">成绩查询</li>
            </ul>
        </div>
  	</div>
   </div>
   
   
   
 
				
				
    <!-- //banner -->
	<div class="courses_box1">
	   <div class="container">
	   	  <div class="col-md-3">
			<div class="courses_box1-left">
           <form action= "${pageContext.request.contextPath}/queryMyScore.do" method="post">
				<input type="hidden" name="luoyy_sno" value="${luoyy_sno}">
                 <div class="select-block1">
					<%String luoyy_term = request.getParameter("luoyy_term");  %>
                    <select name="luoyy_term" id="luoyy_term">
						<option value="all">---全部---</option>
						<option value="2016/2017(1)" <%if("2016/2017(1)".equals(luoyy_term))%><%{ %> selected="selected" <%;} %>>2016/2017(1)</option>
						<option value="2016/2017(2)" <%if("2016/2017(2)".equals(luoyy_term))%><%{ %> selected="selected" <%;} %>>2016/2017(2)</option>
					</select>
                 </div>
     
                
				<input type="submit" class="course-submit" value="查询">
				<% 
				ArrayList<Score> list=new ArrayList<Score>();
				list = (ArrayList<Score>)request.getAttribute("scoreList");
				session.setAttribute("list",list);
				session.setAttribute("classtype","Score");
				%>
				
               	<div><a href = "${pageContext.request.contextPath}/exportServlet.do"><input class="course-submit" type="button" value="导出成绩单"></a></div>                     
            </form>
	       </div>
	       <div class="personBox">
          </div>
          <div class="social-widget">
		</div>
           <section class="slider">
				<div class="flexslider">
				</div>
	      </section>
	      <ul class="posts">
         </ul>
		</div>
		<div class="col-md-9">
			<div class="course_list">
                <div class="table-header clearfix">
                	<div class="id_col">学号</div>
                	<div class="name_col">课程名</div>
                    <div class="duration_col">学期</div>
                    <div class="date_col">教师名</div>
					 <div class="date_col">得分</div>
    			</div>
				
				
				
                <ul class="table-list">
                
                
				<c:forEach var="item" items="${scoreList}">
                    <li class="clearfix">
    					<div class="id_col">${item.luoyy_sno}</div>
        				<div class="name_col">${item.luoyy_cname}</div>
						<div class="duration_col">${item.luoyy_term}</div>
        				<div class="date_col">${item.luoyy_tname}</div>
						<div class="date_col">${item.luoyy_score}</div>
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
		       <p>Copyright &copy; 2018.luoyuying</p>
	        </div>
    	</div>
    </div>

</body>
</html>	
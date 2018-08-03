<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>查看学生信息</title>
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
	<div class="details">
	<form action="${pageContext.request.contextPath}/queryStudents.do">
       
		 <div class="container">
		 <div class="col-sm-10 dropdown-buttons"> 

		 
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="section_1">
					<%String luoyy_mno = request.getParameter("luoyy_mno");  %>
					<select name="luoyy_mno" id="luoyy_mno" onChange="change_country(this.value)" class="frm-field required">
						<option value="all">---全部---</option>
						<option value="2681"  <%if("2681".equals(luoyy_mno))%><%{ %> selected="selected" <%;} %>>计算机学院</option>
						<option value="2417" <%if("2417".equals(luoyy_mno))%><%{ %> selected="selected" <%;} %>>机械学院</option>
						<option value="1356" <%if("1356".equals(luoyy_mno))%><%{ %> selected="selected" <%;} %>>艺术学院</option>
					</select>
				 
			  </div>
			</div>
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="section_1">
					<%String luoyy_classno = request.getParameter("luoyy_classno");  %>
					<select name="luoyy_classno" id="luoyy_classno" onChange="change_country(this.value)" class="frm-field required">
						<option value="all">---全部---</option>
						<option value="1601" <%if("1601".equals(luoyy_classno))%><%{ %> selected="selected" <%;} %>>1601班</option>
						<option value="1602" <%if("1602".equals(luoyy_classno))%><%{ %> selected="selected" <%;} %>>1602班</option>
					</select>
			  </div>
			</div>
    	   
		     <div class="col-sm-3 dropdown-button">
			  <div class="input-group">
			  <%
				String luoyy_sno = request.getParameter("luoyy_sno");
			%>
			<input class="has-dark-background" placeholder="学号" type="text" name="luoyy_sno" id="luoyy_sno" <%if (luoyy_sno!=null)%> <%{%> value=${luoyy_sno } <%;}%>>	
       </div>
			 </div>
			 <div class="clearfix"> </div>
		  </div> 
		  <div class="col-sm-2 submit_button"> 	   	 
				<input type="submit" value="查询"/>
		   </div>
		   <div class="clearfix"> </div>
	     </div>
		 </form>
     </div>
	
	<div class="courses_box1">
	   <div class="container">

		<div class="col-md-9">
			<div class="course_list">
                <div class="table-header clearfix">
                	<div class="id_col">学号</div>
                	<div class="name_col">姓名</div>
                    <div class="name_col">性别</div>
                    <div class="id_col">生日</div>
					<div class="id_col">籍贯</div>
                	<div class="duration_col">专业号</div>
                    <div class="id_col">班级号</div>
                    <div class="duration_col">修改</div>
    			</div>
                <ul class="table-list">
				 <c:forEach var="student" items="${studentList}">	
                    <li class="clearfix">
						<div class="id_col">${student.luoyy_sno}</div>
						<div class="name_col">${student.luoyy_sname}</div>
						<div class="name_col">${student.luoyy_ssex}</div>
						<div class="id_col">${student.luoyy_sbirthday}</div>
						<div class="id_col">${student.luoyy_birthplace}</div>
        				<div class="duration_col">${student.luoyy_mno}</div>
						<div class="id_col">${student.luoyy_classno}</div>
        				<div class="duration_col"><form action="${pageContext.request.contextPath}/updateStudent.do" style="display:inline">
						<input type="hidden" name="init" value="true">
						<input type="hidden" name="luoyy_sno" value="${student.luoyy_sno}">
						<input type="hidden" name="luoyy_sname" value="${student.luoyy_sname}">
						<input type="hidden" name="luoyy_ssex" value="${student.luoyy_ssex}">
						<input type="hidden" name="luoyy_sbirthday" value="${student.luoyy_sbirthday}">
						<input type="hidden" name="luoyy_birthplace" value="${student.luoyy_birthplace}">
						<input type="hidden" name="luoyy_scredit" value="${student.luoyy_scredit}">
						<input type="hidden" name="luoyy_mno" value="${student.luoyy_mno}">
						<input type="hidden" name="luoyy_classno" value="${student.luoyy_classno}">
						
						<input type="submit" value="修改">
			</form></div>	
    				</li>
					</c:forEach>
    			</ul>
               </div>
		    </div>
		    <div class="clearfix"> </div>
	   </div>
	</div>
</body>
</html>
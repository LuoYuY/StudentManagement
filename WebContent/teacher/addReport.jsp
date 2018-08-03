<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html><head>
<title>导入成绩</title>
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
	    
	    </div>
	    <!--/.navbar-header-->
	    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" style="height: 1px;">
	        <ul class="nav navbar-nav">
		        <li class="dropdown">
		            <a href="${pageContext.request.contextPath}/home/teacher.jsp"><i class="fa fa-user"></i><span>主页</span></a>
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
<nav class="navbar navbar-default" role="navigation" style="background-color: #2f374c !important;
border-color: #2f374c;">
	<div class="container">
	    <div class="navbar-collapse collapse" id="bs-example-navbar-collapse-1" style="height: 1px;">
	        <div style="padding:10px;font-size:18px;color:white">单个插入或批量导入</div>
	    </div>
	    <div class="clearfix"> </div>
	  </div>
</nav>

	<div class="details">
       <div class="container">
	   <form action="${pageContext.request.contextPath}/addReports.do?init=false&type=single" method="post">
		 <div class="col-sm-10 dropdown-buttons">   
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="input-group">
                <input class="form-control has-dark-background" name="luoyy_cno" id="luoyy_cno" value="${reports.luoyy_cno}"  placeholder="课程号" type="text">
              </div>
			</div>
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="input-group">
			     <input class="form-control has-dark-background" name="luoyy_term" id="luoyy_term" value="${reports.luoyy_term}" placeholder="学期" type="text">
              </div>
			</div>
    	   <div class="col-sm-3 dropdown-button">           			
    		  <div class="input-group">
			 
                <input class="form-control has-dark-background" name="luoyy_sno" id="luoyy_sno" placeholder="学号" type="text">
              </div>
			</div>
		    <div class="col-sm-3 dropdown-button">
			   <div class="input-group">
			   
                <input class="form-control has-dark-background" name="luoyy_score" id="luoyy_score" placeholder="成绩" type="text">
              </div>
			</div>
			<div class="clearfix"> </div>
		  </div> 
		  <div class="col-sm-2 submit_button"> 
			    <input type="hidden" name="luoyy_tno" value="${luoyy_tno}">
				<input type="submit" name="updBtn" id="apdBtn" value="插入">
		   </div>
		   </form>
		   <div class="clearfix"> </div>
	     </div>
     </div>


	 
	 
	 <div class="details">
       <div class="container">
	   <form action="${pageContext.request.contextPath}/queryReports.do" method="post">
			<input type="hidden" name="luoyy_tno" value="${luoyy_tno}">
			<input type="hidden" name="type" value="add">
		 <div class="col-sm-10 dropdown-buttons">   
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="section_1">
			  <%String luoyy_cno = request.getParameter("luoyy_cno");  %>
				<select name="luoyy_cno" onChange="change_country(this.value)" class="frm-field required">
					<option value="A3100" <%if("A3100".equals(luoyy_cno))%><%{ %> selected="selected" <%;} %>>数据结构</option>
					<option value="A0016" <%if("A0016".equals(luoyy_cno))%><%{ %> selected="selected" <%;} %>>离散数学</option>
					<option value="A0058" <%if("A0058".equals(luoyy_cno))%><%{ %> selected="selected" <%;} %>>数据库原理</option>
					<option value="C1120" <%if("C1120".equals(luoyy_cno))%><%{ %> selected="selected" <%;} %>>工程图学</option>
				</select>
			
			  </div>
			</div>
			<div class="col-sm-3 dropdown-button">           			
    		  <div class="section_1">
    		  <%String luoyy_term = request.getParameter("luoyy_term");  %>
				<select name="luoyy_term" onChange="change_country(this.value)" class="frm-field required"> 
					<option value="2016/2017(1)" <%if("2016/2017(1)".equals(luoyy_term))%><%{ %> selected="selected" <%;} %>>2016/2017(1)</option>
					<option value="2016/2017(2)" <%if("2016/2017(2)".equals(luoyy_term))%><%{ %> selected="selected" <%;} %>>2016/2017(2)</option>
				</select>
			  </div>
			</div>
    	   <div class="col-sm-3 dropdown-button">           			
    		  <div class="section_1">
				<select name="luoyy_mno" onChange="change_country(this.value)" class="frm-field required">
					<option value="2681">计算机学院</option>
					<option value="2417">机械学院</option>
				</select>
				 
			  </div>
			</div>
		    <div class="col-sm-3 dropdown-button">
			   <div class="section_1">
			   
				<select name="luoyy_classno" onChange="change_country(this.value)" class="frm-field required">
					<option value="1601">1601班</option>
					<option value="1602">1602班</option>
				</select>
			  </div>
			</div>
			<div class="clearfix"> </div>
		  </div> 
		  <div class="col-sm-2 submit_button"> 
			   <input type="submit" value="查询">
		   </div>
		   </form>
		   <div class="clearfix"> </div>
	     </div>
     </div>
	 
	
	<div class="courses_box1">
	   <div class="container">
   
		<div class="col-md-9">
			<div class="course_list">
                <div class="table-header clearfix">
                	
                	<div class="duration_col">学号</div>
                    <div class="duration_col">姓名</div>
                    <div class="duration_col">成绩</div>  
					<div class="duration_col">修改</div> 
    			</div>
				<form action="${pageContext.request.contextPath}/addReports.do?init=false" method="post">
                <ul class="table-list">
					<c:forEach var="item" items="${NameScoreList}">
                    <li class="clearfix">
    					
						<div class="duration_col"><input type="text" name="luoyy_sno" value="${item.luoyy_sno}" class="color:black" readonly="readonly"></div>
						<div class="duration_col"><input type="text" name="luoyy_sname" value="${item.luoyy_sname}" class="color:black"  readonly="readonly"></div>
						<div class="duration_col"><input type="text" name="luoyy_score" value="${item.luoyy_score}" class="color:black" required="" onkeyup="this.value=this.value.replace(/\D/g,'')" onafterpaste="this.value=this.value.replace(/\D/g,'')"></div>
						<div class="duration_col"><a target="_blank"  href="${pageContext.request.contextPath}/updateReports.do?luoyy_cno=${luoyy_cno}&luoyy_term=${luoyy_term}&luoyy_tno=${luoyy_tno}&luoyy_sno=${item.luoyy_sno}&luoyy_score=${item.luoyy_score}">
		<input type="button" style="display:inline" value="修改"> </a></div>
							
    				</li>
					</c:forEach>
				</ul>
				<input type="hidden" name="luoyy_tno" value="${luoyy_tno}">
				<input type="hidden" name="luoyy_cno" value="${luoyy_cno}">
				<input type="hidden" name="luoyy_term" value="${luoyy_term}">
				<input type="hidden" name="type" value="batch">
				<input type="submit" value="导入" style="float:right">
				</form>
    			</div>
		    </div>
		    <div class="clearfix"> </div>
	   </div>
	</div>
	
   
    <div class="footer">
    	<div class="container">
    		<div class="col-sm-10 dropdown-buttons">   
    		<div class="copy">
		       <p>Copyright © 2018.luoyuying</p>
	        </div>
	        </div>>
    	</div>
    </div>
</body></html>
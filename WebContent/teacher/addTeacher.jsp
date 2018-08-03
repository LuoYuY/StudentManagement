<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>增加教师</title>
</head>
<body>
	<p>${message}</p>
	<form action="../addTeacher.do" method="post">
		<table>
			<tr>
				<td>教师编号</td>
				<td>姓名</td>
				<td>性别</td>
				<td>出生年月</td>
			</tr>
	
			<tr>
				<td><input type="text" name="luoyy_tno" id="luoyy_tno"></td>
				<td><input type="text" name="luoyy_tname" id="luoyy_tname"></td>
				<td><input type="text" name="luoyy_tsex" id="luoyy_tsex"></td>
				<td><input type="text" name="luoyy_tbirthday" id="luoyy_tbirthday"></td>
			</tr>
			
			<tr>
				<td>职称</td>
				<td>联系电话</td>	
			</tr>
			
			<tr>
				<td><input type="text" name="luoyy_profess" id="luoyy_profess"></td>
				<td><input type="text" name="luoyy_tel" id="luoyy_tel"></td>
				
			</tr>
			<tr>
				<td><input type="submit" name="addBtn" id="addBtn" value="添加"></td>
			</tr>
			<p>
				<a
					href="${pageContext.request.contextPath}/manager.jsp">回到管理页面</a>
			</p>
		</table>
	</form>
</body>
</html>
package manage.control;


import javax.servlet.*;

import manage.model.Teacher;
import manage.dao.ManagerDao;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addTeacher.do")
public class AddTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ManagerDao dao = new ManagerDao();
		Teacher teacher = new Teacher();
		String message = null;
		try {
			String luoyy_tno;
			String luoyy_tname;
			String luoyy_tsex;
			String luoyy_tbirthday;
			String luoyy_profess ;
			String luoyy_tel;
			
			teacher.setLuoyy_tno(request.getParameter("luoyy_tno"));
			teacher.setLuoyy_tname(request.getParameter("luoyy_tname"));
			teacher.setLuoyy_tsex(request.getParameter("luoyy_tsex"));
			teacher.setLuoyy_tbirthday(request.getParameter("luoyy_tbirthday"));
			teacher.setLuoyy_profess(request.getParameter("luoyy_profess"));
			teacher.setLuoyy_tel(request.getParameter("luoyy_tel"));
			
			boolean success = dao.addTeacher(teacher);
			if (success) {
				message = "<li>成功插入一条记录！</li>";
			} else {
				message = "<li>插入记录错误！</li>";
			}
		} catch (Exception e) {
			message = "<li>插入记录错误！</li>";
		}
		
		
		request.setAttribute("result", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/addTeacher.jsp");
		rd.forward(request, response);
	}
}

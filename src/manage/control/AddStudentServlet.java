package manage.control;


import javax.servlet.*;

import manage.model.Student;
import manage.dao.ManagerDao;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addStudent.do")
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ManagerDao dao = new ManagerDao();
		Student student = new Student();
		String message = null;
		try {
			student.setLuoyy_sno(request.getParameter("luoyy_sno"));
			student.setLuoyy_sname(request.getParameter("luoyy_sname"));
			student.setLuoyy_ssex(request.getParameter("luoyy_ssex"));
			student.setLuoyy_sbirthday(request.getParameter("luoyy_sbirthday"));
			student.setLuoyy_birthplace(request.getParameter("luoyy_birthplace"));
			student.setLuoyy_scredit(Integer.parseInt(request.getParameter("luoyy_scredit")));
			student.setLuoyy_mno(request.getParameter("luoyy_mno"));
			student.setLuoyy_classno(request.getParameter("luoyy_classno"));
			boolean success = dao.addStudent(student);
			if (success) {
				message = "成功插入一条记录！";
			} else {
				message = "插入记录错误！";
			}
		} catch (Exception e) {
			message = "插入记录错误！";
		}
		
		
		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/addStudent.jsp");
		rd.forward(request, response);
	}
}

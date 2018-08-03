package manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.StudentDao;
import manage.model.Student;

@WebServlet("/queryStudents.do")
public class QueryAllStudentsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StudentDao dao = new StudentDao();
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList=dao.queryAllStudent(request.getParameter("luoyy_mno"),request.getParameter("luoyy_classno"),request.getParameter("luoyy_sno"));
		
		request.setAttribute("studentList", studentList);
		request.setAttribute("luoyy_mno", request.getParameter("luoyy_mno"));
		request.setAttribute("luoyy_classno", request.getParameter("luoyy_classno"));
		request.setAttribute("luoyy_sno", request.getParameter("luoyy_sno"));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/queryStudent.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

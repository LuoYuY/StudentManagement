package manage.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.StudentDao;
import manage.model.Student;

@WebServlet("/updateStudent.do")
public class UpdateStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String luoyy_sno = request.getParameter("luoyy_sno");
		String luoyy_sname = request.getParameter("luoyy_sname");
		String luoyy_ssex = request.getParameter("luoyy_ssex");
		String luoyy_sbirthday = request.getParameter("luoyy_sbirthday"); 
		String luoyy_birthplace = request.getParameter("luoyy_birthplace");
		int luoyy_scredit = Integer.parseInt(request.getParameter("luoyy_scredit"));
		String luoyy_mno = request.getParameter("luoyy_mno");
		String luoyy_classno = request.getParameter("luoyy_classno");
		Student student = new Student(luoyy_sno,luoyy_sname,luoyy_ssex,luoyy_sbirthday,luoyy_birthplace,luoyy_scredit,luoyy_mno,luoyy_classno);
		
		if(request.getParameter("init").equals("true")) {
			
			request.setAttribute("student", student);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/updateStudent.jsp");
			rd.forward(request, response);
		}
		else {
			StudentDao studentDao = new StudentDao();
			boolean res = studentDao.updateStudent(student);
			request.setAttribute("student", student);
			if(res) request.setAttribute("message","更新成功！" );
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/updateStudent.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

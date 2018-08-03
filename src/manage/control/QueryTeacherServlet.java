package manage.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.TeacherDao;
import manage.model.Teacher;
@WebServlet("/queryTeacher.do")
public class QueryTeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TeacherDao dao = new TeacherDao();
		Teacher teacher = new Teacher();
		teacher=dao.queryTeacher(request.getParameter("luoyy_tno"));
		request.setAttribute("teacher", teacher);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/showTeacher.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

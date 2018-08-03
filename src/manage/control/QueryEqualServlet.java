package manage.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.TeacherDao;
import manage.model.Course;
@WebServlet("/queryEqual.do")
public class QueryEqualServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TeacherDao dao = new TeacherDao();
		int equalScore = 0;
		equalScore=dao.queryEqual(request.getParameter("luoyy_cno"),request.getParameter("luoyy_term"),request.getParameter("luoyy_tno"));
		Course course = new Course();
		course = dao.queryCourse(request.getParameter("luoyy_cno"));
		request.setAttribute("equalScore", equalScore);
		request.setAttribute("course", course);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/showEqual.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

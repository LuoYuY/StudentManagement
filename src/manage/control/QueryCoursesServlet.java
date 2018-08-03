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
import manage.model.Course;


@WebServlet("/queryCourses.do")
public class QueryCoursesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StudentDao dao = new StudentDao();
		ArrayList<Course> coursesList = new ArrayList<Course>();
		coursesList=dao.queryCourses(request.getParameter("luoyy_classno"),request.getParameter("luoyy_mno"),request.getParameter("luoyy_term"));
		request.setAttribute("coursesList", coursesList);
		request.setAttribute("luoyy_term", request.getParameter("luoyy_term"));
		request.setAttribute("luoyy_classno", request.getParameter("luoyy_classno"));
		request.setAttribute("luoyy_mno", request.getParameter("luoyy_mno"));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/home/queryClass.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

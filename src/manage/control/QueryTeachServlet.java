package manage.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.TeacherDao;
import manage.model.Teach;
@WebServlet("/queryTeach.do")
public class QueryTeachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TeacherDao dao = new TeacherDao();
		ArrayList<Teach> teach = new ArrayList<Teach>();
		System.out.println("request.getParameter(\"luoyy_tno\")  "+request.getParameter("luoyy_tno"));
		teach=dao.queryTeach(request.getParameter("luoyy_tno"));
		request.setAttribute("teach", teach);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/showTeach.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

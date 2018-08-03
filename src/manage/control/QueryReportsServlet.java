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
import manage.model.NameScore;
import manage.model.Teach;


@WebServlet("/queryReports.do")
public class QueryReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TeacherDao dao = new TeacherDao();
		ArrayList<NameScore> NameScoreList = new ArrayList<NameScore>();

		NameScoreList=dao.queryNameScore(request.getParameter("luoyy_tno"),request.getParameter("luoyy_cno"),request.getParameter("luoyy_term"),request.getParameter("luoyy_mno"),request.getParameter("luoyy_classno"));
		request.setAttribute("NameScoreList", NameScoreList);
		
		if(request.getParameter("type").equals("show")) {
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/queryReports.jsp");
			rd.forward(request, response);
		}
		else {
			request.setAttribute("luoyy_cno",request.getParameter("luoyy_cno"));
			request.setAttribute("luoyy_term",request.getParameter("luoyy_term"));
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/addReport.jsp");
			rd.forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

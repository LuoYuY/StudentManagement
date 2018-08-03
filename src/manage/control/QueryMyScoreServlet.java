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
import manage.model.Score;
@WebServlet("/queryMyScore.do")
public class QueryMyScoreServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		StudentDao dao = new StudentDao();
		
		ArrayList<Score> scoreList = new ArrayList<Score>();
		scoreList=dao.queryMyScore(request.getParameter("luoyy_sno"),request.getParameter("luoyy_term"));
		request.setAttribute("scoreList", scoreList);
		request.setAttribute("luoyy_term", request.getParameter("luoyy_term"));
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/queryMyScore.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

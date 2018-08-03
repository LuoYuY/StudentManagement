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
import manage.model.Rank;
@WebServlet("/queryRank.do")
public class QueryRankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		TeacherDao dao = new TeacherDao();
		ArrayList<Rank> rankList = new ArrayList<Rank>();
		rankList=dao.queryRank(request.getParameter("luoyy_cno"),request.getParameter("luoyy_term"),request.getParameter("luoyy_tno"));
		request.setAttribute("rankList", rankList);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/showRank.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

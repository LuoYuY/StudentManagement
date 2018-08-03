package manage.control;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import manage.dao.TeacherDao;
import manage.model.Reports;
@WebServlet("/addReports.do")
@MultipartConfig
public class AddReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(request.getParameter("init"));
		if(request.getParameter("init").equals("true")) {
			Reports reports = new Reports();
			reports.setLuoyy_cno(request.getParameter("luoyy_cno"));
			reports.setLuoyy_term(request.getParameter("luoyy_term"));
			reports.setLuoyy_tno(request.getParameter("luoyy_tno"));
			HttpSession session = request.getSession();
			session.setAttribute("reports", reports);
			
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/addReport.jsp");
			rd.forward(request, response);
		}
		else if(request.getParameter("type").equals("single")){
			Reports reports = new Reports();
			reports.setLuoyy_cno(request.getParameter("luoyy_cno"));
			reports.setLuoyy_term(request.getParameter("luoyy_term"));
			reports.setLuoyy_tno(request.getParameter("luoyy_tno"));
			reports.setLuoyy_sno(request.getParameter("luoyy_sno"));
			reports.setLuoyy_score(Integer.parseInt(request.getParameter("luoyy_score")));
			TeacherDao dao = new TeacherDao();
			boolean res = dao.insertReports(reports);
			if(res) request.setAttribute("message","插入成功！" );
			else request.setAttribute("message","因某些原因插入失败！" );
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/addReport.jsp");
			rd.forward(request, response);
			//执行操作，成功后跳回addreport页面
		}
		else {
			TeacherDao dao = new TeacherDao();
			int sum=0;
			String[] snos = null;
			String[] scores = null;
			snos = request.getParameterValues("luoyy_sno");
			scores = request.getParameterValues("luoyy_score");
			String luoyy_cno = request.getParameter("luoyy_cno");
			String luoyy_term = request.getParameter("luoyy_term");
			String luoyy_tno = request.getParameter("luoyy_tno");
			for(int i=0;i<snos.length;i++) {
				Reports item  = new Reports();
				item.setLuoyy_cno(luoyy_cno);
				item.setLuoyy_score(Integer.parseInt(scores[i]));
				item.setLuoyy_sno(snos[i]);
				item.setLuoyy_term(luoyy_term);
				item.setLuoyy_tno(luoyy_tno);
				boolean res = dao.insertReports(item);
				if(res) sum++;
			}
			request.setAttribute("message","插入"+sum+"条成功！" );
			request.setAttribute("luoyy_cno", luoyy_cno);
			request.setAttribute("luoyy_term", luoyy_term);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/addReport.jsp");
			rd.forward(request, response);
	     }
	
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

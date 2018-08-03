package manage.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.TeacherDao;
import manage.model.Reports;



@WebServlet("/updateReports.do")
public class UpdateReportsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String luoyy_cno = request.getParameter("luoyy_cno");
		String luoyy_term = request.getParameter("luoyy_term");
		String luoyy_tno = request.getParameter("luoyy_tno");
		String luoyy_sno = request.getParameter("luoyy_sno"); 
		int luoyy_score = Integer.parseInt(request.getParameter("luoyy_score"));
		Reports report= new Reports(luoyy_cno,luoyy_term,luoyy_tno,luoyy_sno,luoyy_score);
		System.out.println("输出正常+++"+request.getParameter("init"));
		if(request.getParameter("init")==null) {
			
			request.setAttribute("report", report);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/updateReport.jsp");
			rd.forward(request, response);
		}
		else {
			TeacherDao teacherDao = new TeacherDao();
			boolean res = teacherDao.updateReport(report);
			request.setAttribute("report", report);
			if(res) request.setAttribute("message","更新成功！" );
			else request.setAttribute("message","因为某些原因更新失败！" );
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/updateReport.jsp");
			rd.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

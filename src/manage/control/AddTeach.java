package manage.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.ManagerDao;
import manage.model.TeachInfo;

@WebServlet("/addTeach.do")
public class AddTeach extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ManagerDao dao = new ManagerDao();
		TeachInfo teachinfo = new TeachInfo();
		String message = null;
		try {
			teachinfo.setLuoyy_tno(request.getParameter("luoyy_tno"));
			teachinfo.setLuoyy_cno(request.getParameter("luoyy_cno"));
			teachinfo.setLuoyy_term(request.getParameter("luoyy_term"));
			teachinfo.setLuoyy_classno(request.getParameter("luoyy_classno"));
			teachinfo.setLuoyy_mno(request.getParameter("luoyy_mno"));
			boolean success = dao.addTeachInfo(teachinfo);
			if (success) {
				message = "成功插入一条记录！";
			} else {
				message = "插入记录错误！";
			}
		} catch (Exception e) {
			message = "插入记录错误！";
		}
		
		request.setAttribute("message", message);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/teacher/addTeach.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}

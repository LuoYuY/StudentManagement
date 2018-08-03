package manage.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.ManagerDao;

@WebServlet("/deleteStudent.do")
public class DeleteStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ManagerDao dao = new ManagerDao();
		String luoyy_sno = request.getParameter("luoyy_sno");
		String luoyy_mno = request.getParameter("luoyy_mno");
		String luoyy_classno = request.getParameter("luoyy_classno");
		int res = dao.deleteStudent(luoyy_mno,luoyy_classno,luoyy_sno);
		request.setAttribute("message","成功删除"+res+"条记录！" );
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/student/deleteStudent.jsp");
		rd.forward(request, response);
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

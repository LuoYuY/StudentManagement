package manage.control;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import manage.dao.LoginDao;

@WebServlet("/loginServlet.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginServlet() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String type = request.getParameter("type");
		LoginDao loginDao = new LoginDao();
		if(type.equals("teacher")) {
			if(loginDao.checkTeacher(request.getParameter("luoyy_no"),request.getParameter("luoyy_code"))){
				HttpSession session = request.getSession();
				session.setAttribute("luoyy_tno", request.getParameter("luoyy_no"));
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/home/teacher.jsp");
				rd.forward(request, response);
			}	
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/home/index.jsp");
				rd.forward(request, response);
			}
		}
		else{
			if(loginDao.checkStudent(request.getParameter("luoyy_no"),request.getParameter("luoyy_code"))){
				HttpSession session = request.getSession();
				session.setAttribute("luoyy_sno", request.getParameter("luoyy_no"));
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/home/student.jsp");
				rd.forward(request, response);
			}	
			else {
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/home/index.jsp");
				rd.forward(request, response);
			}
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}

package manage.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import manage.dao.ManagerDao;

@WebServlet("/showArea.do")
public class ShowAreaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public ShowAreaServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		ManagerDao dao = new ManagerDao();
		Map<String, Integer> map = new HashMap<String, Integer>();
		map=dao.showArea();
		request.setAttribute("map", map);
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/showArea.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

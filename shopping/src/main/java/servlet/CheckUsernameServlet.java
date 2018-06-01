package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;

/**
 * Servlet implementation class CheckUsernameServlet
 */
public class CheckUsernameServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//获取需要验证的用户名
		String name = request.getParameter("name");
		
		int row = UserDao.checkName(name);
		
		response.getWriter().println(row);
	}

}

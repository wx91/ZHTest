package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UserDao;
import util.Md5;

/**
 * Servlet implementation class LogInServlet
 */
public class LogInServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String md5password = Md5.getMd5String(password);

		int row = UserDao.LogIn(username, md5password);

		if (row > 0) {
			response.sendRedirect(request.getContextPath() + "/jsp/product_list.jsp");
		} else {
			session.setAttribute("errorMsg", "用戶名密碼不正確，請重新輸入！！");
			response.sendRedirect(request.getContextPath() + "/jsp/login.jsp");
		}
	}

}

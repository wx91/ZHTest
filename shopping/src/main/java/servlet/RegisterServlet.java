package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import bean.User;
import dao.UserDao;
import util.Md5;
import util.UUIDUtils;

/**
 * Servlet implementation class RegisterServlet
 */
public class RegisterServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//通过UUID生成ID
		String userId = UUIDUtils.getId();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String birthday = request.getParameter("birthday");
		SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
		try {
			if (StringUtils.isNotBlank(birthday)) {
				date = dateFormat.parse(birthday);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//讲密码进行MD5加密
		password = Md5.getMd5String(password);
		
		
		User user = new User(userId, username, password, name, email, date, sex);
		
		
		//调用JDBC方法
		
		boolean flag=UserDao.register(user);
		
		if(flag){
			response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("errorMsg", "注册失败！！");
			response.sendRedirect(request.getContextPath()+"/jsp/register.jsp");
		}
	}

}

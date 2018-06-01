package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 校验验证码是否正确
 * @author THINK
 *
 */
public class CheckImgCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckImgCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//1得到用户输入的验证码
		String code = request.getParameter("code");
		//2从session域中获取保存的验证码判断
		HttpSession session = request.getSession();
		String imgCode =(String) session.getAttribute("img_code");
		if(imgCode.equalsIgnoreCase(code)){
			response.getWriter().println(0);//匹配成功
		}
		else{
			response.getWriter().println(1);//不匹配
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

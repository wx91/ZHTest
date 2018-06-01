package servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import util.CodeUtile;

/**
 * 创建验证码图片
 * @author THINK
 *
 */
public class CreateImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateImgServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取输出流
		ServletOutputStream outputStream = response.getOutputStream();
		response.setContentType("image/png");//设置图片格式
		CodeUtile codeUtile = new CodeUtile();
		BufferedImage image = codeUtile.getImage();
		String text = codeUtile.getText();
		
		//把生成好的文本存在session域中
		HttpSession session = request.getSession();
		session.setAttribute("img_code", text);
		
		CodeUtile.output(image, outputStream);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

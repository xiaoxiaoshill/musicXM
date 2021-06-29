package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userAll;
import entity.user;

/**
 * Servlet implementation class nameServlet
 */
@WebServlet("/nameServlet")
public class nameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nameServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
				// 指定允许其他域名访问
				res.setHeader("Access-Control-Allow-Origin", "*");
				// 响应类型
				res.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
				// 响应头设置
				res.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Header, HaiYi-Access-Token");
				//乱码处理
				res.setCharacterEncoding("utf-8");
				res.setContentType("text/html;charset=utf-8");
				req.setCharacterEncoding("utf-8");
				String username=(String)this.getServletContext().getAttribute("username");
				userAll us=new userAll();
				user u=us.nicknameimg(username);
				String img=u.getImg();
				res.getWriter().write(img);
	}

}

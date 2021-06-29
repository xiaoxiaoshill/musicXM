package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.userAll;
import entity.nickname;
import entity.user;

/**
 * Servlet implementation class entryServlet
 */
@WebServlet("/entryServlet")
public class entryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public entryServlet() {
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
				String username=req.getParameter("username");
				String userpassword=req.getParameter("userpassword");
				userAll us=new userAll();
				user u=us.entry(username,userpassword);
				this.getServletContext().setAttribute("username", username);
//				nickname nick=new nickname();
//				nick.setUsername(username);
//				req.setAttribute("username", username);
//				req.getRequestDispatcher("nicknameheadServlet");
//				req.getSession().setAttribute("username",username);
//				req.getAttribute(username);
//				System.out.println(username);
//				System.out.println(userpassword);
//				System.out.println(u.getUserid());
				System.out.println("调用成功！");
				if(u!=null){
					res.getWriter().write("1");
					//重定向不行，会阻止登录的进行
//					req.getRequestDispatcher("nicknameheadServlet").forward(req, res);
					//试试转发--------不行，也会阻止登录的进行
//					res.sendRedirect("nicknameheadServlet");
//					System.out.println(sun);
				}else{
					res.getWriter().write("0");
				}
	}

}

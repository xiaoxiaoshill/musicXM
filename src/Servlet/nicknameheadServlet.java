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
 * Servlet implementation class nicknameheadServlet
 */
@WebServlet("/nicknameheadServlet")
public class nicknameheadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public nicknameheadServlet() {
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
//		获取昵称与头像
//		1、获取昵称
		String username=(String)this.getServletContext().getAttribute("username");
//		2、获取头像
		userAll us=new userAll();
		user u=us.nicknameimg(username);
		String img=u.getImg();
		String sex=u.getSex();
//		System.out.println("昵称："+username+"，头像："+img+"，性别："+sex);
//		测试成功！可以获得相关数据      昵称：爱饼干的猫咪，头像：img/img1.jpg，性别：男
		res.getWriter().write(username+","+img+";"+sex);
	}

}

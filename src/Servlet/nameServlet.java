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
				// ָ������������������
				res.setHeader("Access-Control-Allow-Origin", "*");
				// ��Ӧ����
				res.setHeader("Access-Control-Allow-Methods", "POST, GET, DELETE, OPTIONS, DELETE");
				// ��Ӧͷ����
				res.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, X-Custom-Header, Header, HaiYi-Access-Token");
				//���봦��
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

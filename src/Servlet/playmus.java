package Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.seek;
import entity.mustb;



/**
 * Servlet implementation class playmus
 */
@WebServlet("/playmus")
public class playmus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public playmus() {
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
		String id=req.getParameter("mustbid");
		int mustbid=Integer.parseInt(id);
		//����id��һ��ֵ
		seek s=new seek();
		mustb mu=s.selectmusbyid(mustbid);
		String st=mu.getMusroute();
		StringBuilder str=new StringBuilder();
		str.append(st);
		System.out.println(st);
		res.getWriter().write(str.toString());
	}

}

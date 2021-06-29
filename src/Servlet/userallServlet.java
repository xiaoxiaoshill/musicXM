package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.userAll;
import entity.user;

/**
 * Servlet implementation class userallServlet
 */
@WebServlet("/userallServlet")
public class userallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userallServlet() {
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
		userAll use=new userAll();
		List<user> list=use.selectuser();
		StringBuilder str=new StringBuilder();
//		List li=new ArrayList();
		int i=0;
		for(user u:list){
//			String username=u.getUsername();
//			String userpassword=u.getUserpassword();
//			String creattime=u.getCreattime();
//			String userid=String.valueOf(u.getUserid());
//			String conservator=String.valueOf(u.getConservator());
//			String st[]={userid,conservator,username,userpassword,creattime};
//			li.add(st);
			i++;
			str.append("<tr>");
			str.append("<td>"+u.getUserid()+"</td>");
			str.append("<td>"+u.getConservator()+"</td>");
			str.append("<td>"+u.getUsername()+"</td>");
			str.append("<td>"+u.getUserpassword()+"</td>");
			str.append("<td>"+u.getCreattime()+"</td>");
			str.append("<td><button onclick='btn("+u.getUserid()+");'>删除</button></td>");
			str.append("</tr>");
//			System.out.println(i);                                      
		}
//		String js="{\"name\":\"张三\"}";
//		str.append();
//		res.getWriter().write(1);
		res.getWriter().write(str.toString());
		//测试传ID
//		String userid=req.getParameter("userid");
//		System.out.println(userid);
	}

}

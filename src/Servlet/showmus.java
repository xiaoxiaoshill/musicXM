package Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.seek;
import entity.mustb;

/**
 * Servlet implementation class showmus
 */
@WebServlet("/showmus")
public class showmus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public showmus() {
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
				seek se=new seek();
				List<mustb> list=se.selectall();
				StringBuilder str=new StringBuilder();
				int i=0;
				for(mustb mu:list){
					i++;
					str.append("<tr ondblclick='dbl("+mu.getMusid()+");'>");
					str.append("<td>"+i+"</td>");
					str.append("<td>"+mu.getMusroute()+"</td>");
					str.append("</tr>");
				}
				res.getWriter().write(str.toString());
				System.out.println("新增列表成功！");
	}

}

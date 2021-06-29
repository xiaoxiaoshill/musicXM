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
 * Servlet implementation class queryAllServlet
 */
@WebServlet("/queryAllServlet")
public class queryAllServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public queryAllServlet() {
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
		seek see=new seek();
		List<mustb> list=see.selectall();
		StringBuilder html=new StringBuilder();
//		html.append("<table>");
//		html.append("");
		for(mustb mu:list){
			html.append("<tr>");
			html.append("<td>"+mu.getMusid()+"</td>");
			html.append("<td>"+mu.getMusroute()+"</td>");
			html.append("<td>"+mu.getUploader()+"</td>");
			html.append("<td>"+mu.getTime()+"</td>");
			html.append("</tr>");
//			int musid=mu.getMusid();
//			String musroute=mu.getMusroute();
//			String singer=mu.getSinger();
//			String time=mu.getTime();
//			System.out.println(musid+";"+musroute+";"+singer+";"+time);
		}
//		html.append("</table>");
		res.getWriter().write(html.toString());
//		System.out.println(html.toString());
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i));
//			
//		}
	}

}

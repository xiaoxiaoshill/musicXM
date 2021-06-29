package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.register;
import entity.mustb;
import entity.photo;

/**
 * Servlet implementation class registerServlet
 */
@WebServlet("/registerServlet")
public class registerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerServlet() {
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
				String musroute=req.getParameter("musroute");
				String singer=req.getParameter("singer");
				String time=req.getParameter("time");
				mustb mus=new mustb();
				mus.setMusroute(musroute);
				mus.setUploader(singer);
				mus.setTime(time);
				register reg=new register();
				reg.Add(mus);
//				System.out.println("上传成功！");
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
//				String photoroute=req.getParameter("photoroute");
//				String uploadtime=req.getParameter("uploadtime");
//				photo pho=new photo();
//				pho.setPhotoroute(photoroute);
//				pho.setUploadtime(uploadtime);
//				register reg=new register();
//				reg.Add(pho);
//				String inp=req.getParameter("inp");//测试代码，无实意
//				System.out.println(inp);
	}
	
}

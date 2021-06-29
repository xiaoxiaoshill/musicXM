package Servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import dao.register;
import entity.mustb;


/**
 * Servlet implementation class uploadServlet
 */
@WebServlet("/uploadServlet")
public class uploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public uploadServlet() {
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
		res.setHeader("content-Type","text/html;charset=UTF-8");
		//new出mustb对象，用于将数据上传至数据库
		mustb mus=new mustb();
		//new出register对象，用于将mustb对象中的数据传入数据库
		register reg=new register();
		//获取当前的创建时间
		Date da=new Date();
		String time=da.toLocaleString();
		mus.setTime(time);
		//通过getparameter获得uploader
		//传输类型：模拟get方式提交
		String uploader=req.getParameter("uploader");
//		System.out.println(uploader);
		mus.setUploader(uploader);//添加上传者
		//判断是否为文件提交方式
		if(!ServletFileUpload.isMultipartContent(req)){
			//进行普通表单处理方式
			return;
		}
		
		//准备临时文件夹
		String tempath=this.getServletContext().getRealPath("\\"+"WEB-INF"+"\\"+"temp");
		File tf=new File(tempath);
		if(!tf.exists()){
			tf.mkdir();
		}
		//准备上传文件夹
		String upath="E:"+"\\"+"RuiRui"+"\\"+"text"+"\\"+"music";
		File uploadpath=new File(upath);
		if(!uploadpath.exists()){
			uploadpath.mkdir();
		}
		
		
		try{
			//上传处理工厂
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024);//每次缓存大小
			factory.setRepository(tf);
			
			//上传的对象
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setFileItemFactory(factory);
			upload.setHeaderEncoding("utf-8");
			upload.setFileSizeMax(1024*1024*15);//单次上传文件大小
			upload.setSizeMax(1024*1024*30);
			upload.setProgressListener(new ProgressListener() {
				//arg0:已经上传大小
				//arg1:总文件大小
				//arg2:当前上传序号
				@Override
				public void update(long arg0, long arg1, int arg2) {
					// TODO Auto-generated method stub
					//用来实现进度条
					System.out.println("当前正在上传第"+arg2+",以上传"+arg0+",总文件大小"+arg1);

				}
			});
			List<FileItem> fs=upload.parseRequest(req);
			for(FileItem f:fs){
				if(f.isFormField()){//普通表单数据
					String datename=f.getFieldName();
					String datevalue=f.getString();
//					System.out.println(datename+datevalue);
					
				}else{//文件
					//获取文件名
					String filename=f.getName();
					mus.setMusroute(filename);//添加上传的歌曲名
					//获得输入流
					InputStream in=f.getInputStream();
					FileOutputStream fos=new FileOutputStream(uploadpath+"\\"+filename);
					byte[] buffer=new byte[1024*1024*2];
					int len=0;
					while((len=in.read(buffer))>0){
						fos.write(buffer,0,len);
					}
					fos.close();
					mus.setMusway("E:"+"\\"+"RuiRui"+"\\"+"text"+"\\"+"music");
					reg.Add(mus);
					System.out.println(filename+":传输完毕,保存在"+"E:"+"\\"+"RuiRui"+"\\"+"text"+"\\"+"music");
				}
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}

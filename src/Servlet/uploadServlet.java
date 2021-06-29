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
		res.setHeader("content-Type","text/html;charset=UTF-8");
		//new��mustb�������ڽ������ϴ������ݿ�
		mustb mus=new mustb();
		//new��register�������ڽ�mustb�����е����ݴ������ݿ�
		register reg=new register();
		//��ȡ��ǰ�Ĵ���ʱ��
		Date da=new Date();
		String time=da.toLocaleString();
		mus.setTime(time);
		//ͨ��getparameter���uploader
		//�������ͣ�ģ��get��ʽ�ύ
		String uploader=req.getParameter("uploader");
//		System.out.println(uploader);
		mus.setUploader(uploader);//�����ϴ���
		//�ж��Ƿ�Ϊ�ļ��ύ��ʽ
		if(!ServletFileUpload.isMultipartContent(req)){
			//������ͨ����������ʽ
			return;
		}
		
		//׼����ʱ�ļ���
		String tempath=this.getServletContext().getRealPath("\\"+"WEB-INF"+"\\"+"temp");
		File tf=new File(tempath);
		if(!tf.exists()){
			tf.mkdir();
		}
		//׼���ϴ��ļ���
		String upath="E:"+"\\"+"RuiRui"+"\\"+"text"+"\\"+"music";
		File uploadpath=new File(upath);
		if(!uploadpath.exists()){
			uploadpath.mkdir();
		}
		
		
		try{
			//�ϴ���������
			DiskFileItemFactory factory=new DiskFileItemFactory();
			factory.setSizeThreshold(1024*1024);//ÿ�λ����С
			factory.setRepository(tf);
			
			//�ϴ��Ķ���
			ServletFileUpload upload=new ServletFileUpload(factory);
			upload.setFileItemFactory(factory);
			upload.setHeaderEncoding("utf-8");
			upload.setFileSizeMax(1024*1024*15);//�����ϴ��ļ���С
			upload.setSizeMax(1024*1024*30);
			upload.setProgressListener(new ProgressListener() {
				//arg0:�Ѿ��ϴ���С
				//arg1:���ļ���С
				//arg2:��ǰ�ϴ����
				@Override
				public void update(long arg0, long arg1, int arg2) {
					// TODO Auto-generated method stub
					//����ʵ�ֽ�����
					System.out.println("��ǰ�����ϴ���"+arg2+",���ϴ�"+arg0+",���ļ���С"+arg1);

				}
			});
			List<FileItem> fs=upload.parseRequest(req);
			for(FileItem f:fs){
				if(f.isFormField()){//��ͨ��������
					String datename=f.getFieldName();
					String datevalue=f.getString();
//					System.out.println(datename+datevalue);
					
				}else{//�ļ�
					//��ȡ�ļ���
					String filename=f.getName();
					mus.setMusroute(filename);//�����ϴ��ĸ�����
					//���������
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
					System.out.println(filename+":�������,������"+"E:"+"\\"+"RuiRui"+"\\"+"text"+"\\"+"music");
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
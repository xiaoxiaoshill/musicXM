package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import entity.mustb;

public class register {
	public boolean Add(mustb obj){
		boolean flag=false;
		Connection con=null;
		PreparedStatement pst=null;
		String sql="insert into mustb(musroute,uploader,musway,time) values(?,?,?,?)";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,obj.getMusroute());
			pst.setString(2,obj.getUploader());
			pst.setString(3,obj.getMusway());
			pst.setString(4,obj.getTime());
			flag=pst.executeUpdate()>0;
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				basedao.close(null, pst, con);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return flag;
	}
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.mustb;
import entity.user;

public class seek {
	public List<mustb> selectall(){//查询所有
		List<mustb> list=new ArrayList<mustb>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet re=null;
		String sql="select * from mustb";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			re=pst.executeQuery();
			while(re.next()){
				mustb mu=new mustb();
				mu.setMusid(re.getInt(1));
				mu.setMusroute(re.getString(2));
				mu.setUploader(re.getString(3));
				mu.setMusway(re.getString(4));
				mu.setTime(re.getString(5));
				list.add(mu);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				basedao.close(re, pst, con);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return list;
	}
	public mustb selectmusbyid(Integer mustbid){//根据id查询
		mustb mid=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet re=null;
		String sql="select * from  mustb where musid=?";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,mustbid);
			re=pst.executeQuery();
			while(re.next()){
				mid=new mustb();
				mid.setMusroute(re.getString("musroute"));
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				basedao.close(re,pst,con);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return mid;
	}
	public boolean updateimg(user u){//修改头像
		boolean flag=false;
		Connection con=null;
		PreparedStatement pst=null;
		String sql="update user set img=? where username=?";//根据用户名修改头像
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,u.getImg());
			pst.setString(2,u.getUsername());
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

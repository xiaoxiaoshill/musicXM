package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import entity.user;
//查询所有成员
public class userAll {
	public List<user> selectuser(){
		List<user> list=new ArrayList<user>();
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet res=null;
		String sql="select * from user";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			res=pst.executeQuery();
			while(res.next()){
				user us=new user();
				us.setUserid(res.getInt(1));
				us.setConservator(res.getInt(2));
				us.setOnlyid(res.getInt(3));
				us.setUsername(res.getString(4));
				us.setUserpassword(res.getString(5));
				us.setCreattime(res.getString(6));
				us.setImg(res.getString(7));
				list.add(us);
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}finally{
			try{
				basedao.close(res, pst, con);
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}
		return list;
	}
	//新增用户
	public boolean adduser(user obj){
		boolean flag=false;
		Connection con=null;
		PreparedStatement pst=null;
		String sql="insert into user(username,userpassword,creattime,onlyid) values(?,?,?,?)";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,obj.getUsername());
			pst.setString(2,obj.getUserpassword());
			pst.setString(3,obj.getCreattime());
			pst.setInt(4,obj.getOnlyid());
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
	//登录
	public user entry(String act,String pwd){
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet re=null;
		user u=null;
		String sql="select * from user where username=? and userpassword=?";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,act);
			pst.setString(2,pwd);
			re=pst.executeQuery();
			while(re.next()){
				int userid=re.getInt("userid");
				u=new user();
				u.setUserid(userid);
				u.setUsername(act);
				u.setUserpassword(pwd);
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
		return u;
	}
	//删除用户
	public boolean deleteuser(int id){
		boolean flag=false;
		Connection con=null;
		PreparedStatement pst=null;
		String sql="delete from user where userid=?";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setInt(1,id);
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
	//修改用户
	public boolean updateuser(user u){
		boolean flag=false;
		Connection con=null;
		PreparedStatement pst=null;
		String sql="update user set username=?,userpassword=? where userid=?";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,u.getUsername());
			pst.setString(2,u.getUserpassword());
			pst.setInt(3,u.getUserid());
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
	public user nicknameimg(String username){
		user us=null;
		Connection con=null;
		PreparedStatement pst=null;
		ResultSet re=null;
		String sql="select * from  user where username=?";
		try{
			con=basedao.getConnection();
			pst=con.prepareStatement(sql);
			pst.setString(1,username);
			re=pst.executeQuery();
			while(re.next()){
				us=new user();
				us.setImg(re.getString("img"));
				us.setSex(re.getString("sex"));
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
		return us;
	}
}

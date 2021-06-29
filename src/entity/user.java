package entity;

public class user {
private int userid;
private int conservator;
private int onlyid;
private String username;
private String userpassword;
private String creattime;
private String img;
private String sex;
public user(int userid, int conservator,int onlyid, String username, String userpassword,
		String creattime,String img,String sex) {
	super();
	this.userid = userid;
	this.conservator = conservator;
	this.onlyid=onlyid;
	this.username = username;
	this.userpassword = userpassword;
	this.creattime = creattime;
	this.img=img;
	this.sex=sex;
}
public user() {
	super();
}
public String getSex() {
	return sex;
}
public void setSex(String sex) {
	this.sex = sex;
}
public String getImg() {
	return img;
}
public void setImg(String img) {
	this.img = img;
}
public int getOnlyid() {
	return onlyid;
}
public void setOnlyid(int onlyid) {
	this.onlyid = onlyid;
}
public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public int getConservator() {
	return conservator;
}
public void setConservator(int conservator) {
	this.conservator = conservator;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public String getCreattime() {
	return creattime;
}
public void setCreattime(String creattime) {
	this.creattime = creattime;
}
@Override
public String toString() {
	return "user [userid=" + userid + ", conservator=" + conservator
			+ ", onlyid=" + onlyid + ", username=" + username
			+ ", userpassword=" + userpassword + ", creattime=" + creattime
			+ ", img=" + img + ", sex=" + sex + "]";
}
}

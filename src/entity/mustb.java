package entity;

public class mustb {
private int	musid;
private String musroute;
private String uploader;
private String musway;
private String time;
public mustb(int musid, String musroute, String uploader, String musway,
		String time) {
	super();
	this.musid = musid;
	this.musroute = musroute;
	this.uploader = uploader;
	this.musway = musway;
	this.time = time;
}
public mustb() {
	super();
}
public int getMusid() {
	return musid;
}
public void setMusid(int musid) {
	this.musid = musid;
}
public String getMusroute() {
	return musroute;
}
public void setMusroute(String musroute) {
	this.musroute = musroute;
}
public String getUploader() {
	return uploader;
}
public void setUploader(String uploader) {
	this.uploader = uploader;
}
public String getMusway() {
	return musway;
}
public void setMusway(String musway) {
	this.musway = musway;
}
public String getTime() {
	return time;
}
public void setTime(String time) {
	this.time = time;
}
@Override
public String toString() {
	return "mustb [musid=" + musid + ", musroute=" + musroute + ", uploader="
			+ uploader + ", musway=" + musway + ", time=" + time + "]";
}
}

package entity;

public class photo {
private int	photoid;
private String photoroute;
private String uploadtime;
public photo() {
	super();
}
public photo(int photoid, String photoroute, String uploadtime) {
	super();
	this.photoid = photoid;
	this.photoroute = photoroute;
	this.uploadtime = uploadtime;
}
public int getPhotoid() {
	return photoid;
}
public void setPhotoid(int photoid) {
	this.photoid = photoid;
}
public String getPhotoroute() {
	return photoroute;
}
public void setPhotoroute(String photoroute) {
	this.photoroute = photoroute;
}
public String getUploadtime() {
	return uploadtime;
}
public void setUploadtime(String uploadtime) {
	this.uploadtime = uploadtime;
}
@Override
public String toString() {
	return "photo [photoid=" + photoid + ", photoroute=" + photoroute
			+ ", uploadtime=" + uploadtime + "]";
}

}

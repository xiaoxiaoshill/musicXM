package entity;

public class nickname {
private String username;

public nickname(String username) {
	super();
	this.username = username;
}

public nickname() {
	super();
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

@Override
public String toString() {
	return "nickname [username=" + username + "]";
}
}

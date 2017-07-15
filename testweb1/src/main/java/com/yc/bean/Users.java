package com.yc.bean;

public class Users {
	private Integer uid;
	private String uname;
	private String upass;
	public Users(Integer uid, String uname, String upass) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.upass = upass;
	}
	public Users() {
		super();
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	@Override
	public String toString() {
		return "Users [uid=" + uid + ", uname=" + uname + ", upass=" + upass + "]";
	}
}

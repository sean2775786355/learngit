//����һ��JavaBean,��Ӧusers���������� 
//����һ��ʵ�������󣩣���Ӧuser���һ����¼
package com.sp.model;

public class UserBean {
	
	private int id;
	private String username;
	private String passwd;
	private int age;
	private String picturename;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPicturename() {
		return picturename;
	}
	public void setPicturename(String picturename) {
		this.picturename = picturename;
	}
	

}

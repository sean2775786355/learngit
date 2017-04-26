//这是一个UserBean<------->user表映射
//他的一个对象<------>user表的一条记录对应
package com.model;

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

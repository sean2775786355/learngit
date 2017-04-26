package com.java5;

public class CallPhone extends Telphone {

	
	//重写注解
	@Override
	public void call() {
		// TODO Auto-generated method stub
          System.out.println("通过键盘打电话!");
	}

	@Override
	public void message() {
		// TODO Auto-generated method stub
         System.out.println("通过键盘发短信！");
	}

}

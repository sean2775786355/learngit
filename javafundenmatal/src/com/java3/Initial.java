package com.java3;

public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     Dog dog=new Dog();
     dog.setAge(10);
     Dog dog2=new Dog();
     dog2.setAge(10);
     //equals是比较引用地址（equals可以比较字符串是否相同）
     if(dog.equals(dog2))
     {
    	 System.out.println("相同！");
     }else{
    	 System.out.println("不同");
     }
	}

}

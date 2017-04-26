package com.java6;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
    /*   Chinese p1=new Chinese();
       American p2=new American();
       p1.say();
       p2.say();*/
		
		//多态的使用
		APerson p1=new Chinese();
		APerson p2=new American();
		p1.say();
		p2.say();
	}

}

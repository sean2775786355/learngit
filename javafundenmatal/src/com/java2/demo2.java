package com.java2;

public class demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 demo2_1 d1=new demo2_1();
     demo2_2 d2=new demo2_2();
     d2.age=10;
     d2.eat();
     System.out.println("age="+d2.age);
     d2.method();
     System.out.println(d2.toString());
	}
    //重写toString 方法
	@Override
	public String toString() {
		return "demo2 [getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}

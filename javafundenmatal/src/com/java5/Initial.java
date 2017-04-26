package com.java5;
//抽象类演示
public class Initial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Telphone tel1=new CallPhone();
       tel1.call();
       tel1.message();
       
       Telphone tel2=new SmartPhone();
       tel2.call();
       tel2.message();
       
       IPlayGame ip1=new SmartPhone();
       ip1.playGame();
       IPlayGame ip2=new Psp();
       ip2.playGame();
		
       IPlayGame ip3=new IPlayGame() {
		
		@Override
		public void playGame() {
			// TODO Auto-generated method stub
			System.out.println("使用匿名内部类的方式实现接口");
		}
	};
	ip3.playGame();
	
	  new IPlayGame() {
		
		@Override
		public void playGame() {
			// TODO Auto-generated method stub
			System.out.println("使用匿名内部类的方式实现接口");
		}
	}.playGame();
	
		
	}

}

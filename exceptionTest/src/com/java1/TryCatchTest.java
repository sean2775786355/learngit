package com.java1;

public class TryCatchTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       TryCatchTest tct=new TryCatchTest();
       int result=tct.test();
       System.out.println("test()方法,执行完毕！返回值为"+result);
	}
	/**
	 * diviider(除数)
	 * result(结果)
	 * try-catch捕获while循环
	 * 每次循环，divide减一，result=result+100/divider
	 * @return
	 */
	
	public int test()
	{
		int divider=10;
		int result=100;
		try{
			while(divider>-1){
				divider--;
				result=result+100/divider;
				
			}
			
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("循环抛出异常");
		}
		
		return result;
		
	}

}
	
	
	
	

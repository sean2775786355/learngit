package demo5;

import java.io.FileReader;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Father father1=new Father();
          Son son1=new Son();
          father1.test1();
	}

}
class Father
{    private Son son=null;
	public void test1()
	{
		System.out.println("1");
		try {
			son.test2();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
class Son
{
	public void test2() throws Exception
	{
		FileReader fr=null;
		fr=new FileReader("d:\\dd.txt");
	}
}
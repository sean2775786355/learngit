package demo5;

import java.lang.reflect.Method;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Gen<Bird> gen1=new Gen<Bird>(new Bird());
          gen1.showTypeName();
	}

}
//定义鸟类
class Bird
{
	public void test1()
	{
		System.out.println("aa");
	}
	public void count(int a,int b)
	{
		System.out.println(a+b);
	}
}

//定义一个类
class Gen<T>
{
	private T o;
	//构造函数
	public Gen(T a)
	{
		o=a;
	}
	public void showTypeName()
	{
		System.out.println("类型是"+o.getClass().getName());
		
		
		Method [] m=o.getClass().getDeclaredMethods();
		for(int i=0;i<m.length;i++)
		{
			System.out.println(m[i].getName());
		}
	}
	//通过反射机制，我们得到T这个类型的很多信息（比如得到成员函数名）
	
}
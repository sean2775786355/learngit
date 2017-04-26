package demo1;

public class demo14 {

	public static void main(String[] args) {
	//创建一个猫对象
    Cat cat1=new Cat();
    //访问属性   对象名.属性名
	cat1.age=5;
	cat1.name="小白";
	cat1.color="白色";
	//创建第二只猫
	Cat cat2=new Cat();
	cat2.age=100;
	cat2.name="花花";
	cat2.color="花色";
	Master mymaster=new Master();
	/*Person a=new Person();
	a.age=10;
	a.name="小明";
	Person b=a;
	System.out.println(b.age);
	Person c;
	c=b;
	System.out.println("c.name="+c.name);
	c.age=9;
	System.out.println("a.age="+a.age+"b.age="+b.age+"c.age="+c.age);
*/
	Person p1=new Person();
	p1.speak();
	p1.jisuan();
	//调入可以传入参数的计算方法
	p1.jisuan(36);
	 int resu=p1.add(9, 5, 6);
	
	System.out.println("三个数和"+resu);
	}
 
}
//java中如何做一个类【类名的首字母大写】
class Cat
{
	
	int age;
	String name;
	String color;
	Master mymaster;
}
class Master
{
  int age;
  String name;
  String color;
}
//定义一个人类
class Person
{
	int age;
	String name;
	//行为
	//注意：方法的首字母是小写
	// 如何定名字1.驼峰法（匈牙利）2.下划线my_cry
	public void speak()
	{
		System.out.println("我是一个好人");
	}
	public void jisuan(int n)
	{     
		int result=0;
		for(int i=1;i<=n;i++)
		{
			result+=i;
		}
		//输出结果
		System.out.println("结果是"+result);
	}
	public void jisuan()
	{
		
		int res=0;
		for (int i=1;i<=1000;i++)
		{
			res+=i;
		}
		System.out.println("结果是"+res);
	}
	public void add(int a,int b)
	{
       int c;
		c=a+b;	
	    System.out.println("和是"+c);
	}
	//返回类型和返回结果类型要一样
	public int add(int num1,int num2,int num3)
	{
		return num1+num2+num3;
	}
	
	
	
	
}
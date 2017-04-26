package demo2;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Dog dog1=new Dog(1,"大黄");
		Person p1=new Person(dog1,10,"小明");
		p1.showInfo();
		p1.dog.showInfo();*/
		Child ch1=new Child(3,"妞妞");
		Child ch2=new Child(4,"晃晃");
		Child ch3=new Child(9,"的 DE");
		System.out.println("共有="+Child.total);
		
		
		

	}

}
class Child
{
	int age;
	String name;
	static int total=0;
	//total是静态变量，因此它可以被任何对象访问
	public Child(int age,String name)
	{    total++;
		this.age=age;
		this.name=name;
	}
	public void joinGame()
	{    
		System.out.println("加入一个小孩");
	}
	
}
class Person
{
	int age;
	String name;
	Dog dog;//引用类型
	//构造方法
	//构造方法的主要用处：初始化你的成员属性
	public Person(Dog dog,int age,String name)
	{
		this.age=age;
		this.name=name;
		this.dog=dog;
	}
	//构造方法2
	public Person(String name)
	{
		this.name=name;
	}
	public void showInfo()
	{
		System.out.println("人名是："+name);
	}
}
class Dog
{
	int age;
	String  name;
	public Dog(int age,String name)
	{
		this.age=age;
		this.name=name;
	}
	public void showInfo()
	{
		System.out.println("狗名是"+this.name);
	}
}
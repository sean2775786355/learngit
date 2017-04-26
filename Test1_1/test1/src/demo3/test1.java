package demo3;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//抽象类
abstract class Animal
{
	String name;
	int age;
	//抽象方法
	abstract public void cry();
}
//当一个类继承的父类是抽象类的话
//需要我们把抽象类中的所有抽象方法全部实现
class Cat extends Animal
{
	//实现父类
	public void cry()
	{
		System.out.println("maomaojao");
	}
}
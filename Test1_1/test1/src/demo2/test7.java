package demo2;

public class test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Animal animal1=new Animal();
		Cat cat1=new Cat();
        Dog1 dog1=new Dog1();
        cat1.cry();
        dog1.cry();
        animal1.cry();
	}

}

//动物类
class Animal
{
	int age;
	String name;
	public void cry()
	{
		System.out.println("我是动物，不知道怎么叫");
	}
}
class Cat extends Animal
{
	//覆盖父类
	public void cry()
	{
		System.out.println("喵喵叫");
	}
}
class Dog1 extends Animal
{
	public void cry()
	{
		System.out.println("旺旺叫");
	}
}
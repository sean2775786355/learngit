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

//������
class Animal
{
	int age;
	String name;
	public void cry()
	{
		System.out.println("���Ƕ����֪����ô��");
	}
}
class Cat extends Animal
{
	//���Ǹ���
	public void cry()
	{
		System.out.println("������");
	}
}
class Dog1 extends Animal
{
	public void cry()
	{
		System.out.println("������");
	}
}
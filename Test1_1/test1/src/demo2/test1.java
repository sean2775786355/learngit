package demo2;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Dog dog1=new Dog(1,"���");
		Person p1=new Person(dog1,10,"С��");
		p1.showInfo();
		p1.dog.showInfo();*/
		Child ch1=new Child(3,"��");
		Child ch2=new Child(4,"�λ�");
		Child ch3=new Child(9,"�� DE");
		System.out.println("����="+Child.total);
		
		
		

	}

}
class Child
{
	int age;
	String name;
	static int total=0;
	//total�Ǿ�̬��������������Ա��κζ������
	public Child(int age,String name)
	{    total++;
		this.age=age;
		this.name=name;
	}
	public void joinGame()
	{    
		System.out.println("����һ��С��");
	}
	
}
class Person
{
	int age;
	String name;
	Dog dog;//��������
	//���췽��
	//���췽������Ҫ�ô�����ʼ����ĳ�Ա����
	public Person(Dog dog,int age,String name)
	{
		this.age=age;
		this.name=name;
		this.dog=dog;
	}
	//���췽��2
	public Person(String name)
	{
		this.name=name;
	}
	public void showInfo()
	{
		System.out.println("�����ǣ�"+name);
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
		System.out.println("������"+this.name);
	}
}
package demo1;

public class demo14 {

	public static void main(String[] args) {
	//����һ��è����
    Cat cat1=new Cat();
    //��������   ������.������
	cat1.age=5;
	cat1.name="С��";
	cat1.color="��ɫ";
	//�����ڶ�ֻè
	Cat cat2=new Cat();
	cat2.age=100;
	cat2.name="����";
	cat2.color="��ɫ";
	Master mymaster=new Master();
	/*Person a=new Person();
	a.age=10;
	a.name="С��";
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
	//������Դ�������ļ��㷽��
	p1.jisuan(36);
	 int resu=p1.add(9, 5, 6);
	
	System.out.println("��������"+resu);
	}
 
}
//java�������һ���ࡾ����������ĸ��д��
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
//����һ������
class Person
{
	int age;
	String name;
	//��Ϊ
	//ע�⣺����������ĸ��Сд
	// ��ζ�����1.�շ巨����������2.�»���my_cry
	public void speak()
	{
		System.out.println("����һ������");
	}
	public void jisuan(int n)
	{     
		int result=0;
		for(int i=1;i<=n;i++)
		{
			result+=i;
		}
		//������
		System.out.println("�����"+result);
	}
	public void jisuan()
	{
		
		int res=0;
		for (int i=1;i<=1000;i++)
		{
			res+=i;
		}
		System.out.println("�����"+res);
	}
	public void add(int a,int b)
	{
       int c;
		c=a+b;	
	    System.out.println("����"+c);
	}
	//�������ͺͷ��ؽ������Ҫһ��
	public int add(int num1,int num2,int num3)
	{
		return num1+num2+num3;
	}
	
	
	
	
}
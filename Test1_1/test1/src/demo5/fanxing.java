package demo5;
//���ͱ�Ҫ��
import java.util.*;
public class fanxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Dog> al=new ArrayList<Dog>();
        //����һ������
        Dog dog1=new Dog();
        //���뵽����
        al.add(dog1);
        //ȡ��
        //Dog temp=(Dog)al.get(0);
        //Cat temp=(Cat)al.get(0);����ת������
       //�Զ�ת��
        Dog temp=al.get(0);
	}

}
class Cat
{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
}
class Dog
{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	private int age;
}
package demo5;
//泛型必要性
import java.util.*;
public class fanxing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayList<Dog> al=new ArrayList<Dog>();
        //创建一个对象
        Dog dog1=new Dog();
        //放入到集合
        al.add(dog1);
        //取出
        //Dog temp=(Dog)al.get(0);
        //Cat temp=(Cat)al.get(0);类型转换出错
       //自动转化
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
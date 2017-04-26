/*
 * 功能：演示多态
 */
package demo2;

public class test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          /*  Animals an=new Cats();
            an.cry();
            an=new Dogs();
            an.cry();*/
		Master master=new Master();
		master.feed(new Dogs(), new Bone());
		master.feed(new Cats(), new Fish());
		
		
	}

}
//动物类
class Animals
{   
	String name;
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
	 int age;
	 public void cry()
	 {
		 System.out.println("不知道怎么叫");
	 }
	 public void eat()
	 {
		 
	 }
}
class Master
{
	//给动物喂食物，使用多态，方法就一个
	public void feed(Animals an,Food f)
	{
		an.eat();
		f.showName();
	}
}
//food
class Food
{
	String name;
	public void showName()
	{
		
	}
}
class Fish extends Food
{
	public void  ShowName()
	{
		System.out.println("鱼");
	}
}
class Bone extends Food
{
	public void showName()
	{
		System.out.println("骨头");
	}
}



class Dogs extends Animals
{    //狗叫
	public void cry()
	{
		System.out.println("汪汪叫");
	}
	//狗吃
	public void eat()
	{
		System.out.println("狗爱吃骨头");
	}
}
class Cats extends Animals
{   //猫叫
	public void cry()
	{
		System.out.println("猫猫叫");
	}
	//猫吃
	public void eat()
	{
		System.out.println("猫爱吃鱼");
	}
}
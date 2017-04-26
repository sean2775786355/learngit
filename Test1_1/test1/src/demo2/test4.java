package demo2;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pupil p1=new Pupil();
		

	}

}
//将学生的共有属性提取，做一个父类
class Stu1
{
	public int age;
	public String name;
	public float fee;
	//编程中，如果你不希望子类继承某个属性或者方法
	//则将其声明为private
	
	
	
	
	public void printName()
	{
		System.out.println(this.name);
	}
}
//小学生
 class Pupil extends Stu1
{
	
	//交学费
	public void pay(float fee)
	{
		this.fee=fee;
	}
	
}
//中学生
 class MiddleStu extends Stu1
 {
	public void pay(float fee)
	{
		this.fee=fee*0.8f;
	}
 }
//大学生
 class College extends Stu1
 {
	public void pay(float fee)
	{
		this.fee=fee*0.5f;
	}
 }
 
 
 
 
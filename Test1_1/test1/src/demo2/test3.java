package demo2;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /* Stu stu1=new Stu(10,"aa",95);
         Stu stu2=new Stu(12,"bb",615);
         System.out.println("总价="+Stu.getTotalFee());*/
		
		Clerk clerk1=new Clerk("小花",21,6632.0f);
		System.out.println("名字是"+clerk1.name+"年龄="+clerk1.getAge()+"薪水="
		+clerk1.getSal());
	}

}
//职员
class  Clerk
{
	public String name;
	private int age;
	private float salary;
	
	public Clerk(String name,int age,float sal)
	{
		this.name=name;
		this.age=age;
		this.salary=sal;
	}
	public float getSal()
	{
		return this.salary;
	}
	public int getAge()
	{
		return this.age;
	}
}
//学生
class Stu
{
	int age;
	String name;
	int fee;
	static int totalFee;
	public Stu (int age,String name, int fee)
	{
		this.age=age;
		this.name=name;
		totalFee+=fee;
	}
	//返回总学费【这是一个类方 法（静态方法）】
	//java 中规则：类变量原则上用类方法去访问
	public static int getTotalFee()
	{
		return totalFee;
	}
	
}
package demo2;

public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /* Stu stu1=new Stu(10,"aa",95);
         Stu stu2=new Stu(12,"bb",615);
         System.out.println("�ܼ�="+Stu.getTotalFee());*/
		
		Clerk clerk1=new Clerk("С��",21,6632.0f);
		System.out.println("������"+clerk1.name+"����="+clerk1.getAge()+"нˮ="
		+clerk1.getSal());
	}

}
//ְԱ
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
//ѧ��
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
	//������ѧ�ѡ�����һ���෽ ������̬��������
	//java �й��������ԭ�������෽��ȥ����
	public static int getTotalFee()
	{
		return totalFee;
	}
	
}
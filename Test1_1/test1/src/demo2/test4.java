package demo2;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pupil p1=new Pupil();
		

	}

}
//��ѧ���Ĺ���������ȡ����һ������
class Stu1
{
	public int age;
	public String name;
	public float fee;
	//����У�����㲻ϣ������̳�ĳ�����Ի��߷���
	//��������Ϊprivate
	
	
	
	
	public void printName()
	{
		System.out.println(this.name);
	}
}
//Сѧ��
 class Pupil extends Stu1
{
	
	//��ѧ��
	public void pay(float fee)
	{
		this.fee=fee;
	}
	
}
//��ѧ��
 class MiddleStu extends Stu1
 {
	public void pay(float fee)
	{
		this.fee=fee*0.8f;
	}
 }
//��ѧ��
 class College extends Stu1
 {
	public void pay(float fee)
	{
		this.fee=fee*0.5f;
	}
 }
 
 
 
 
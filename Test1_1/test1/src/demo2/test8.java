/*
 * ���ܣ���ʾ��̬
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
//������
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
		 System.out.println("��֪����ô��");
	 }
	 public void eat()
	 {
		 
	 }
}
class Master
{
	//������ιʳ�ʹ�ö�̬��������һ��
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
		System.out.println("��");
	}
}
class Bone extends Food
{
	public void showName()
	{
		System.out.println("��ͷ");
	}
}



class Dogs extends Animals
{    //����
	public void cry()
	{
		System.out.println("������");
	}
	//����
	public void eat()
	{
		System.out.println("�����Թ�ͷ");
	}
}
class Cats extends Animals
{   //è��
	public void cry()
	{
		System.out.println("èè��");
	}
	//è��
	public void eat()
	{
		System.out.println("è������");
	}
}
package demo5;

import java.lang.reflect.Method;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
          Gen<Bird> gen1=new Gen<Bird>(new Bird());
          gen1.showTypeName();
	}

}
//��������
class Bird
{
	public void test1()
	{
		System.out.println("aa");
	}
	public void count(int a,int b)
	{
		System.out.println(a+b);
	}
}

//����һ����
class Gen<T>
{
	private T o;
	//���캯��
	public Gen(T a)
	{
		o=a;
	}
	public void showTypeName()
	{
		System.out.println("������"+o.getClass().getName());
		
		
		Method [] m=o.getClass().getDeclaredMethods();
		for(int i=0;i<m.length;i++)
		{
			System.out.println(m[i].getName());
		}
	}
	//ͨ��������ƣ����ǵõ�T������͵ĺܶ���Ϣ������õ���Ա��������
	
}
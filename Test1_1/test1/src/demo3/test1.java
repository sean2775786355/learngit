package demo3;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
//������
abstract class Animal
{
	String name;
	int age;
	//���󷽷�
	abstract public void cry();
}
//��һ����̳еĸ����ǳ�����Ļ�
//��Ҫ���ǰѳ������е����г��󷽷�ȫ��ʵ��
class Cat extends Animal
{
	//ʵ�ָ���
	public void cry()
	{
		System.out.println("maomaojao");
	}
}
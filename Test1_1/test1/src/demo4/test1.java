package demo4;

public class test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
interface Fish
{   //�÷���ʵ��*****
	public void swimming();
}
interface  Bird
{
	public void fly();
}
class Monkey
{
	String name;
	public void jump()
	{
		System.out.println("���ӻ�����");
	}
	
	
}
class LittleMonkey extends Monkey implements Fish,Bird
{

	@Override
	public void swimming() {
	
		
	}
	public void fly(){
		
	}
	
}


package demo4;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      CarShop shop=new CarShop();
      shop.sellCar(new BMW());
      shop.sellCar(new CheryQQ());
      shop.sellCar(new Santala());
      System.out.println("�����룺"+shop.getMoney());
      
      
      
	}

}

interface Car
{   //��������
	String getName();
	//��������ۼ�
	int getPrice();
}
//����
class BMW implements Car
{
	public String getName()
	{
		return "BMW";
	}
	public int getPrice()
	{
		return 300000;
	}
}
//����qq
class CheryQQ implements Car
{
	public String getName()
	{
		return "CheryQQ";
	}
	public int getPrice(){
		return  50000;
	}
}
class Santala implements Car
{
	public String getName()
	{
		return "Santala";
	}
	public int getPrice()
	{
		return 40000;
	}
	
	
}
class CarShop
{
	//�۳�����
	private int money=0;
	//����һ����
	public void sellCar(Car car)
	{
		System.out.println("���ͣ�"+car.getName()+"���ۣ�"+car.getPrice());
		//�����������ۼ۵�����
		money+=car.getPrice();
		
	}
	//�۳�������
	public int getMoney()
	{
		return money;
	}
	
	
}




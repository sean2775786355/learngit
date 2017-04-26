package demo4;

public class test2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      CarShop shop=new CarShop();
      shop.sellCar(new BMW());
      shop.sellCar(new CheryQQ());
      shop.sellCar(new Santala());
      System.out.println("总收入："+shop.getMoney());
      
      
      
	}

}

interface Car
{   //汽车名称
	String getName();
	//获得汽车售价
	int getPrice();
}
//宝马
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
//奇瑞qq
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
	//售车收入
	private int money=0;
	//卖出一部车
	public void sellCar(Car car)
	{
		System.out.println("车型："+car.getName()+"单价："+car.getPrice());
		//增加卖出车售价的收入
		money+=car.getPrice();
		
	}
	//售车总收入
	public int getMoney()
	{
		return money;
	}
	
	
}




/*
 * 功能：接口的讲解
 */

package demo3;

public class test2 {

	public static void main(String[] args) {
		
      Computer computer=new Computer();
      Camera camera1=new Camera();
      Phone phone1=new Phone();
      computer.useUsb(camera1);
      computer.useUsb(phone1);
	}

}


interface Usb
{
	//声明两个方法
	//开始工作
	public void start();
	//停止工作
	public void stop();
}
class Camera implements Usb
{
	public void start()
	{
		System.out.println("我是相机，开始工作了");
	}
	public void stop()
	{
		System.out.println("我是相机，停止工作了");
	}
	
	
}
class Phone implements Usb
{
	public void start()
	{
		System.out.println("我是手机。开始工作");
	}
	public void stop()
	{
		System.out.println("我是手机，停止工作了");
	}
}
class Computer
{
	public void useUsb(Usb usb){
        usb.start();
        usb.stop();
	}
}
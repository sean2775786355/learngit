/*
 * ���ܣ��ӿڵĽ���
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
	//������������
	//��ʼ����
	public void start();
	//ֹͣ����
	public void stop();
}
class Camera implements Usb
{
	public void start()
	{
		System.out.println("�����������ʼ������");
	}
	public void stop()
	{
		System.out.println("���������ֹͣ������");
	}
	
	
}
class Phone implements Usb
{
	public void start()
	{
		System.out.println("�����ֻ�����ʼ����");
	}
	public void stop()
	{
		System.out.println("�����ֻ���ֹͣ������");
	}
}
class Computer
{
	public void useUsb(Usb usb){
        usb.start();
        usb.stop();
	}
}
package demo5;
import java.io.*;
import java.net.*;
public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //����쳣1.���ļ�
		try {
			//�ڳ����쳣�ĵط�������ִֹ�д���
			//Ȼ�����catch
			//����ж��catch��䣬���ƥ����Ǹ�
			FileReader fr=new FileReader("d:\\aa.text");
		}//��󲶻� 
		catch (FileNotFoundException e) {
			//���쳣����Ϣ����������Ŵ�bug
			e.printStackTrace();
		}finally{
			//������飬������û���쳣������ִ��
			//һ��˵������Ҫ�رյ���Դ��[�ļ������ӣ��ڴ档������]
			
		}
		
		//2.����һ��192.168.12.12 IP�˿�4567
		//Socket s=new Socket("192.168.12.0",78);
		//�����쳣
		//int a=4/0;
		//����Խ��
		//int arr[]={1,3,3};
		//System.out.print(arr[3]);
		
		
	}

}

/*
 * ʵ��һ����ѧ���ɼ�����ϵͳ
 * ����һ�����飬�û�����10��ͬѧ�ĳɼ��������±꼴����ѧ��ѧ��
 * Ҫ��
 * 1.����ѧ�ţ���ӡ��ѧ���ɼ�
 * 2.����ɼ�����ӡ��ѧ��ѧ��
 * 3.ͳ�Ƹ���������ѧ�������������񣬲�У������ţ�
 * 4.����ѧ�ţ�ʵ��ɾ��ѧ���ɼ���Ů����
 */
package demo6;
import java.io.*;
import java.util.Scanner;
public class job2 {

	public static void main(String[] args) {
		Manage m=new Manage();
		m.checkGrade(1);
	
          
	}

}
class Manage
{        BufferedReader br=new BufferedReader
	     (new InputStreamReader(System.in));
	float grades[]=null;
	int stuNumber=5;
	//���캯��
	public Manage()
	{    
	     grades=new float [stuNumber];
	    try {
			for(int i=0;i<grades.length;i++)
			{
			   System.out.println("������ѧ��Ϊ"+(i+1)+"ѧ���ɼ�");
			   grades[i]=Float.parseFloat(br.readLine());
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				br.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	 
	 public void checkGrade(int i)
	 {    
	    	System.out.println(grades[i]);
	      
	 }
	 
	
}
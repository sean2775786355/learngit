package demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
        	InputStreamReader isr=new InputStreamReader(System.in);
        	BufferedReader br=new BufferedReader(isr);
        	System.out.println("�������һ����");
        	String a1=br.readLine();
        	System.out.println("������ڶ�����");
        	String a2=br.readLine();
        	//��String ->float
        	float num1=Float.parseFloat(a1);
        	float num2=Float.parseFloat(a2);
        	if(num1>num2){
        		System.out.println("��һ������");
        		
        	}
        	if(num1==num2)
        	{
        		System.out.println("���");
        		
        	}
        	if(num1<num2)
        	{
        		System.out.println("�ڶ�������");
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

}

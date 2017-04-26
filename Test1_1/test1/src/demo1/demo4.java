package demo1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class demo4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try{
        	InputStreamReader isr=new InputStreamReader(System.in);
        	BufferedReader br=new BufferedReader(isr);
        	System.out.println("请输入第一个数");
        	String a1=br.readLine();
        	System.out.println("请输入第二个数");
        	String a2=br.readLine();
        	//把String ->float
        	float num1=Float.parseFloat(a1);
        	float num2=Float.parseFloat(a2);
        	if(num1>num2){
        		System.out.println("第一个数大");
        		
        	}
        	if(num1==num2)
        	{
        		System.out.println("相等");
        		
        	}
        	if(num1<num2)
        	{
        		System.out.println("第二个数大");
        	}
        }catch(Exception e){
        	e.printStackTrace();
        }
	}

}

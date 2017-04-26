package com;
import java.io.*;
public class BufferedReaderTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       String s1=null;
       int n1;
       try {
    	    s1=br.readLine();
    	    //记着关闭资源
    	    n1=br.read();
    	    br.close();
    	    System.out.println("s1="+s1+"n1="+n1);
            } catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    
      
    
    
	}

}

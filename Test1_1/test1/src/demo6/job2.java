/*
 * 实现一个简单学生成绩管理系统
 * 定义一个数组，用户输入10个同学的成绩，数组下标即代表学生学号
 * 要求：
 * 1.输入学号，打印该学生成绩
 * 2.输入成绩，打印该学生学号
 * 3.统计各个分数段学生人数（不及格，差，中，良，优）
 * 4.输入学号，实现删除学生成绩美女功能
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
	//构造函数
	public Manage()
	{    
	     grades=new float [stuNumber];
	    try {
			for(int i=0;i<grades.length;i++)
			{
			   System.out.println("请输入学号为"+(i+1)+"学生成绩");
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
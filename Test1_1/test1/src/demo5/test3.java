package demo5;
import java.io.*;
import java.net.*;
public class test3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //检查异常1.打开文件
		try {
			//在出现异常的地方，就终止执行代码
			//然后进入catch
			//如果有多个catch语句，输出匹配的那个
			FileReader fr=new FileReader("d:\\aa.text");
		}//最大捕获 
		catch (FileNotFoundException e) {
			//把异常的信息输出，利于排错bug
			e.printStackTrace();
		}finally{
			//这个语句块，不管有没有异常，都会执行
			//一般说，把需要关闭的资源。[文件，连接，内存。。。。]
			
		}
		
		//2.链接一个192.168.12.12 IP端口4567
		//Socket s=new Socket("192.168.12.0",78);
		//运行异常
		//int a=4/0;
		//数组越界
		//int arr[]={1,3,3};
		//System.out.print(arr[3]);
		
		
	}

}

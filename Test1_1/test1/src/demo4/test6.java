/*
 * 功能：对象数组的使用
 */
package demo4;
import java.io.*;

public class test6 {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
       //定义一个可以存放四只狗的对象数组
		Dog dog[]=new Dog[4];
		
		/*for(int i=0;i<4;i++)
		{
			dog[i]=new Dog();
		}
		//给各个狗赋初值
		
		dog[0].setName("花花");
		dog[0].setWeight(4.5f);*/
		//从控制台输入各个狗的信息
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		for(int i=0;i<4;i++)
		{
			dog[i]=new Dog();
			System.out.println("请输"+(i+1)+"入狗名");
			
				String name = br.readLine();
				//异常
			     dog[i].setName(name);
			     System.out.println("请输入"+(i+1)+"狗的体重");
			     String s_weight=br.readLine();
			     float weight=Float.parseFloat(s_weight);
			     //将名字赋给对象
			     dog[i].setWeight(weight);
		}
		//计算总体重
		float allWeight=0;
		for(int i=0;i<4;i++)
		{
			allWeight+=dog[i].getWeight();
		}
		System.out.println("平均体重="+(allWeight/dog.length));
	    //找体重最大的狗
		//假设第一只狗最大
		float maxWeight=dog[0].getWeight();
		//依次与后面狗比较
		int maxIndex=0;
		for(int i=1;i<dog.length;i++)
		{
		
			if(maxWeight<dog[i].getWeight())
			{
				//修改
				maxWeight=dog[i].getWeight();
				maxIndex=i;
				
				
			}
			
		}
		System.out.println("体重最大狗是第"+(maxIndex+1)
				+"体重是"+dog[maxIndex].getWeight());
		//比较字符串内容是否相等用equals() 不要用==
		
		
		
	}

}
//定义一个狗类
class Dog
{
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	private float weight;
}
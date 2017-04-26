//演示各种排序法

package demo4;
import java.util.*;
public class test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len=200000;
		int arr[]=new int[len];
		for(int i=0;i<len;i++)
		{   //Math.random() 会产生一个0-1数
			int t=(int)(Math.random()*10000);
			 arr[i]=t;
		}
		/*int arr[]={1,9,5,3,95,-45};*/
		
      Sorting sort=new Sorting();
     // sort.bubble1(arr);
      //在排序前打印系统时间
      Calendar cal=Calendar.getInstance();
     System.out.println( "排序前"+cal.getTime());
      sort.select(arr);
      cal=Calendar.getInstance();
      System.out.println("排序后"+cal.getTime()); 
    //输出结果
  /*	for(int i=0;i<arr.length;i++)
  	{
  		System.out.print(arr[i]+" ");
  	}*/
        
		
		
		
	}
	
	
}
class Sorting
{   //冒泡排序
	public void bubble(int arr[])
	{   
		int temp=0;
        //排序
        //外层循环。他决定一共走几趟
		for (int i=0;i<arr.length-1;i++)
		{
			//内层循环，开始逐一比较，如果发现前一个数比后一个数大，则交换
			for(int j=0;j<arr.length-1-i;j++)
			{
				
				if(arr[j]>arr[j+1])
				{
					//换位
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
			
			
		}
		
	}
    public void bubble1(int arr[])

    {
    	
    	//外层循环
    	int temp=0;
    	for(int i=0;i<arr.length-1;i++)
    	{
    		//内层循环
    		for(int j=0;j<arr.length-1-i;j++)
    		{
    			//如果前一个数比后一个数大，则交换位置
    			if(arr[j]>arr[j+1])
    			{
    				temp=arr[j+1];
    				arr[j+1]=arr[j];
    				arr[j]=temp;
    			}
    		}
    	}
    	
    	
    	
    	
    }
    //选择排序    
    public void select(int arr[])
    {
    	int temp=0;
    	for (int j=0;j<arr.length-1;j++){
    		//我认为第一个数最小
        	int min=arr[j];
        	//记录最小数下标
        	int minIndex=j;
        	for(int k=j+1;k<arr.length;k++)
        	{
        		if(min>arr[k])
        		{
        			//修改最小
        			min=arr[k];
        			minIndex=k;
        			
        		}
        	}
        	//当退出for就找到这次最小值
        	temp=arr[j];
        	arr[j]=arr[minIndex];
        	arr[minIndex]=temp;
    	}
    }
	public void select1(int arr[])
	{   int temp=0;
		//外层一共比较次数
		for(int i=0;i<arr.length-1;i++)
		{    //找最小值
			int min=arr[i];
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(min>arr[j])
				{
					//换位
					min=arr[j];
					minIndex=j;
					
				}
				
			}
			//已找到最小值
			temp=min;
			arr[minIndex]=arr[i];
			arr[i]=min;
			
		}
	}
    //插入排序方法
	public void insertsort(int arr[])
	{
		for (int i=1;i<arr.length;i++)
		{
			int insertVal=arr[i];
			//insertVal准备和前一个数比较
			int index=i-1;
			while(index>=0&&insertVal<arr[index])
			{
				//就把arr[index]向后移动
				arr[index+1]=arr[index];
				//index向前移动
				index--;
			}
			//将insertVal 插入适当位置
			arr[index+1]=insertVal;
		}
	}
    //快速排序法
	
		
		
		
	}
	
	



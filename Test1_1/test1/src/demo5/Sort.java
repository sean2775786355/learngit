package demo5;

public class Sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arr[]={3,-8,5,9,12,-96,126,7};
        Order order=new Order();
        order.insert(arr);
        for(int j=0;j<arr.length;j++)
        {
        	System.out.print(arr[j]+" ");
        }
        BinaryFind find1=new BinaryFind();
        find1.find(0, arr.length-1,126, arr);
        
	}

}


class Order
{   //冒泡法排序
	public void bubble(int arr[])
	{
		//外层比较次数
		int temp=0;
		for(int i=0;i<arr.length-1;i++)
		{
			for(int j=0;j<arr.length-1-i;j++)
			{
		        if(arr[j]>arr[j+1])
		        {
		        	temp=arr[j];
		        	arr[j]=arr[j+1];
		        	arr[j+1]=temp;
		        	
		        	
		        }
			}
		}
	}
	//选择排序
	public void select(int arr[])
	{   
		//假设第一个数最小
		for(int i=0;i<arr.length-1;i++)
		{   //假设最小值是arr[i] 
			 int min=arr[i];
	         int minIndex=i;
			for(int k=i+1;k<arr.length;k++)
			{    
				
				if(min>arr[k])
				{
					//交换位置
                    min=arr[k];
				    minIndex=k;	
				}
				
			}
			//找到最小值min
			arr[minIndex]=arr[i];
			arr[i]=min;
		}
		
		
	}
	//插入式排序
	public void insert(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int insertVal=arr[i];
			int index=i-1;
			while(index>=0&&(insertVal<arr[index]))
			{       //比较值向前   
			    	arr[index+1]=arr[index];
			    	//插入值后退
			    	index--;
			    	
			    	
			}
			arr[index+1]=insertVal;
		}
	}
}
class BinaryFind
{
	public void find(int leftIndex,int rightIndex,int val,int arr[])
	{
		
		int midIndex=(leftIndex+rightIndex)/2;
		int midVal=arr[midIndex];
		if(rightIndex>=leftIndex){
		if(midVal>val)
		{   //左边找
			find(leftIndex,midIndex-1, val,arr);
		}else if(midVal<val)
		{
			find(midIndex+1,rightIndex,val,arr);
		}else  if(midVal==val){
			System.out.println("找到数下标是"+midIndex);

		}
		
	}
		
		
	}
}
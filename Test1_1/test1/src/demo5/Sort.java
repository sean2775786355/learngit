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
{   //ð�ݷ�����
	public void bubble(int arr[])
	{
		//���Ƚϴ���
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
	//ѡ������
	public void select(int arr[])
	{   
		//�����һ������С
		for(int i=0;i<arr.length-1;i++)
		{   //������Сֵ��arr[i] 
			 int min=arr[i];
	         int minIndex=i;
			for(int k=i+1;k<arr.length;k++)
			{    
				
				if(min>arr[k])
				{
					//����λ��
                    min=arr[k];
				    minIndex=k;	
				}
				
			}
			//�ҵ���Сֵmin
			arr[minIndex]=arr[i];
			arr[i]=min;
		}
		
		
	}
	//����ʽ����
	public void insert(int arr[])
	{
		for(int i=1;i<arr.length;i++)
		{
			int insertVal=arr[i];
			int index=i-1;
			while(index>=0&&(insertVal<arr[index]))
			{       //�Ƚ�ֵ��ǰ   
			    	arr[index+1]=arr[index];
			    	//����ֵ����
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
		{   //�����
			find(leftIndex,midIndex-1, val,arr);
		}else if(midVal<val)
		{
			find(midIndex+1,rightIndex,val,arr);
		}else  if(midVal==val){
			System.out.println("�ҵ����±���"+midIndex);

		}
		
	}
		
		
	}
}
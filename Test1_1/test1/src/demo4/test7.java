//��ʾ��������

package demo4;
import java.util.*;
public class test7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int len=200000;
		int arr[]=new int[len];
		for(int i=0;i<len;i++)
		{   //Math.random() �����һ��0-1��
			int t=(int)(Math.random()*10000);
			 arr[i]=t;
		}
		/*int arr[]={1,9,5,3,95,-45};*/
		
      Sorting sort=new Sorting();
     // sort.bubble1(arr);
      //������ǰ��ӡϵͳʱ��
      Calendar cal=Calendar.getInstance();
     System.out.println( "����ǰ"+cal.getTime());
      sort.select(arr);
      cal=Calendar.getInstance();
      System.out.println("�����"+cal.getTime()); 
    //������
  /*	for(int i=0;i<arr.length;i++)
  	{
  		System.out.print(arr[i]+" ");
  	}*/
        
		
		
		
	}
	
	
}
class Sorting
{   //ð������
	public void bubble(int arr[])
	{   
		int temp=0;
        //����
        //���ѭ����������һ���߼���
		for (int i=0;i<arr.length-1;i++)
		{
			//�ڲ�ѭ������ʼ��һ�Ƚϣ��������ǰһ�����Ⱥ�һ�������򽻻�
			for(int j=0;j<arr.length-1-i;j++)
			{
				
				if(arr[j]>arr[j+1])
				{
					//��λ
					temp=arr[j];
					arr[j]=arr[j+1];
					arr[j+1]=temp;
				}
			}
			
			
			
		}
		
	}
    public void bubble1(int arr[])

    {
    	
    	//���ѭ��
    	int temp=0;
    	for(int i=0;i<arr.length-1;i++)
    	{
    		//�ڲ�ѭ��
    		for(int j=0;j<arr.length-1-i;j++)
    		{
    			//���ǰһ�����Ⱥ�һ�������򽻻�λ��
    			if(arr[j]>arr[j+1])
    			{
    				temp=arr[j+1];
    				arr[j+1]=arr[j];
    				arr[j]=temp;
    			}
    		}
    	}
    	
    	
    	
    	
    }
    //ѡ������    
    public void select(int arr[])
    {
    	int temp=0;
    	for (int j=0;j<arr.length-1;j++){
    		//����Ϊ��һ������С
        	int min=arr[j];
        	//��¼��С���±�
        	int minIndex=j;
        	for(int k=j+1;k<arr.length;k++)
        	{
        		if(min>arr[k])
        		{
        			//�޸���С
        			min=arr[k];
        			minIndex=k;
        			
        		}
        	}
        	//���˳�for���ҵ������Сֵ
        	temp=arr[j];
        	arr[j]=arr[minIndex];
        	arr[minIndex]=temp;
    	}
    }
	public void select1(int arr[])
	{   int temp=0;
		//���һ���Ƚϴ���
		for(int i=0;i<arr.length-1;i++)
		{    //����Сֵ
			int min=arr[i];
			int minIndex=i;
			for(int j=i+1;j<arr.length;j++)
			{
				
				if(min>arr[j])
				{
					//��λ
					min=arr[j];
					minIndex=j;
					
				}
				
			}
			//���ҵ���Сֵ
			temp=min;
			arr[minIndex]=arr[i];
			arr[i]=min;
			
		}
	}
    //�������򷽷�
	public void insertsort(int arr[])
	{
		for (int i=1;i<arr.length;i++)
		{
			int insertVal=arr[i];
			//insertVal׼����ǰһ�����Ƚ�
			int index=i-1;
			while(index>=0&&insertVal<arr[index])
			{
				//�Ͱ�arr[index]����ƶ�
				arr[index+1]=arr[index];
				//index��ǰ�ƶ�
				index--;
			}
			//��insertVal �����ʵ�λ��
			arr[index+1]=insertVal;
		}
	}
    //��������
	
		
		
		
	}
	
	



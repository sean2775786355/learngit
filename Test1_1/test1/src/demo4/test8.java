/*
 * ���ܣ����ֲ���
 */
package demo4;

public class test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     int arr[]={2,5,7,12,25};
     BinaryFind bf=new BinaryFind();
     bf.find(0, arr.length-1,25, arr);
	}

}
class BinaryFind
{
	public void find(int leftIndex,int rightIndex,int val,int arr[])
	{   
		//�������м���
		int midIndex=((rightIndex+leftIndex)/2);
		int midVal=arr[midIndex];
		if(leftIndex<=rightIndex)
		{
		if(midVal>val)
		{
			//��arr�����
			find(leftIndex,midIndex-1,val,arr);
			
		}else if(midVal<val)
		{
			//��arr�ұ���
			find(midIndex+1,rightIndex,val,arr);
		}else if (midVal==val)
		{
			System.out.println("�ҵ��±�"+midIndex);
		}
		}
	}
}
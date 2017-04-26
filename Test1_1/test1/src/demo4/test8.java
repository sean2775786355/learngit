/*
 * 功能：二分查找
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
		//首先找中间数
		int midIndex=((rightIndex+leftIndex)/2);
		int midVal=arr[midIndex];
		if(leftIndex<=rightIndex)
		{
		if(midVal>val)
		{
			//在arr左边找
			find(leftIndex,midIndex-1,val,arr);
			
		}else if(midVal<val)
		{
			//在arr右边找
			find(midIndex+1,rightIndex,val,arr);
		}else if (midVal==val)
		{
			System.out.println("找到下标"+midIndex);
		}
		}
	}
}
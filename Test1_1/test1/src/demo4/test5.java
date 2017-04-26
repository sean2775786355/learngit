package demo4;

public class test5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//定义一个size=5的int 数组
		/*int arr[];
		arr=new int[5];
		//如果你访问的数组越界
		//arr[5]=20;
		//如何知道数组大小
		//System.out.println(arr.length);*/
		float arr[]={3,6,7,7.1f,1.1f,3};
		float all=0;
		for(int i=0;i<arr.length;i++)
		{
			all+=arr[i];
		}
		System.out.println("平均="+(all/arr.length));
		double res=1;
		for(int j=1;j<=10;j++)
		{
			res*=j;
		}
		System.out.println("1*到100="+res);

	}

}

package demo4;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //定义一个可以存放六个float类型的数组
		float arr[]=new float[6];
		//使用for赋值
		//给数组的各个元素赋值
		arr[0]=3;
		arr[1]=5;
		arr[2]=1;
		arr[3]=3.4f;
		arr[4]=50;
		//计算总（for）数组遍历
		float all=0;
		for(int i=0;i<arr.length;i++)
		{
			all+=arr[i];
		}
		System.out.println("all="+all);
		
		
		
	}

}

package demo4;

public class test4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //����һ�����Դ������float���͵�����
		float arr[]=new float[6];
		//ʹ��for��ֵ
		//������ĸ���Ԫ�ظ�ֵ
		arr[0]=3;
		arr[1]=5;
		arr[2]=1;
		arr[3]=3.4f;
		arr[4]=50;
		//�����ܣ�for���������
		float all=0;
		for(int i=0;i<arr.length;i++)
		{
			all+=arr[i];
		}
		System.out.println("all="+all);
		
		
		
	}

}

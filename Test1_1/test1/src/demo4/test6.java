/*
 * ���ܣ����������ʹ��
 */
package demo4;
import java.io.*;

public class test6 {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
       //����һ�����Դ����ֻ���Ķ�������
		Dog dog[]=new Dog[4];
		
		/*for(int i=0;i<4;i++)
		{
			dog[i]=new Dog();
		}
		//������������ֵ
		
		dog[0].setName("����");
		dog[0].setWeight(4.5f);*/
		//�ӿ���̨�������������Ϣ
		InputStreamReader isr=new InputStreamReader(System.in);
		BufferedReader br=new BufferedReader(isr);
		for(int i=0;i<4;i++)
		{
			dog[i]=new Dog();
			System.out.println("����"+(i+1)+"�빷��");
			
				String name = br.readLine();
				//�쳣
			     dog[i].setName(name);
			     System.out.println("������"+(i+1)+"��������");
			     String s_weight=br.readLine();
			     float weight=Float.parseFloat(s_weight);
			     //�����ָ�������
			     dog[i].setWeight(weight);
		}
		//����������
		float allWeight=0;
		for(int i=0;i<4;i++)
		{
			allWeight+=dog[i].getWeight();
		}
		System.out.println("ƽ������="+(allWeight/dog.length));
	    //���������Ĺ�
		//�����һֻ�����
		float maxWeight=dog[0].getWeight();
		//��������湷�Ƚ�
		int maxIndex=0;
		for(int i=1;i<dog.length;i++)
		{
		
			if(maxWeight<dog[i].getWeight())
			{
				//�޸�
				maxWeight=dog[i].getWeight();
				maxIndex=i;
				
				
			}
			
		}
		System.out.println("��������ǵ�"+(maxIndex+1)
				+"������"+dog[maxIndex].getWeight());
		//�Ƚ��ַ��������Ƿ������equals() ��Ҫ��==
		
		
		
	}

}
//����һ������
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
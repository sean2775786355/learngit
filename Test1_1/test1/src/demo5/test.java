package demo5;
import java.util.*;
import java.io.*;
public class test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//����EmpManage����
        EmpManage em=new EmpManage();
        
        //����һ�����ײ˵�
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
        	System.out.println("��ѡ����Ҫ���еĲ���");
        	System.out.println("1:��ʾ���һ����Ա");
        	System.out.println("2:��ʾ����һ����Ա");
        	System.out.println("3���޸�һ����Ա����");
        	System.out.println("4��ɾ��һ����Ա");
        	System.out.println("5:�˳�");
        	String operType=br.readLine();
        	if(operType.equals("1"))
        	{
        		System.out.println("��������");
        		String empNo=br.readLine();
        		System.out.println("����������");
        		String name=br.readLine();
        		System.out.println("�����빤��");
        		float sal=Float.parseFloat(br.readLine());
        		Emp emp=new Emp(empNo,name,sal);
        		em.addEmp(emp);
        		
        	}else if(operType.equals("2"))
        	{  
        		System.out.println("��������");
        		String empNo=br.readLine();
        		
        		em.showInfo(empNo);
        		
        	}else if(operType.equals("3"))
        	{
        		System.out.println("��������");
        		String empNo=br.readLine();
        		System.out.println("�������¹���");
        		float sal1=Float.parseFloat(br.readLine());
        		em.updateSal(empNo,sal1 );
        	}else if(operType.equals("4"))
        	{
        		System.out.println("��������");
        		String empNo=br.readLine();
        		em.delEmp(empNo);
        		
        	}else if(operType.equals("5"))
        	{
        		System.exit(0);
        	}
        }
	}

}
//��Ա������
class EmpManage
{   
	private ArrayList al=null;
	//����
	public EmpManage()
	{
		al=new ArrayList();
	}
	//����Ա��
	public void addEmp(Emp emp)
	{
		al.add(emp);
	}
	//��ʾԱ���������Ϣ
	public void showInfo(String empNo)
	{
		//��������ArrayList
		for(int i=0;i<al.size();i++)
		{
			//ȡ��empNo
			Emp emp=(Emp)al.get(i);
			//�Ƚϱ��
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.println("�ҵ���Ա����������Ϣ�ǣ�");
				System.out.println("���="+empNo);
				System.out.println("����="+emp.getName());
				System.out.println("нˮ="+emp.getSal());
			}
			
		}
		
		
	}
    //�޸Ĺ���
	public void updateSal(String empNo,float newSal)
	{
		for(int i=0;i<al.size();i++)
		{
			Emp emp=(Emp)al.get(i);
			if(emp.getEmpNo().equals(empNo))
			{
				emp.setSal(newSal);
			}
		}
	}
    //ɾ��ĳ��Ա��
	public void delEmp(String empNo)
	{
	   for(int i=0;i<al.size();i++)
	   {
		   Emp emp=(Emp)al.get(i);
		   if(emp.getEmpNo().equals(empNo))
		   {
			   al.remove(i);
		   }
	   }
	}
}


class Emp
{
	//ѧ��
	private String empNo;
	public String getEmpNo() {
		return empNo;
	}
	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getSal() {
		return sal;
	}
	public void setSal(float sal) {
		this.sal = sal;
	}
	private String name;
	private float sal;
	//���캯��
	public Emp(String empNo,String name,float sal)
	{
		this.empNo=empNo;
		this.name=name;
		this.sal=sal;
	}
	
}
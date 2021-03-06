package demo5;
import java.util.*;
import java.io.*;
public class test {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//创建EmpManage对象
        EmpManage em=new EmpManage();
        
        //作出一个简易菜单
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        while(true)
        {
        	System.out.println("请选择你要进行的操作");
        	System.out.println("1:表示添加一个雇员");
        	System.out.println("2:表示查找一个雇员");
        	System.out.println("3：修改一个雇员工资");
        	System.out.println("4：删除一个雇员");
        	System.out.println("5:退出");
        	String operType=br.readLine();
        	if(operType.equals("1"))
        	{
        		System.out.println("请输入编号");
        		String empNo=br.readLine();
        		System.out.println("请输入名字");
        		String name=br.readLine();
        		System.out.println("请输入工资");
        		float sal=Float.parseFloat(br.readLine());
        		Emp emp=new Emp(empNo,name,sal);
        		em.addEmp(emp);
        		
        	}else if(operType.equals("2"))
        	{  
        		System.out.println("请输入编号");
        		String empNo=br.readLine();
        		
        		em.showInfo(empNo);
        		
        	}else if(operType.equals("3"))
        	{
        		System.out.println("请输入编号");
        		String empNo=br.readLine();
        		System.out.println("请输入新工资");
        		float sal1=Float.parseFloat(br.readLine());
        		em.updateSal(empNo,sal1 );
        	}else if(operType.equals("4"))
        	{
        		System.out.println("请输入编号");
        		String empNo=br.readLine();
        		em.delEmp(empNo);
        		
        	}else if(operType.equals("5"))
        	{
        		System.exit(0);
        	}
        }
	}

}
//雇员管理类
class EmpManage
{   
	private ArrayList al=null;
	//构造
	public EmpManage()
	{
		al=new ArrayList();
	}
	//加入员工
	public void addEmp(Emp emp)
	{
		al.add(emp);
	}
	//显示员工的相关信息
	public void showInfo(String empNo)
	{
		//遍历整个ArrayList
		for(int i=0;i<al.size();i++)
		{
			//取出empNo
			Emp emp=(Emp)al.get(i);
			//比较编号
			if(emp.getEmpNo().equals(empNo))
			{
				System.out.println("找到该员工。他的信息是：");
				System.out.println("编号="+empNo);
				System.out.println("名字="+emp.getName());
				System.out.println("薪水="+emp.getSal());
			}
			
		}
		
		
	}
    //修改工资
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
    //删除某个员工
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
	//学号
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
	//构造函数
	public Emp(String empNo,String name,float sal)
	{
		this.empNo=empNo;
		this.name=name;
		this.sal=sal;
	}
	
}
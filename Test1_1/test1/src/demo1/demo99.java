package demo1;
public class demo99 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Persons p1=new Persons();
      p1.biao(9);
	}

}
class Persons
{
	public void biao(int lay)
	{    
		//����
		for(int i=1;i<=lay;i++)
		{
          //ÿ��Ҫ��ĸ���
			for(int j=1;j<=i;j++)
			{    int c=j*i;
				System.out.printf("%3d",j);
				System.out.print("*");
				System.out.printf("%3d",i );
				System.out.print("=");
				System.out.printf("%3d",c);
				System.out.print(" ");
			}
			    System.out.println();
			
			
		}
		
		
		
	}
}

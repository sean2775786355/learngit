package demo1;
//СтаЮ
public class demo12 {

	public static void main(String[] args) {
		int lay=5;
		for(int i=1;i<=lay-1;i++)
		{   
			for(int j=1;j<=lay-i;j++)
			  {
				System.out.print(" ");
			  }
			
			 for (int k=1;k<=2*i-1;k++)
		     {
				 
			  System.out.print("*");
			  
		     }
		      System.out.println();
		      
		}
		for(int l=1;l<=lay;l++)
		{   for(int j=1;j<=l-1;j++)
		
		    {
			System.out.print(" ");
		    }
			for(int k=1;k<=2*lay-(2*l-1);k++)
			{
			System.out.print("*");
			}
			System.out.println();
		} 
	}

}

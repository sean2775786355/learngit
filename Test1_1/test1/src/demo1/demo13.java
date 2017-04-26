package demo1;
//ÍÚ¿ÕµÄÁâĞÎ
public class demo13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stubint lay=5;
		int lay=9;
		for(int i=1;i<=lay-1;i++)
		{   
			for(int j=1;j<=lay-i;j++)
			  {
				System.out.print(" ");
			  }
			
			 for (int k=1;k<=2*i-1;k++)
		     {
				 
				if(i==1)
				{ 
				 System.out.print("*");
				}else
				{  
					if(k==1||k==2*i-1)
					{
					   System.out.print("*");	
					}else
					{
						System.out.print(" ");
					}
				 	
				}
		     }
		      System.out.println();
		      
		}
		for(int l=1;l<=lay;l++)
		{   for(int j=1;j<=l-1;j++)
		
		    {
			System.out.print(" ");
		    }
			for(int k=1;k<=2*lay-(2*l-1);k++)
			{   if(l==lay)
			    {
			    System.out.print("*");
			    }else
			    {
			    	if(k==1||k==2*lay-(2*l-1))
			    	{
			    		System.out.print("*");
			    	}else
			    	{
			    		System.out.print(" ");
			    	}
			    }
			}
			    System.out.println();
		} 

	}

}

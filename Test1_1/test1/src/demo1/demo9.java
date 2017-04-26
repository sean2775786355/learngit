/*
 * 功能：打金字塔
 */
package demo1;

public class demo9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lay=8;
		for(int i=1;i<=lay;i++)
		{  
			for(int k=1;k<=lay-i;k++)
			{
				System.out.print(" ");
			}
			for (int j=1;j<=i*2-1;j++)
			{
				if(i==1||i==lay)
				 {
			         System.out.print("*");
			     }else
			     {
			    	if(j==1||j==i*2-1)
			    	{
			    		System.out.print("*");
			    	}else{
			    		System.out.print(" ");
			    	}
			     }
			}
			System.out.println();
		}

	}

}

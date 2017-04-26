package demo1;
//µ¹½ğ×ÖËş
public class demo11 {

	public static void main(String[] args) {
		int lay=4;
		for(int i=1;i<=lay;i++)
		{   for(int j=1;j<=i-1;j++)
		
		    {
			System.out.print(" ");
		    }
			for(int k=1;k<=2*lay-(2*i-1);k++)
			{
			System.out.print("*");
			}
			System.out.println();
		}

	}

}

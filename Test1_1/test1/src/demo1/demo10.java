package demo1;
//´ò½ð×ÖËþ
public class demo10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lay=4;
		for(int i=1;i<=lay;i++)
		{    for(int k=1;k<=lay-i;k++)
		        {
			      System.out.print(" ");
		        }
			 for(int j=1;j<=i*2-1;j++)
			 {
		     System.out.print("*");
		     }	
			 System.out.println();
		}

	}

}

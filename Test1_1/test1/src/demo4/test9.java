package demo4;
//ถþฮฌสýื้
public class test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int arrs[][]=new int[10][10];
        arrs[1][2]=1;
        arrs[2][1]=2;
        for(int i=0;i<9;i++)
        {
        	for(int j=0;j<9;j++)
        	{
        		System.out.print(arrs[i][j]+" ");
        	} 
        	System.out.println();
        }
	}

}

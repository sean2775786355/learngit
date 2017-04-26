package demo6;

public class job3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //定义一个二维数组
		int stus[][]={{1002,78,23,56},{1003,23,89,34},{1007,78,89,90}};
		for(int i=0;i<4;i++)
		{
			for(int j=0;j<3;j++)
			{
				System.out.print(stus[j][i]+"       ");
			}
			System.out.println();
		}
	}

}

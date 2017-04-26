package demo2;

public class test6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
      Abc abc=new Abc();
      System.out.println(abc.getMax(7.0f, 8.0f, 95.4f));
      
	}

}
class Abc
{
	public int getMax(int i,int j)
	{
		if(i>j)
		{
			return i;
			
		}else{
			return j;
		}
	}
	public float getMax(float a,float b,float c)
	{  
		if(a>b)
		{
			if(a>c)
			{
				return a;
			}else{
				return c;
			}
				
		}else{
			if (b>c)
			{
				return b;
			}else{
				return c;
			}
		}
		
	}
}
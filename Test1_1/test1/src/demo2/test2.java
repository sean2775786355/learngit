package demo2;

public class test2 {
	static int i=1;
	static
	{
		i++;
	}
	public test2()
	{
		i++;
	}
    public static void main (String []args)
    {
    	test2 t1=new test2();
    	System.out.println(t1.i);
    	test2 t2=new test2();
    	System.out.println(t2.i);
    }
}

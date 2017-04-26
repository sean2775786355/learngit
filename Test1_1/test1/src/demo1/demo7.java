package demo1;

public class demo7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//根据用户输入。判断是星期几
		char c='g';
		switch(c)
		{
		    case 'a':
			    System.out.println("今天星期一");
			    break; 
		    case 'b':
		    	System.out.println("今天星期二");
		    	break;
		    case 'c':
		    	System.out.println("今天星期三");
		    	break;
		    case 'd':
		    	System.out.println("今天星期四");
		    	break;
		    case 'e':
		    	System.out.println("今天星期五");
		    	break;
		    case 'f':
		    	System.out.println("今天星期六");
		    	break;
		    case 'g':
		    	System.out.println("今天星期日");
		    	break;
		    default :
		    	System.out.println("不知道星期几");
			
		}

	}

}

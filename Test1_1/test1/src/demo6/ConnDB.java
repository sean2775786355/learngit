package demo6;
import java.sql.*;
public class ConnDB {

	public static void main(String[] args) throws Exception  {
		// TODO Auto-generated method stub
		
			
		         //����mysql����
                 Class.forName("com.mysql.jdbc.Driver");
				
				try {
					
		             
		              //�õ�����
		              Connection  ct=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/t2","root","067015"); 
		              //ʹ��Connection����Statement����
		              Statement sm=ct.createStatement();
		              ResultSet rs=sm.executeQuery("select * from user");
		              	         
		       }
		        catch (Exception ex) {
		        	ex.printStackTrace();
		       }
				
				
			 
	}

}

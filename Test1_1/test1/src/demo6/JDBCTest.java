package demo6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

public static void main(String[] args){

           // ����������
           String driver = "com.mysql.jdbc.Driver";

           // URLָ��Ҫ���ʵ����ݿ���scutcs
           String url = "jdbc:mysql://127.0.0.1:3306/scutcs";

           // MySQL����ʱ���û���
           String user = "root"; 

           // MySQL����ʱ������
           String password = "067015";

           try { 
            // ������������
            Class.forName(driver);

            // �������ݿ�
            Connection conn = DriverManager.getConnection(url, user, password);

            if(!conn.isClosed()) 
             System.out.println("Succeeded connecting to the Database!");

            // statement����ִ��SQL���
            Statement statement = conn.createStatement();

            // Ҫִ�е�SQL���
            String sql = "select * from student";

            // �����
            ResultSet rs = statement.executeQuery(sql);

            System.out.println("-----------------");
            System.out.println("ִ�н��������ʾ:");
            System.out.println("-----------------");
            System.out.println(" ѧ��" + "\t" + " ����");
            System.out.println("-----------------");

            String name = null;

            while(rs.next()) {
    
             // ѡ��sname��������
             name = rs.getString("sname");
    
             // ����ʹ��ISO-8859-1�ַ�����name����Ϊ�ֽ����в�������洢�µ��ֽ������С�
             // Ȼ��ʹ��GB2312�ַ�������ָ�����ֽ�����
             name = new String(name.getBytes("ISO-8859-1"),"GB2312");

             // ������
             System.out.println(rs.getString("sno") + "\t" + name);
            }

            rs.close();
            conn.close();

           }
           catch(Exception e) {


            e.printStackTrace();


           } 
} 
}

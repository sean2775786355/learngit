package com;

public class StringBufferTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //StringBuffer��������Ҫ����append(),insert()
		//����һ������ 
		StringBuffer sb=new StringBuffer();
        sb.append(false);
        sb.append(true);
        System.out.println("sb1="+sb);
        User u1=new User("aaa",12);
        sb.append(u1);
        System.out.println("sb2="+sb);
         sb.insert(0, "haha");
         System.out.println("sb3="+sb);
	}

}
class User
{
	String name;
	int age;
	//���췽��
	public User(String name,int age)
	{
		this.name=name;
		this.age=age;
	}
}
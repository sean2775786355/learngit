package com;
import java.lang.*;
public class StringTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
              
		String str="abcd";
		char data[]={'a','b','c','D'};
		String str1=new String(data);
		System.out.println(str);
		System.out.println(str1);
		String s1=str.substring(0,3);
		String s2=str.substring(2);
		System.out.println(s1);
		System.out.println(s2);
		char s3=str.charAt(0);
		System.out.println(s3);
		//找出字符串str在A的assci码
		int n1=str.codePointAt(0);
		System.out.println(n1);
		
		int n2=str.codePointCount(0, 3);
		System.out.println(n2);
		int n3=str.compareTo(str1);
		System.out.println(n3);
		int n4=str.compareToIgnoreCase(str1);
		System.out.println(n4);
		//将str3后面加入str1(字符串的相加)
		String str3=str.concat(str1);
		String str4=str+str1;
		//用加号的方式叠加
		System.out.println(str3);
		System.out.println(str4);
	    //查找字符串str中是否含有"ab"
		boolean b=str.contains("ab");
		System.out.println(b);
		//区分大小写比较字符串是否相等
		boolean b1=str.equals(str1);
		//忽略大小写比较字符串
		boolean b2=str.equalsIgnoreCase(str1);
		System.out.println("b1="+b1+"   b2"+b2);
//		测试此字符串是否以指定的后缀结束
		boolean b3=str.endsWith("d");
		System.out.println("b3="+b3);
		byte[] by=str.getBytes();
		System.out.println("byte[]="+by);
		int n5="h".hashCode();
		System.out.println("n5="+n5);
		int n6="shacskncsd".indexOf("k");
		System.out.println("n6="+n6);
		int n7="hsdvbskdbwpwnds".indexOf("d", 3);
		System.out.println("n7="+n7);
		boolean b4="a".isEmpty();
		//空字符串才为真（不是null）
		System.out.println("b4="+b4);
		
		int n8="abcdb".lastIndexOf("b");
		System.out.println("n8="+n8);
		int n9="abcdb".lastIndexOf("b",2);
		System.out.println("n9="+n9);
		//计算字符串长度
		int n10="sdddsaxadadadad".length();
		System.out.println("n10="+n10);
		//将字符串转换为大写
		String s4="hahhahahsdcdbfdv".toUpperCase();
		System.out.println("s4="+s4);
		//将字符串转化为小写
		String s5="AASFDSVDSSVSCSS".toLowerCase();
		System.out.println("s5="+s5);
		String s6=String.valueOf(false);
		System.out.println("s6="+s6);
		//将float转化为String
		String s7=String.valueOf(12.0f);
		System.out.println(s7);
	
	}

}

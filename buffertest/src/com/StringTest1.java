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
		//�ҳ��ַ���str��A��assci��
		int n1=str.codePointAt(0);
		System.out.println(n1);
		
		int n2=str.codePointCount(0, 3);
		System.out.println(n2);
		int n3=str.compareTo(str1);
		System.out.println(n3);
		int n4=str.compareToIgnoreCase(str1);
		System.out.println(n4);
		//��str3�������str1(�ַ��������)
		String str3=str.concat(str1);
		String str4=str+str1;
		//�üӺŵķ�ʽ����
		System.out.println(str3);
		System.out.println(str4);
	    //�����ַ���str���Ƿ���"ab"
		boolean b=str.contains("ab");
		System.out.println(b);
		//���ִ�Сд�Ƚ��ַ����Ƿ����
		boolean b1=str.equals(str1);
		//���Դ�Сд�Ƚ��ַ���
		boolean b2=str.equalsIgnoreCase(str1);
		System.out.println("b1="+b1+"   b2"+b2);
//		���Դ��ַ����Ƿ���ָ���ĺ�׺����
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
		//���ַ�����Ϊ�棨����null��
		System.out.println("b4="+b4);
		
		int n8="abcdb".lastIndexOf("b");
		System.out.println("n8="+n8);
		int n9="abcdb".lastIndexOf("b",2);
		System.out.println("n9="+n9);
		//�����ַ�������
		int n10="sdddsaxadadadad".length();
		System.out.println("n10="+n10);
		//���ַ���ת��Ϊ��д
		String s4="hahhahahsdcdbfdv".toUpperCase();
		System.out.println("s4="+s4);
		//���ַ���ת��ΪСд
		String s5="AASFDSVDSSVSCSS".toLowerCase();
		System.out.println("s5="+s5);
		String s6=String.valueOf(false);
		System.out.println("s6="+s6);
		//��floatת��ΪString
		String s7=String.valueOf(12.0f);
		System.out.println(s7);
	
	}

}

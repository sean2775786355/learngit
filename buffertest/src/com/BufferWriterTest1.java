package com;
import java.io.*;
public class BufferWriterTest1 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
          BufferedWriter bw=new BufferedWriter(new FileWriter("fool.out"));
	       
	      bw.write("haha");
	}

}

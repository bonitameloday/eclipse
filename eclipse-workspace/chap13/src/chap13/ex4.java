package chap13;

import java.io.*;

public class ex4 {
	public static void main(String[] args) throws IOException {
	byte[] byteData = new byte[15];
	int readByteNo = System.in.read(byteData);
	
	String strData = new String(byteData, 0, readByteNo-2);
	System.out.println(strData);
	}
}
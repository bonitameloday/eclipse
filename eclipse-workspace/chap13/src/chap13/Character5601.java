package chap13;

import java.io.*;

public class Character5601 {
	public static void main(String[] args) throws IOException {
		String text ="Coding is not hard.";
		FileOutputStream fos = new FileOutputStream("인코딩예제.txt");
		OutputStreamWriter osw = new OutputStreamWriter(fos, "KSC5601");
		osw.write(text, 0, text.length());
		osw.flush();
		osw.close();
		
		FileInputStream fis = new FileInputStream("인코딩예제.txt");
		InputStreamReader isr = new InputStreamReader(fis, "KSC5601");
		
		char [] buffer = new char[128];
		int bytesRead;
		while((bytesRead = isr.read(buffer ,0, buffer.length))!=-1);
			System.out.println(buffer);
			
		isr.close();
		fis.close();
	}
}

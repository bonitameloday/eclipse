package client;

import java.io.*;
import java.net.*;
import java.util.*;

public class ClientEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		
		try {
			socket = new Socket("128.12.1.1", 9999);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				String inputMessage = in.readLine();
				System.out.println("서버: " + inputMessage);
				
				String outputMessage = scanner.nextLine();
				System.out.println("보내기 >> ");
				if(outputMessage.equalsIgnoreCase("bye")) {
					System.out.println("outputMessage + '\n'");
					break;
				}
				out.write(outputMessage + '\n');
				out.flush();
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
		finally {
			 try {
				 scanner.close();
				 socket.close();
				 socket.close();
				 }
			 catch(IOException e) {
				 System.out.println("서버와 채팅 중 오류가 발생했습니다.");
			 }
		
		 }
	 }
}

package client;

import java.io.*;
import java.net.*;
import java.util.*;

public class CalcCilentEx {
	public static void main(String[] args) {
		BufferedReader in = null;
		BufferedWriter out = null;
		Socket socket = null;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket("localhost", 9999);
			
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			
			while(true) {
				System.out.println("계산식 입력(빈칸으로 띄어 입력) >> ");
				String outputMsg = scanner.nextLine();
				if(outputMsg.equalsIgnoreCase("bye")) {
					out.write(outputMsg + "\n");
					out.flush();
					break;
				}
				out.write(outputMsg + "\n");
				out.flush();
				String inputMsg = in.readLine();
				System.out.println("계산 결과 : " + inputMsg);
			}
		} catch (IOException e) {
			System.out.println(e.getMessage());
			} finally {
				try {
				scanner.close();
				if(socket != null) socket.close();
					} catch(IOException e){
					System.out.println("서버와 채팅 중 오류가 발생했습니다.");
						}
				}
	}
}


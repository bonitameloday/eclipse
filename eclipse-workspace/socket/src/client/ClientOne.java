package client;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ClientOne {
	private Socket socket;
	private DataInputStream dis;
	private DataOutputStream dos;
	public ClientOne() {
		connect();
		sendMsg();
		recvMsg();
		closeAll();
	}
	public void connect() {
		// 연결
		try {
			socket = new Socket("127.0.0.1", 1234);
			System.out.println("Client: Connection O.K!");
			// 데이터 전송
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			
		}  catch (IOException e) {e.printStackTrace();}
	}
	public void sendMsg() {
		new Thread(new Runnable() {
			boolean isStay = true;
			public void run() {
				Scanner in = new Scanner(System.in);
				System.out.println("클라이언트 보내기 >> ");
				while(isStay) 	{
					try {
						String sendMsg = in.nextLine();
						if(sendMsg.equals("bye")) 
							isStay = false;
						dos.writeUTF(sendMsg);
					} catch (IOException e) {e.printStackTrace();}
				}
			}
		}).start();
	}
				
	public void recvMsg() {
		new Thread(new Runnable() {
			boolean isRecv = true;
			public void run() {
				while(isRecv) {
					try {
						String recvMsg = dis.readUTF(); // 클라이언트로부터 UTF로 데이터를 수신한다. 수신한 메시지를 recvMsg에 저장하고 화면에 출력한다.
						if(recvMsg.equals("bye"))
							isRecv = false;
						System.out.println("From server: " + recvMsg);
					} catch (IOException e) {e.printStackTrace();}	
				}
			}
		}).start();
	}
	public void closeAll() {
		try {
			socket.close();
			dis.close();
			dos.close();
		} catch (IOException e) {e.printStackTrace();}
		System.out.println("Bye!");
	}
	public static void main(String[] args) {
		new ClientOne();
	}
}
package server;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class ServerOne{
	volatile boolean isStay = true; // 스레드 사이에 변수의 안정성을 보장하기 위해 volatile 선언 - 메모리의 가시성(한 스레드에서 volatile변수를 수정하면 변경이 바로 다른 스레드에게 실시간으로 보임,순서보장
	volatile boolean isRecv = true;
	private ServerSocket socket;
	private Socket clientSocket;
	private DataOutputStream dos;
	private DataInputStream dis;
	
	public ServerOne() {
		connect();
		sendMsg();
		recvMsg();
		closeAll();
		System.out.println("Bye!!");
	}
	public void connect() {
		//연결
		ServerSocket socket;
		try {
			socket = new ServerSocket(4444);
			Socket clientSocket = socket.accept(); // 클라이언트로부터 접속 요청을 기다린다.
			System.out.println("server: connection O.K!");
			// 데이터 받기
			dos = new DataOutputStream(clientSocket.getOutputStream());
			dis = new DataInputStream(clientSocket.getInputStream());
		} catch (IOException e) {e.printStackTrace();}	
	}
	
	public void sendMsg() {
		new Thread(new Runnable() {
			boolean isStay = true;
			public void run() {
				//키보드로 입력받기
				Scanner in = new Scanner(System.in); 
				System.out.println("서버 보내기 >> ");
				while(isStay) {
					try {
						String sendMsg = in.nextLine();
						if(sendMsg.equals("bye")) 
							isStay = false;
						dos.writeUTF(sendMsg);
					} catch(IOException e) {
					}
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
						System.out.println("From client: " + recvMsg);
					} catch(IOException e) {	}
				}
				checkThreadsStatus();
			}
	
		}).start();
	}
	protected void checkThreadsStatus() {
		if(!isStay && !isRecv) {
			closeAll();
		}
	}
	public void closeAll() {
		try {
			socket.close();
			clientSocket.close();
			dis.close();
			dos.close();
			
		} catch (IOException e) {e.printStackTrace();}
	}
	public static void main(String[] args) {
		new ServerOne();
	}
}
package byteINethost;

import java.net.*;

public class GetLocalIPAddress {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			byte[] address = local.getAddress();
			System.out.println("사용 중인 호스트의 IP 주소는");
			for(int i = 0; i < address.length; i++) {
				//삼항 연산자 조건- > 변수 = 조건문 ? 참일때 실행할 문장 : 거짓일때 실행할 문장; - > 음수일때 256을 더해준다.(음수일 때 어떻게 처리하는지 보여주기 위함)
				int unsigned = address[i] < 0 ? address[i]+256:address[i]; 
				System.out.print(unsigned + ".");
			}
			System.out.println();
		} catch (UnknownHostException e) {
			System.out.println("로컬 호스트의 IP 주소를 알 수 없습니다.");
		}
	}
}

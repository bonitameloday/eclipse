import java.net.*;
import java.util.*;

public class GetLocalPAddress {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			byte[] address = local.getAddress();
			System.out.println("사용 중인 호스트의 IP 주소는");
			for (int i = 0; i < address.length; i++) {
				int unsidned = address[i]<0? address[i]+256:address[i];
				System.out.print(unsidned+".");	
			}
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("로컬 호스트의 IP 주솔르 알 수 없습니다.");
		}
	}
}
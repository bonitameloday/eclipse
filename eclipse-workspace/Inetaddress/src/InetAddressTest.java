import java.net.*;

public class InetAddressTest {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress Address = InetAddress.getLocalHost();
		System.out.println("로컬 컴퓨터의 이름 : " + Address.getHostName());
		System.out.println("로컬 컴퓨터의 IP 주소 : " + Address.getHostAddress());
		Address = InetAddress.getByName("www.halla.ac.kr");
		System.out.println("www.halla.ac.kr 컴퓨터의 이름과 IP 주소 : " + Address);
		
		InetAddress all[] = InetAddress.getAllByName("www.naver.com");
		for(int i = 0; i < all.length; i++)
			System.out.println(all[i]);
	}
}
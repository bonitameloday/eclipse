import java.awt.*;
import java.awt.event.*;
import java.net.*;

public class GetHostInfor extends Frame implements ActionListener{
	TextField hostname; // 호스트 이름을 입력받는 필드
	Button getinfor; // 입력된 호스트에 관한 IP 정보를 읽는 버튼
	TextArea display; // 구해진 IP에 관한 정보를 출력하는 필드

	public static void main(String args[]) {
	GetHostInfor host = new GetHostInfor("InetAddress 클래스");
	host.setVisible(true);
	}

	public GetHostInfor(String str) {
	super(str);
	addWindowListener(new WinListener());
	setLayout(new BorderLayout());
	Panel inputpanel = new Panel(); // 첫 번째 패널
	inputpanel.setLayout(new BorderLayout());
	
	inputpanel.add("North", new Label("Host Name: "));
	hostname = new TextField("", 30);
	getinfor = new Button("Host Info");
	inputpanel.add("Center", hostname);
	inputpanel.add("South", getinfor);
	getinfor.addActionListener(this); // 이벤트 등록
	add("North", inputpanel); // 패널을 프레임에 부착
	Panel outputpanel = new Panel(); // 두 번째 패널
	outputpanel.setLayout(new BorderLayout());
	display = new TextArea("", 24, 40);
	display.setEditable(false);
	outputpanel.add("North", new Label("Inet Address"));
	outputpanel.add("Center", display);
	add("Center", outputpanel);
	setSize(270, 200);
	}

	public void actionPerformed(ActionEvent e) {
		String name = hostname.getText(); // 입력된 호스트 이름을 구한다.
		try {
		InetAddress inet = InetAddress.getByName(name); // InetAddress 객체생성
		String ip = inet.getHostName() + "\n"; // 호스트의 이름을 구한다.
		display.append(ip);
		ip = inet.getHostAddress() + "\n"; // 호스트의 IP 주소를 구한다.
		display.append(ip);
		} catch (UnknownHostException ue) {
		String ip = name + ": 해당 호스트가 없습니다.\n";
		display.append(ip);
		}
		}
		class WinListener extends WindowAdapter {
		public void windowClosing(WindowEvent we) {   System.exit(0);   }
		}
}

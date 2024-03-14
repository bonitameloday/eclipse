import java.io.DataInputStream;
import java.io.FileInputStream;

public class ReadNumberData {
	static FileInputStream fin;
	static DataInputStream dis;
	public static void main(String[] args) {
		boolean bdata;
		double ddata;
		int number;
		try {
			fin = new FileInputStream("numberdata.txt");
			dis = new DataInputStream(fin);
			bdata = dis.readBoolean();
			System.out.println(bdata);
			ddata = dis.readDouble();
			System.out.println(ddata);
			while(true) {
				number = dis.readInt();
				System.out.println(number+" ");
			}
	}
		catch(Exception e){System.err.println("프로그램이 종료되었습니다.");}
	}
}


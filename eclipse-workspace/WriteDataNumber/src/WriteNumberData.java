import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteNumberData {
	static FileOutputStream fout;
	static DataOutputStream dos;
	
	public static void main(String[] args) {
		try {
			fout = new FileOutputStream("c:\\tmp\\numberdata.txt");
			dos = new DataOutputStream(fout);
			dos.writeBoolean(true);
			dos.writeDouble(989.27);
			for (int i = 1; i <= 500; i++) {
				dos.writeInt(i);
			}
		} catch (Exception e) {
			System.err.println(e);
		}
		if(dos != null)
			try {
				dos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
}

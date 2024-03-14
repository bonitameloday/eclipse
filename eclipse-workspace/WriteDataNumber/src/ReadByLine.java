import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadByLine {
	public static void main(String[] args) {
		String data;
		if(args.length != 1)
			System.err.println("입력 파일을 지정하십시오.");
		try {
			FileReader infile = new FileReader(args[0]);
			BufferedReader br = new BufferedReader(infile);
			while((data = br.readLine()) != null) {
				System.out.println(data);
			}
		} catch (IOException e) {
			System.err.println(e);
		}
	}
}

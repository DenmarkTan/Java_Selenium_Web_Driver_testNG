package bufferedreaderexample;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.StringReader;

public class BufferedReaderExample {
	public static void main(String[] args) {
		File myFile = new File("C:\\Users\\132577\\eclipse-workspace\\BufferedReaderExample\\example.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(myFile));
			//BufferedReader reader = new BufferedReader(new StringReader("Ellow"));
			String line;
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e){
			e.printStackTrace();
		}
	}
}

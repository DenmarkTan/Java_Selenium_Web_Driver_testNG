package pathclassexample;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathClassExample {
	public static void main(String[] args) {
		Path path = Paths.get("example2.txt");
		try {
			Files.deleteIfExists(path);
		} catch (IOException ex) {
			
		}
		Path path2 = Paths.get("C:\\Users\\132577\\eclipse-workspace\\PathClassExample\\example.txt");
		System.out.println(path2.getParent());
		System.out.println(path2.getRoot());
		System.out.println(path2.getFileName());
	}
}

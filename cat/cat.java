import java.io.BufferedReader;
import java.io.FileReader;
//import java.nio.file.Path;
//import java.nio.file.Paths;
import java.io.IOException;
import java.io.EOFException;

public class cat {
	public static void main(String[] args) {
		for (String arg : args) {
			try (BufferedReader br = new BufferedReader(new FileReader(arg))) {
				String line;
				while ((line = br.readLine()) != null) {
					System.out.println(line);
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

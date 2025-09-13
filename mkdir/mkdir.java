import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class mkdir {
	public static void main(String[] args) {
		if (args.length == 0) {
			System.err.println("No arguments provided.");
			System.exit(1);
		}
		for (String dirName : args) {
			try {
				Files.createDirectories(
						Paths.get(dirName)
						);
				System.out.println("Success!");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

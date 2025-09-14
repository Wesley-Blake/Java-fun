import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class grep {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.err.println("To little or to many arguments.");
			System.exit(1);
		}

		Path path = Paths.get(args[1]);
		System.out.println("file: " + path.getFileName());
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.contains(args[0])) {
					System.out.println(line);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

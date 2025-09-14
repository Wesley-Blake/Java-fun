import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class tail {
	public static void main(String[] args) {
		if (args.length != 1) {
			System.err.println("To many args.");
			System.exit(1);
		}

		Path path = Paths.get(args[0]);
		if (Files.notExists(path)) {
			System.err.println(
					"File: " +
					path +
					"doesn't exist.");
			System.exit(1);
		}

		ArrayList<String> readLines = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(path)) {
			String line;
			while((line = reader.readLine()) != null) {
				readLines.add(line);
			}
			if (!readLines.isEmpty()) {
				for (int i = readLines.size() - 10; i < readLines.size(); i++) {
					System.out.println(readLines.get(i));
				}
			} else {
				System.out.println("Fuck");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

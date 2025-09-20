import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.Set;
import java.util.HashSet;

public class spellChecker {
	public static void main(String[] args) {
		// Check for args length, min 1.
		System.out.println(args.length);
		if (args.length < 1) {
			System.err.println("At least 1 argument please.");
			System.exit(1);
		}

		// Check if words file exists.
		Path wordsFile = Paths.get("/usr/share/dict/words");
		if (!Files.exists(wordsFile)) {
			System.err.println(wordsFile + " file doesn't exist!");
			System.exit(1);
		}
		// Check if words file is readable.
		if (!Files.isReadable(wordsFile)) {
			System.err.println(wordsFile + " isn't readable!");
			System.exit(1);
		}

		// The actual work starts here.
		Set<String> words = new HashSet<>();
		try (Stream<String> lines = Files.lines(wordsFile)) {
			lines.forEach(line -> {
				// NOTE: remove punctuation caracters, and lower.
				words.add(line);
			});
			// Checking the args against the list.
			for (String item : args) {
				// NOTE: Make item lower.
				if (!words.contains(item)) {
					System.out.println(item);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

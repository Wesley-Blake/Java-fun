import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class ls {
	public static void main (String[] args) {
		if (args.length == 0) {
			args = new String[]{Paths.get("").toAbsolutePath().toString()};
		}
		for (String arg : args) {
			Path path = Paths.get(arg);
			System.out.println(path.getFileName() + ":");
			if (Files.exists(path) && Files.isDirectory(path)) {
				try(DirectoryStream<Path> stream = Files.newDirectoryStream(path)) {
					for (Path entry : stream) {
						System.out.println(entry.getFileName());
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (args.length > 1) { System.out.println(); }
		}
	}
}

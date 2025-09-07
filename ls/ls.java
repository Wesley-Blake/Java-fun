import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class ls {
	public static void main (String[] args) {
		if (args.length == 0) {
			String[] newArgs = new String[args.length +1];
			System.arraycopy(args, 0, newArgs, 0, args.length);
			newArgs[args.length] = ".";
		}

		for (String arg : args) {
			Path path = Paths.get(arg);
			System.out.println(path + ":");
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

package ls;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.file.Files;

class utils {
    static String humanReadableBytes(long bytes) {
        int unit = 1024;

        if (bytes < unit) {
            return bytes + " B";
        }

        int exp = (int) (Math.log(bytes) / Math.log(unit));
        char pre = "kMGTPE".charAt(exp - 1);

        return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre);
    }

    static void writeToFile(String fileUri, String content) throws IOException {

        Path path = Paths.get(fileUri);

        Files.write(path, content.getBytes());
    }
}

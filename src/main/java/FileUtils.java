import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileUtils {

    private FileUtils() {
        // hide public constructor
    }

    public static void zip(String name, String path) throws ZipException {
        ZipFile zipFile = new ZipFile(name);
        zipFile.addFolder(new File(path));
    }

    public static void deleteFilesToPathWithoutDirectory(String pathToFile) throws IOException {
        Files.walk(Path.of(pathToFile))
                .map(Path::toFile)
                .forEach(File::delete);
    }

    public static void deleteDirectoryWithFiles(String pathToFile) throws IOException {
        if (Files.exists(Path.of(pathToFile))) {
            Files.walk(Path.of(pathToFile))
                    .map(Path::toFile)
                    .forEach(File::delete);
            deleteDirectoryWithFiles(pathToFile);
        }
    }

    public static void checkFilesToEquals(String pathToFile1, String pathToFile2) throws IOException {
        Files.isSameFile(Path.of(pathToFile1), Path.of(pathToFile2));
    }
}

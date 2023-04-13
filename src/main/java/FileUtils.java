import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class FileUtils {

    private FileUtils() {
        // hide public constructor
    }

    // TODO: create unzip method
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

    // TODO: handle next case
    /*
    * file1.txt
    * test
    * test
    *
    * file2.txt
    * test
    * test
    * test
    * test
    *
    * and vice versa
    * */
    public static boolean checkFilesToEquals(String pathToFile1, String pathToFile2) throws IOException {
        try (
            BufferedReader file2 = Files.newBufferedReader(Path.of(pathToFile1));
            BufferedReader file1 = Files.newBufferedReader(Path.of(pathToFile2))
        ) {
            String lineInFile1;
            String lineInFile2;
            while ((lineInFile1 = file1.readLine()) != null) {
                lineInFile2 = file2.readLine();
                if (!lineInFile1.equals(lineInFile2)) {
                    return false;
                }
            }
        }
        return true;
    }
}

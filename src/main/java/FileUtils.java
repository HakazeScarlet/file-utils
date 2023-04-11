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

    public static long checkFilesToEquals(String pathToFile1, String pathToFile2) throws IOException {
        try (BufferedReader checkedFile1 = Files.newBufferedReader(Path.of(pathToFile1));
             BufferedReader checkedFile2 = Files.newBufferedReader(Path.of(pathToFile2))) {

            long lineNumber = 1;
            String lineInFile1 = "", lineInFile2 = "";
            while ((lineInFile1 = checkedFile1.readLine()) != null) {
                lineInFile2 = checkedFile2.readLine();
                if (lineInFile1.equals(lineInFile2)) {
                    lineNumber++;
                    System.out.println("Lines are equals");
                } else {
                    System.out.println("Lines are not equals");
                }
            }
            if (checkedFile2.readLine() == null) {
                return -1;
            } else {
                return lineNumber;
            }
        }
    }
}

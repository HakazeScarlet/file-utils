import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.File;

public final class FileUtils {

    private FileUtils() {
        // hide public constructor
    }

    public static void zip(String name, String path) throws ZipException {
        ZipFile zipFile = new ZipFile(name);
        zipFile.addFolder(new File(path));
    }
}

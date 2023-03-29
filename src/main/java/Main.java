import java.io.IOException;

public class Main {

    private static final String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {
        FileUtils.deleteDirectoryWithFiles(HOME + "\\Desktop\\test\\img");
    }
}

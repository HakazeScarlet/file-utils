import java.io.IOException;

public class Main {

    private static final String HOME = System.getProperty("user.home");

//    public static void main(String[] args) throws ZipException {
//        FileUtils.zip("img-lib.zip", HOME + "\\Desktop\\img");
//    }

    public static void main(String[] args) throws IOException {
        FileUtils.deleteFileToPath(HOME + "\\Desktop\\img", "1 (1).jpg");
    }
}

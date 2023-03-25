import net.lingala.zip4j.exception.ZipException;

public class Main {

    private static final String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws ZipException {
        FileUtils.zip("img-lib.zip", HOME + "\\Desktop\\img");
    }
}

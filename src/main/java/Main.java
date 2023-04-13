import java.io.IOException;

public class Main {

    private static final String HOME = System.getProperty("user.home");

    public static void main(String[] args) throws IOException {
        System.out.println(FileUtils.checkFilesToEquals(HOME + "\\Desktop\\test\\test.txt", HOME + "\\Desktop\\test\\test1.txt"));;
    }
}

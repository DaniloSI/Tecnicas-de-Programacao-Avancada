import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by danilo on 18/04/17.
 */
public class TextFileLoader {
    private String words;
    private BufferedReader bufferedReader;

    public TextFileLoader(File file) throws IOException {
        bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file), Charset.forName("UTF-8")));
    }

    public String nextLine() throws IOException {
        return bufferedReader.readLine();
    }

    public void finish() throws IOException {
        bufferedReader.close();
    }
}

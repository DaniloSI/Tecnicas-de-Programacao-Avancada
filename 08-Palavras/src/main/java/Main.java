import java.io.File;
import java.io.IOException;

/**
 * Created by danilo on 18/04/17.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        File file = new File(Main.class.getClassLoader().getResource("corpus.txt").getFile());
        TextAnalyzer textAnalyzer = new TextAnalyzer(new TextFileLoader(file));

        System.out.println("Frequência para Polícia: " + textAnalyzer.getFrequencyWord("polícia"));
    }
}

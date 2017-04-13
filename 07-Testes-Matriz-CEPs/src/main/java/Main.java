import java.io.File;
import java.io.IOException;

/**
 * Created by danilo on 12/04/17.
 */
public class Main {

    private static final ClassLoader classLoader = Main.class.getClassLoader();

    public static void main(String[] args) throws IOException {
        File fileCEP = new File(classLoader.getResource("vix-ruas-ceps.txt").getFile());
        CEPRepositorio cepRepositorio = new CEPRepositorio(fileCEP);

        System.out.println(cepRepositorio.getCEP("29047-033").getRua());
    }
}

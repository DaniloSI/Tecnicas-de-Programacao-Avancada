package hashTableCep;



import hashTableCep.cep.CEPRepositorio;

import java.io.File;
import java.io.IOException;

/**
 * Created by danilo on 12/04/17.
 */
public class HashTableCepMain {

    private static final ClassLoader classLoader = HashTableCepMain.class.getClassLoader();

    public static void main(String[] args) throws IOException {
        String projectPath = new File("").getAbsolutePath() + File.separator;
        String fullPath = projectPath + "src" + File.separator + "hashTableCep" + File.separator+ "cep" + File.separator;
        File fileCEP = new File(fullPath + "vix-ruas-ceps.txt");
        CEPRepositorio cepRepositorio = new CEPRepositorio(fileCEP);

        System.out.println(cepRepositorio.getCEP("29030-021").getRua());
    }
}

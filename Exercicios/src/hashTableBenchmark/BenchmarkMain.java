package hashTableBenchmark;

import java.io.*;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class BenchmarkMain {

    private static final String fileAgenda = "agenda.csv";
    private static final String fileOutput = "agenda-colisoes.csv";

    public static void main(String[] args) throws IOException {
        String projectPath = new File("").getAbsolutePath() + File.separator;
        String classPath = "src" + File.separator + "hashTable" + File.separator + "hashTableBenchmark" + File.separator;
        String fullPath = projectPath + classPath;

        AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
        File fileToRead = new File(fullPath + fileAgenda);
        FileReader fileReader = new FileReader(fileToRead);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] contato = line.split(",");
            String contatoKey = contato[1].substring(6);
            String contatoName = contato[0];

            agendaTelefonica.addNovoContato(Integer.parseInt(contatoKey), contatoName);
        }

        agendaTelefonica.addNovoContato(123, "Teste");

        bufferedReader.close();

        agendaTelefonica.salvaColisoes(fullPath + fileOutput);

    }
}

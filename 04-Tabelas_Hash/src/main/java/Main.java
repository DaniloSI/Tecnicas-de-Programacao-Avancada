import java.io.*;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
        File fileToRead = new File(Main.class.getClassLoader().getResource("agenda.csv").getFile());
        File fileToWrite = new File("csvArmazenamentoNaoPolinomial.csv");
        FileReader fileReader = new FileReader(fileToRead);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileToWrite);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] contato = line.split(",");
            agendaTelefonica.addNovoContato(Integer.parseInt(contato[1].substring(6)), contato[0]);
        }

        bufferedReader.close();

        fileWriter.write(agendaTelefonica.getCsv());
        fileWriter.close();

    }
}

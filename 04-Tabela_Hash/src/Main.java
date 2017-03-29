import dicionario.Dicionario;
import dicionario.DicionarioEnderecamentoAberto;

import java.io.*;

/**
 * Created by Danilo de Oliveira on 22/03/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        AgendaTelefonica agendaTelefonica = new AgendaTelefonica();
        File fileToRead = new File("src/resources" + File.separatorChar + "agenda.csv");
        File fileToWrite = new File("src/resources/csvArmazenamentoNaoPolinomial.csv");
        FileReader fileReader = new FileReader(fileToRead);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        FileWriter fileWriter = new FileWriter(fileToWrite);
        /*BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);*/


        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] contato = line.split(",");
            agendaTelefonica.addNovoContato(Integer.parseInt(contato[1].substring(6)), contato[0]);
        }

        bufferedReader.close();

        fileWriter.write(agendaTelefonica.getCsv());
        fileWriter.close();



        /*Dicionario<String, Integer> dicionario = new Dicionario<>();

        dicionario.insert("Danilo", 50);
        dicionario.insert("de", 75);
        dicionario.insert("Oliveira", 90);

        System.out.println(dicionario.keys());
        System.out.println(dicionario.values());

        dicionario.insert("Danilo", 296);

        System.out.println(dicionario.keys());
        System.out.println(dicionario.values());

        System.out.println(dicionario.find("Danilo"));

        dicionario.remove("Danilo");

        System.out.println(dicionario.keys());
        System.out.println(dicionario.values());

        System.out.println(dicionario.getGraficoArmazenamento());*/

        /*System.out.println(dicionario.find("Danilo"));

        dicionario.remove("Danilo");

        System.out.println(dicionario.size());

        System.out.println(dicionario.isEmpty());

        dicionario.remove("Oliveira");

        System.out.println(dicionario.isEmpty());*/


    }
}

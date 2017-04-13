import hashTable.HashTable;
import hashTable.ItemTabelaHash;
import hashTable.TabelaHashEA;

import java.io.*;

/**
 * Created by danilo on 12/04/17.
 */
public class CEPRepositorio {

    private HashTable ceps;

    public CEPRepositorio(File fileCEP) throws IOException {
        ceps = new TabelaHashEA();
        FileReader fileReader = new FileReader(fileCEP);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line;

        while ((line = bufferedReader.readLine()) != null) {
            String[] fields = line.split(";");
            CEP newCEP = new CEP();

            newCEP.setCep(fields[0].replaceAll("\\s+", ""));
            newCEP.setRua(fields[1].replaceAll("(\\s+$)|(^\\s+)", ""));
            newCEP.setBairro(fields[2].replaceAll("(\\s+$)|(^\\s+)", ""));
            newCEP.setMunicipio(fields[3].split(",")[0].replaceAll("(\\s+$)|(^\\s+)", ""));
            newCEP.setEstado(fields[3].split(",")[1].replaceAll("(\\s+$)|(^\\s+)", ""));

            ceps.insert(new ItemTabelaHash<>(newCEP.getCep(), newCEP));
        }
    }

    public CEP getCEP(String cep) {
        ItemTabelaHash itemCEP = ceps.find(cep);
        return (itemCEP != HashTable.NO_SUCH_KEY) ? (CEP) itemCEP.getValue() : null;
    }

}

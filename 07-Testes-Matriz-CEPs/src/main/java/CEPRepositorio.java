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
            String regexRemoveWhiteSpaces = "(\\s+$)|(^\\s+)";

            newCEP.setCep(fields[0].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setRua(fields[1].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setBairro(fields[2].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setMunicipio(fields[3].split(",")[0].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setEstado(fields[3].split(",")[1].replaceAll(regexRemoveWhiteSpaces, ""));

            ceps.insert(new ItemTabelaHash<>(newCEP.getCep(), newCEP));
        }
    }

    public CEP getCEP(String cep) {
        ItemTabelaHash itemCEP = ceps.find(cep);
        return (itemCEP != HashTable.NO_SUCH_KEY) ? (CEP) itemCEP.getValue() : null;
    }

}

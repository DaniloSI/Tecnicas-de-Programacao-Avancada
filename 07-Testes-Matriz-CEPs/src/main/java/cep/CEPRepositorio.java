package cep;

import hashTable.HashTable;
import hashTable.ItemTabelaHash;
import hashTable.TabelaHashEA;

import java.io.*;

/**
 * Created by danilo on 12/04/17.
 */
public class CEPRepositorio {

    private HashTable ceps;

    public CEPRepositorio(File fileCEPs) throws IOException {
        ceps = new TabelaHashEA();
        readCEPs(fileCEPs);
    }

    private void readCEPs(File fileCEPs) throws IOException {
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;

        fileReader = new FileReader(fileCEPs);
        bufferedReader = new BufferedReader(fileReader);

        while ((line = bufferedReader.readLine()) != null) {
            String[] fields = line.split(";");
            CEP newCEP = new CEP();
            String regexRemoveWhiteSpaces = "(\\s+$)|(^\\s+)";

            newCEP.setCep(fields[0].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setRua(fields[1].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setBairro(fields[2].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setMunicipio(fields[3].split(",")[0].replaceAll(regexRemoveWhiteSpaces, ""));
            newCEP.setEstado(fields[3].split(",")[1].replaceAll(regexRemoveWhiteSpaces, ""));

            this.ceps.insert(new ItemTabelaHash<>(newCEP.getCep(), newCEP));
        }

        bufferedReader.close();
    }

    public CEP getCEP(String cep) {
        ItemTabelaHash itemCEP = ceps.find(cep);
        return (itemCEP != HashTable.NO_SUCH_KEY) ? (CEP) itemCEP.getValue() : null;
    }

}

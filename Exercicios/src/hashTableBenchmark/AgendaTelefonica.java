package hashTableBenchmark;



import hashTableDicionario.Dicionario;
import hashTableDicionario.DicionarioBuilder;
import hashTable.HashEngineDefault;

import java.io.IOException;

/**
 * Created by danilo on 28/03/17.
 */
public class AgendaTelefonica {
    private Dicionario agendaDicionario;

    public AgendaTelefonica() {
        this.agendaDicionario = new DicionarioBuilder<String, String>()
                .setHashEngine(new HashEngineDefault())
                .setTipoTabelaHash(DicionarioBuilder.TipoTabelaHash.LINEAR_PROBING)
                .get();
    }

    public void addNovoContato(Integer numero, String nome) {
        agendaDicionario.insert(numero.toString(), nome);
    }

    public void removerContato(Integer numero) {
        agendaDicionario.remove(numero.toString());
    }

    public void salvaColisoes(String fileName) throws IOException {

        for (Object key: agendaDicionario.keys()) {
            System.out.println(key);
        }

        agendaDicionario.salvaColisoesKeys(fileName);
    }

}

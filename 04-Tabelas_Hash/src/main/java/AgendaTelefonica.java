import dicionario.Dicionario;
import dicionario.DicionarioBuilder;
import hashTable.TipoFuncaoHash;

/**
 * Created by danilo on 28/03/17.
 */
public class AgendaTelefonica {
    private Dicionario agendaDicionario;

    public AgendaTelefonica() {
        this.agendaDicionario = new DicionarioBuilder<String, String>()
                .setTipoFuncaoHash(TipoFuncaoHash.POLINOMIAL)
                .setTipoTabelaHash(DicionarioBuilder.TipoTabelaHash.LINEAR_PROBING)
                .get();
    }

    public void addNovoContato(Integer numero, String nome) {
        agendaDicionario.insert(numero.toString(), nome);
    }

    public void removerContato(Integer numero) {
        agendaDicionario.remove(numero.toString());
    }

    public String getCsv() {
        return agendaDicionario.getCsvArmazenamento();
    }

}

import hashTable.Dicionario;
import hashTable.TipoFuncaoHash;

/**
 * Created by danilo on 28/03/17.
 */
public class AgendaTelefonica {
    private static final TipoFuncaoHash tipoFuncaoHash = TipoFuncaoHash.NAO_POLINOMIAL;
    private Dicionario<String, String> agendaDicionario;

    public AgendaTelefonica() {
        this.agendaDicionario = new Dicionario<>(tipoFuncaoHash);
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

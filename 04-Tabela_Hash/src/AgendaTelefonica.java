import dicionario.Dicionario;

/**
 * Created by danilo on 28/03/17.
 */
public class AgendaTelefonica {
    private Dicionario<String, String> agendaDicionario = new Dicionario<>();

    public void addNovoContato(Integer numero, String nome) {
        agendaDicionario.insert(numero.toString(), nome);
    }

    public void removerContato(Integer numero) {
        agendaDicionario.remove(numero.toString());
    }

    public String getGrafico() {
        return agendaDicionario.getGraficoArmazenamento();
    }

}

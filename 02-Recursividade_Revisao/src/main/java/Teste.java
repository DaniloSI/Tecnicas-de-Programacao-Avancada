/**
 * Created by danilo on 09/03/17.
 */
public class Teste {

    private String nome;
    private String resultadoEsperado;
    private String resultadoObtido;

    public Teste(String nome, String resultadoEsperado, String resultadoObtido) {
        this.nome = nome;
        this.resultadoEsperado = resultadoEsperado;
        this.resultadoObtido = resultadoObtido;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getResultadoEsperado() {
        return resultadoEsperado;
    }

    public void setResultadoEsperado(String resultadoEsperado) {
        this.resultadoEsperado = resultadoEsperado;
    }

    public String getResultadoObtido() {
        return resultadoObtido;
    }

    public void setResultadoObtido(String resultadoObtido) {
        this.resultadoObtido = resultadoObtido;
    }
}

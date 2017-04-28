package recursivdade;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by danilo on 09/03/17.
 */
public class Testador {

    private List<Teste> testes = new ArrayList<>();

    public void addTeste(Teste teste) {
        testes.add(teste);
    }

    public void executarTestes() {
        int testesPassram = 0;
        int testesFalharam = 0;

        for (Teste teste : testes) {
            System.out.println("\n\n\n ### " + teste.getNome() + " ###\n");

            System.out.println("- Resultado esperado: " + teste.getResultadoEsperado());
            System.out.println("- Resultado obtido: " + teste.getResultadoObtido());

            if (teste.getResultadoEsperado().equals(teste.getResultadoObtido())) {
                System.out.println("\n [OK]");

                testesPassram++;
            } else {
                System.out.println("\n [FALHOU]");

                testesFalharam++;
            }

            System.out.println("\n~~~ Fim do Teste ~~~");
        }

        System.out.println("\n\nQuantidade de teste que PASSARAM: [" + testesPassram +"]");
        System.out.println("\nQuantidade de teste que FALHARAM: [" + testesFalharam +"]");

    }

}

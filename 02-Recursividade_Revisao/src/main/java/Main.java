import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by danilo on 09/03/17.
 */
public class Main {

    public static void main(String[] args) {
        Testador testador = new Testador();

        int maiorValorLista;
        int menorValorLista;

        List<Integer> primeiraListaElementos = new ArrayList<>();
        List<Integer> segundaListaElementos = new ArrayList<>();
        List<Integer> terceiraListaElementos = new ArrayList<>();
        List<Integer> listaNumerosSoma = new ArrayList<>();

        Collections.addAll(listaNumerosSoma, 3, 3, 3);


        Collections.addAll(primeiraListaElementos, 9, 7, 3, 28, 1015, 4, 53, 8, 6, 98, 2, 5, 25, 200);
        maiorValorLista = Recursividade.procuraMaiorValor(primeiraListaElementos);

        Collections.addAll(segundaListaElementos, 9, 7, 3, 28, 1015, 4, 53, 8, 6, 98, 2, 5, 25, 200);
        menorValorLista = Recursividade.procuraMenorValor(segundaListaElementos);

        Collections.addAll(terceiraListaElementos, 9, 7, 3, 28, 1015, 4, 53, 8, 6, 98, 2, 5, 25, 200);

        testador.addTeste(
                new Teste(
                        "1. Calcular a soma dos elementos de uma lista numérica.",
                        Integer.toString(9),
                        Integer.toString(Recursividade.somaNumeros(listaNumerosSoma))
                )
        );

        testador.addTeste(
                new Teste(
                        "2. Calcular o produto de 2 números, x e y. (pesquise o conceito de produto).",
                        Integer.toString(-25),
                        Integer.toString(Recursividade.produtoNumeros(5, -5))
                )
        );

        testador.addTeste(
                new Teste(
                        "3. Calcular a divisão inteira de 2 números, x e y. (pesquise o conceito de divisão).",
                        Integer.toString(-5),
                        Integer.toString(Recursividade.divisaoInteira(-21, 4))
                )
        );

        testador.addTeste(
                new Teste(
                        "4. Calcular a raiz quadrada de um número n com tolerância máxima t. (pesquise a definição de\n" +
                                "raiz quadrada)",
                        Double.toString(7.0),
                        Double.toString(Recursividade.raizQuadrada(49.0, 15))
                )
        );

        testador.addTeste(
                new Teste(
                        "5. Pesquisar a existência do elemento e na lista L. Retorna True caso exista, False caso\n" +
                                "contrário.",
                        Boolean.toString(true),
                        Boolean.toString(Recursividade.pesquisaElemento(terceiraListaElementos, 2))
                )
        );

        testador.addTeste(
                new Teste(
                        "6. Inverter uma string de entrada.",
                        "75:01 7102/30/90 - arievilO ed olinaD",
                        Recursividade.inverteString("Danilo de Oliveira - 09/03/2017 10:57")
                )
        );

        testador.addTeste(
                new Teste(
                        "7. Calcular o maior valor de uma lista de números fornecida como entrada.",
                        Integer.toString(1015),
                        Integer.toString(maiorValorLista)
                )
        );

        testador.addTeste(
                new Teste(
                        "8. Calcular o menor valor de uma lista de números fornecida como entrada.",
                        Integer.toString(2),
                        Integer.toString(menorValorLista)
                )
        );

        testador.addTeste(
                new Teste(
                        "9. Testar se uma string de entrada é um palíndromo. Retorna True caso seja, False caso não\n" +
                                "seja um palíndromo.",
                        Boolean.toString(true),
                        Boolean.toString(Recursividade.isPalindromo("Arara"))
                )
        );

        testador.addTeste(
                new Teste(
                        "9. Testar se uma string de entrada é um palíndromo. Retorna True caso seja, False caso não\n" +
                                "seja um palíndromo.",
                        Boolean.toString(true),
                        Boolean.toString(Recursividade.isPalindromo("aaababaaa"))
                )
        );


        testador.executarTestes();

    }

}

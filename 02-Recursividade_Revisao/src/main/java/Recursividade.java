import java.util.ArrayList;
import java.util.List;

/**
 * Created by 20142bsi0186 on 08/03/2017.
 */
public class Recursividade {

    public static int somaNumeros(List<Integer> listNumeros) {
        int primeiroNumero = listNumeros.get(0);
        int tamanhoLista = listNumeros.size();

        if (tamanhoLista == 1) {
            return primeiroNumero;
        } else {
            return primeiroNumero + somaNumeros(listNumeros.subList(1, tamanhoLista));
        }
    }

    public static int produtoNumeros(int x, int y) {
        if (y == 0 || x == 0) {
            return 0;
        } else if (y < 0 && x > 0) {
            return produtoNumeros(y, x);
        } else if (y < 0 && x < 0){
            return produtoNumeros(-x, -y);
        } else {
            return (y == 1) ? x : x + produtoNumeros(x, y - 1);
        }
    }

    public static int divisaoInteira(int x, int y) {
        if (y == 0) {
            throw new IllegalArgumentException("Divisão por zero.");
        } else if(x == 0) {
            return 0;
        } else if(y < 0 && x < 0) {
            return divisaoInteira(-x, -y);
        } else if(y < 0) {
            return -divisaoInteira(x, -y);
        } else if(x < 0) {
            return -divisaoInteira(-x, y);
        } else {
            return (x < y) ? 0 : 1 + divisaoInteira(x - y, y);
        }
    }

    public static double raizQuadrada(double n, int t) {
        double raizProxima = 0.0;

        // Encontra um valor cujo o quadrado eh o mais proximo possivel de n ou o proprio n.
        while (((raizProxima + 1) * (raizProxima + 1)) <= n) {
            raizProxima += 1.0;
        }

        return _raizQuadrada(n, raizProxima, (n / raizProxima), (t - 1));
    }

    /**
     * Raiz quadrada utilizando o metodo babilonico.
     * @param n eh o numero 'n' que se quer calcular a raiz quadrada, ou seja raiz de 'n'.
     * @param a eh sempre a media aritmetica entre os dois ultimos resultados da recursividade.
     * @param b eh o resultado final.
     * @param t eh a tolerancia que decrementa apos cada recursao.
     * @return resultado da raiz de 'n'.
     */
    private static double _raizQuadrada(double n, double a, double b, int t) {
        if (t <= 0) {
            return b;
        } else {
            return _raizQuadrada(n, ((a + b) / 2.0), (n / ((a + b) / 2.0)), (t - 1));
        }
    }

    public static boolean pesquisaElemento(List<Integer> listaElementos, int elemento) {
        if (listaElementos.size() == 0) {
            return false;
        } else {
            if (listaElementos.get(0) == elemento) {
                return true;
            } else {
                return pesquisaElemento(listaElementos.subList(1, listaElementos.size()), elemento);
            }
        }
    }

    public static String inverteString(String string) {
        int stringLength = string.length();

        if ((stringLength == 0)) {
            return "";
        } else {
            char ultimaLetra = string.charAt(stringLength - 1);

            return ultimaLetra + inverteString(string.substring(0, stringLength - 1));
        }
    }

    public static Integer procuraMaiorValor(List<Integer> listaNumeros) {
        if (listaNumeros == null || listaNumeros.size() == 0){
            return null;
        } else if (listaNumeros.size() == 1) {
            return listaNumeros.get(0);
        } else {
            if(listaNumeros.get(0) > listaNumeros.get(1)) {
                listaNumeros.set(1, listaNumeros.get(0));
            }

            return procuraMaiorValor(listaNumeros.subList(1, listaNumeros.size()));
        }
    }

    public static Integer procuraMenorValor(List<Integer> listaNumeros) {
        if (listaNumeros == null || listaNumeros.size() == 0){
            return null;
        } else if (listaNumeros.size() == 1) {
            return listaNumeros.get(0);
        } else {
            if(listaNumeros.get(0) < listaNumeros.get(1)) {
                listaNumeros.set(1, listaNumeros.get(0));
            }

            return procuraMenorValor(listaNumeros.subList(1, listaNumeros.size()));
        }
    }

    public static boolean isPalindromo(String string) {
        if (string == null) {
            return false;
        } else if (string.length() == 1 || string.equals("")) {
            return true;
        } else {
            String substring = string.substring(1, string.length() - 1);
            char primeiraLetra = string.toLowerCase().charAt(0);
            char ultimaLetra = string.toLowerCase().charAt(string.length() - 1);

            return (primeiraLetra == ultimaLetra) && isPalindromo(substring);
        }
    }

    public static String toBinario(int decimal) {
        if (decimal == 0) {
            return "0";
        } else if(decimal == 1) {
            return "1";
        } else {
            return toBinario(decimal / 2) + Integer.toString(decimal % 2);
        }
    }

    /**
     * Metodo que transforma uma lista com uma unica string em uma lista de combinacoes com os caracteres da string.
     * @param listString parametro recursivo.
     * @return lista de combinacoes de uma string recebida como parametro.
     */
    public static List<String> permutacoes(List<String> listString) {

        if (listString.get(0).length() < 1) {
            return null;

        } else if (listString.get(0).length() == 1) {
            List<String> permutacoes = new ArrayList<>();

            permutacoes.add(listString.get(0));
            return permutacoes;

        } else if (listString.get(0).length() == 2) {
            // Caso base, em que a lista de strings possui strings com 2 caracteres.

            List<String> permutacoes = new ArrayList<>();

            String normal = listString.get(0);
            String invertido = normal.substring(1, 2) + normal.substring(0, 1);

            permutacoes.add(normal);
            permutacoes.add(invertido);

            return permutacoes;

        } else {
            List<String> novasCombinacoes = new ArrayList<>();

            for (String combinacao : listString) {
                char elementoPermutado = combinacao.charAt(0);

                List<String> subCombinacoes = new ArrayList<>();
                subCombinacoes.add(combinacao.substring(1));

                subCombinacoes = permutacoes(subCombinacoes);

                for (String stringCombinacao : subCombinacoes) {

                    for (int i = 0 ; i <= stringCombinacao.length() ; i++) {
                        String primeiraFatia = stringCombinacao.substring(0, i);
                        String segundaFatia = stringCombinacao.substring(i);

                        novasCombinacoes.add(primeiraFatia + elementoPermutado + segundaFatia);
                    }

                }

            }

            return novasCombinacoes;
        }

    }

}

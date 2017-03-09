import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 20142bsi0186 on 08/03/2017.
 */
public class Recursividade {

    public static void main(String[] args) {
        List<Integer> primeiraListaElementos = new ArrayList<>();
        List<Integer> segundaSistaElementos = new ArrayList<>();

        Collections.addAll(primeiraListaElementos, 9, 7, 3, 28, 1015, 4, 53, 8, 6, 98, 2, 5, 25, 200);
        Collections.addAll(segundaSistaElementos, 9, 7, 3, 28, 1015, 4, 53, 8, 6, 98, 2, 5, 25, 200);

        System.out.println(raizQuadrada(48.0, 15));

        System.out.println(pesquisaElemento(primeiraListaElementos, 2));

        System.out.println(inverteString("Danilo de Oliveira - 09/03/2017 10:57"));

        System.out.println(procuraMaiorValor(primeiraListaElementos));
        System.out.println(procuraMenorValor(segundaSistaElementos));

        System.out.println("Arara eh palindromo: " + isPalindromo("Arara"));
        System.out.println("Carro eh palindromo: " + isPalindromo("Carro"));
        System.out.println("o eh palindromo: " + isPalindromo("o"));
        System.out.println("aa eh palindromo: " + isPalindromo("aa"));
        System.out.println("aaababaaa eh palindromo: " + isPalindromo("aaababaaa"));




    }

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

}

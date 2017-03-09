import java.util.List;

/**
 * Created by 20142bsi0186 on 08/03/2017.
 */
public class Recursividade {

    public static void main(String[] args) {
        System.out.println(raizQuadrada(48.0, 15));
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

        return _raizQuadrada(n, raizProxima, n / raizProxima, t - 1);
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
            return _raizQuadrada(n, (a + b) / 2.0, n / ((a + b) / 2.0), t - 1);
        }
    }

}

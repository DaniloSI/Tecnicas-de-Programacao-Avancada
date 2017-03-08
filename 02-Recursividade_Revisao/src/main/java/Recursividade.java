import java.util.ArrayList;
import java.util.Collections;
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

    public static int produtoDoisNumeros(int x, int y) {
        if (y == 0 || x == 0) {
            return 0;
        } else if (y < 0 && x > 0) {
            return (y == -1) ? -x : -x + produtoDoisNumeros(x, y + 1);
        } else if (y < 0 && x < 0){
            return produtoDoisNumeros(-x, -y);
        } else {
            return (y == 1) ? x : x + produtoDoisNumeros(x, y - 1);
        }
    }


}

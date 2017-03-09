import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by 20142bsi0186 on 08/03/2017.
 */
public class Testes {


    @Test
    public void somarListaNumeros() {
        List<Integer> primeiraListaNumeros = new ArrayList<>();
        List<Integer> segundaListaNumeros = new ArrayList<>();

        Collections.addAll(primeiraListaNumeros, 3, 3, 3);
        Collections.addAll(segundaListaNumeros, 10, 10, 15);

        assertEquals(true, Recursividade.somaNumeros(primeiraListaNumeros) == 9);
        assertEquals(true, Recursividade.somaNumeros(segundaListaNumeros) == 35);

    }

    @Test
    public void multiplicarNumeros() {
        assertEquals(true, Recursividade.produtoNumeros(5, 0) == 0);
        assertEquals(true, Recursividade.produtoNumeros(0, 5) == 0);
        assertEquals(true, Recursividade.produtoNumeros(5, -5) == -25);
        assertEquals(true, Recursividade.produtoNumeros(-5, 5) == -25);
        assertEquals(true, Recursividade.produtoNumeros(-5, -5) == 25);
        assertEquals(true, Recursividade.produtoNumeros(5, 5) == 25);
    }

    @Test
    public void dividirNumeros() {
        assertEquals(true, Recursividade.divisaoInteira(0, 5) == 0);
        assertEquals(true, Recursividade.divisaoInteira(5, 1) == 5);
        assertEquals(true, Recursividade.divisaoInteira(5, 2) == 2);
        assertEquals(true, Recursividade.divisaoInteira(14, 7) == 2);
        assertEquals(true, Recursividade.divisaoInteira(10, 2) == 5);
        assertEquals(true, Recursividade.divisaoInteira(-21, 4) == -5);
        assertEquals(true, Recursividade.divisaoInteira(21, -4) == -5);
        assertEquals(true, Recursividade.divisaoInteira(21, 21) == 1);
        assertEquals(true, Recursividade.divisaoInteira(21, 22) == 0);
    }

}

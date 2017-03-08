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
    public void multiplicarDoisNumeros() {
        assertEquals(true, Recursividade.produtoDoisNumeros(5, 0) == 0);
        assertEquals(true, Recursividade.produtoDoisNumeros(0, 5) == 0);
        assertEquals(true, Recursividade.produtoDoisNumeros(5, -5) == -25);
        assertEquals(true, Recursividade.produtoDoisNumeros(-5, 5) == -25);
        assertEquals(true, Recursividade.produtoDoisNumeros(-5, -5) == 25);
        assertEquals(true, Recursividade.produtoDoisNumeros(5, 5) == 25);
    }


}

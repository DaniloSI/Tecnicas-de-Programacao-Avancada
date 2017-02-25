package testes;

import domain.Matrix;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by Danilo de Oliveira on 25/02/2017.
 */
public class MatrixTeste {

    private Matrix matrixOne;
    private Matrix matrixTwo;

    @Before
    public void criarMatrizes() throws IOException {
        matrixOne = new Matrix();
        matrixTwo = new Matrix();

        // Adicionando valores na matrizOne.
        matrixOne.add(0,0,2);
        matrixOne.add(0,1,3);
        matrixOne.add(1,0,0);
        matrixOne.add(1,1,1);
        matrixOne.add(2,0,-1);
        matrixOne.add(2,1,4);

        // Adicionando valores na matrizTwo.
        matrixTwo.add(0, 0, 1);
        matrixTwo.add(0, 1, 2);
        matrixTwo.add(0, 2, 3);
        matrixTwo.add(1, 0, -2);
        matrixTwo.add(1, 1, 0);
        matrixTwo.add(1, 2, 4);
    }

    @Test
    public void produtoMatrizes() {
        Matrix matrixProduto = new Matrix();

        matrixProduto.add(0, 0, -4);
        matrixProduto.add(0, 1, 4);
        matrixProduto.add(0, 2, 18);
        matrixProduto.add(1, 0, -2);
        matrixProduto.add(1, 1, 0);
        matrixProduto.add(1, 2, 4);
        matrixProduto.add(2, 0, -9);
        matrixProduto.add(2, 1, -2);
        matrixProduto.add(2, 2, 13);

        assertEquals(matrixOne.times(matrixTwo), matrixProduto);
    }

}

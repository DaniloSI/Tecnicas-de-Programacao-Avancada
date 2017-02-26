package testes;

import controller.FileMatrix;
import domain.Matrix;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;


/**
 * Created by Danilo de Oliveira on 25/02/2017.
 */
public class FileMatrixTeste {

    private Matrix matrixToWrite;
    private String resourcePath = "src" + File.separator + "main" + File.separator + "java" + File.separator + "resources" + File.separator;

    @Before
    public void criarMatrizesEscreverEmArquivo() throws IOException {
        matrixToWrite = new Matrix();

        matrixToWrite.add(0,0,5);
        matrixToWrite.add(1,2,1);
        matrixToWrite.add(2,2,4);
        matrixToWrite.add(2,0,7);
        matrixToWrite.add(2,3,8);

        FileMatrix.writeFileMatrix(matrixToWrite, resourcePath + "escritaMatrizTeste.txt");
    }

    @Test
    public void leituraMatrizArquivo() throws IOException {
        assertEquals(FileMatrix.readFileMatrix(resourcePath + "escritaMatrizTeste.txt"), matrixToWrite);
    }
}

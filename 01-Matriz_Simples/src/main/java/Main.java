import controller.FileMatrix;
import domain.Matrix;

import java.io.File;
import java.io.IOException;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Main {

    /**
     * Para executar pelo Run da IDE, deve-se passar o path incluindo
     * o 'src'. Exemplo: src/resources/matrixOne.txt. Para executar
     * atraves da linha de comando, deve-se passar o path da mesma forma,
     * mas sem o 'src'. Exemplo: resources/matrixOne.txt.
     * @param args eh o path do arquivo de matriz.
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String resourcePath = "src" + File.separator + "main" + File.separator + "java" + File.separator + "resources" + File.separator;

        Matrix matrixOne;
        Matrix matrixTwo;
        Matrix matrixOneIgual;
        Matrix matrixTwoIgual;

        System.out.println("\nMatriz escrita a mao em um arquivo:");
        System.out.println(FileMatrix.readFileMatrix(resourcePath + "matrixOne.txt"));

        matrixOne = FileMatrix.readFileMatrix(resourcePath + "matrixOne.txt");
        matrixTwo = FileMatrix.readFileMatrix(resourcePath + "matrixTwo.txt");

        matrixOneIgual = FileMatrix.readFileMatrix(resourcePath + "matrixOneIgual.txt");
        matrixTwoIgual = FileMatrix.readFileMatrix(resourcePath + "matrixTwoIgual.txt");

        System.out.println("\nMatriz 1:");
        System.out.println(matrixOne);

        System.out.println("\nMatriz 2:");
        System.out.println(matrixTwo);

        System.out.println("\nResultado do produto Matriz 1 x Matriz 2:");
        System.out.println(matrixOne.times(matrixTwo));

        System.out.println("\nResultado do produto Matriz 2 x Matriz 1:");
        System.out.println(matrixTwo.times(matrixOne));

        System.out.println("As duas matrizes sao iguais: " + matrixOneIgual.equals(matrixTwoIgual));
    }

}

import controller.FileMatrix;
import domain.Matrix;

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
        Matrix matrix = new Matrix();
        Matrix matrixOne;
        Matrix matrixTwo;
        Matrix matrixOneIgual;
        Matrix matrixTwoIgual;

        matrix.add(0,0,5);
        matrix.add(1,2,1);
        matrix.add(2,2,4);
        matrix.add(2,0,7);
        matrix.add(2,3,8);

        FileMatrix.writeFileMatrix(matrix, "src/resources/outputMatrix.txt");

        System.out.println("Matriz escrita em um arquivo:");
        System.out.println(FileMatrix.readFileMatrix("src/resources/outputMatrix.txt"));

        System.out.println("\nMatriz escrita a mao em um arquivo:");
        System.out.println(FileMatrix.readFileMatrix("src/resources/matrixOne.txt"));

        matrixOne = FileMatrix.readFileMatrix("src/resources/matrixOne.txt");
        matrixTwo = FileMatrix.readFileMatrix("src/resources/matrixTwo.txt");

        matrixOneIgual = FileMatrix.readFileMatrix("src/resources/matrixOneIgual.txt");
        matrixTwoIgual = FileMatrix.readFileMatrix("src/resources/matrixTwoIgual.txt");

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

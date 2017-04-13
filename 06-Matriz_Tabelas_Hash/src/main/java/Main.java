import controller.FileMatrix;
import domain.Matrix;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Main {

    private static String resourcePathBdMatrizes = "bd-matrizes" + File.separator;

    public static void main(String[] args) throws IOException, URISyntaxException {
        ClassLoader classLoader = Main.class.getClassLoader();
        File fileMatrix = new File(classLoader.getResource(resourcePathBdMatrizes + "mat001.txt").toURI());
        Matrix matrixDoubles = FileMatrix.readFileMatrix(fileMatrix);

        System.out.println(matrixDoubles);


        // Teste produto de matrizes
        Matrix matrixOne = new Matrix();
        Matrix matrixTwo = new Matrix();
        Matrix matrixResult = new Matrix();


        matrixOne.add(0, 0, 9);
        matrixOne.add(0, 1, 7);
        matrixOne.add(0, 2, 5);
        matrixOne.add(0, 3, 1);
        matrixOne.add(1, 0, 2);
        matrixOne.add(1, 1, 5);
        matrixOne.add(1, 2, 1);
        matrixOne.add(1, 3, 3);

        matrixTwo.add(0, 0, 3);
        matrixTwo.add(0, 1, 1);
        matrixTwo.add(0, 2, 2);
        matrixTwo.add(1, 0, 4);
        matrixTwo.add(1, 1, 5);
        matrixTwo.add(1, 2, 6);
        matrixTwo.add(2, 0, 8);
        matrixTwo.add(2, 1, 5);
        matrixTwo.add(2, 2, 2);
        matrixTwo.add(3, 0, 1);
        matrixTwo.add(3, 1, 6);
        matrixTwo.add(3, 2, 7);

        matrixResult.add(0, 0, 96);
        matrixResult.add(0, 1, 75);
        matrixResult.add(0, 2, 77);
        matrixResult.add(1, 0, 37);
        matrixResult.add(1, 1, 50);
        matrixResult.add(1, 2, 57);

        System.out.println(matrixOne.times(matrixTwo).equals(matrixResult));
        // Fim teste produto de matrizes
    }

}

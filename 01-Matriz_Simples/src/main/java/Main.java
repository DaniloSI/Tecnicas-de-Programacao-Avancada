import controller.FileMatrix;
import domain.Matrix;

import java.io.File;
import java.io.IOException;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Main {

    private static String resourcePath = "src" + File.separator + "main" + File.separator + "java" + File.separator + "resources" + File.separator;
    private static String resourcePathBdMatrizes = resourcePath + "bd-matrizes" + File.separator;

    public static void main(String[] args) throws IOException {
        Matrix matrixDoubles = FileMatrix.readFileMatrix(resourcePathBdMatrizes + "mat001.txt");

        System.out.println(matrixDoubles);
    }

}

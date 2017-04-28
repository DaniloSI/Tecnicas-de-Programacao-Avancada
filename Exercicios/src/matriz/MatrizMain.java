package matriz;

import matriz.controller.FileMatrix;
import matriz.domain.Matrix;

import java.io.File;
import java.io.IOException;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class MatrizMain {

    private static final String separator = File.separator;
    private static final String pathRoot = new File("").getAbsolutePath() + separator;

    public static void main(String[] args) throws IOException {
        String resourcePath = pathRoot + "src" + separator + "matriz" + separator + "resources" + separator;
        String resourcePathBdMatrizes = resourcePath + "bd-matrizes" + separator;
        Matrix matrixDoubles = FileMatrix.readFileMatrix(resourcePathBdMatrizes + "mat001.txt");

        System.out.println(matrixDoubles);
    }

}

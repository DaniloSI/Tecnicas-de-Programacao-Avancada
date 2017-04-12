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
    private static String fileMatrixName = "mat001.txt";

    public static void main(String[] args) throws IOException, URISyntaxException {
        ClassLoader classLoader = Main.class.getClassLoader();
        File fileMatrix = new File(classLoader.getResource(resourcePathBdMatrizes + fileMatrixName).toURI());
        Matrix matrixDoubles = FileMatrix.readFileMatrix(fileMatrix);

        System.out.println(matrixDoubles);
    }

}

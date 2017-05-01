package hashTableMatriz;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class HashTablesMatrizMain {

    private static String resourcePathBdMatrizes = "bd-matrizes" + File.separator;

    public static void main(String[] args) throws IOException, URISyntaxException {
        String fileName = resourcePathBdMatrizes + "mat001.txt";
        String projectPath = new File("").getAbsolutePath() + File.separator;
        String fullPath = projectPath + "src" + File.separator + "hashTableMatriz" + File.separator;

        Matriz matrizDoubles = Matriz.carregaMMF(fullPath + "_circuit_2.mtx");

        System.out.println(matrizDoubles.get(4313, 3868));

        // Teste produto de matrizes
        Matriz matrizOne = new Matriz(2, 4);
        Matriz matrizTwo = new Matriz(4, 3);
        Matriz matrizResult = new Matriz(2, 3);


        matrizOne.add(0, 0, 9.0F);
        matrizOne.add(0, 1, 7.0F);
        matrizOne.add(0, 2, 5.0F);
        matrizOne.add(0, 3, 1.0F);
        matrizOne.add(1, 0, 2.0F);
        matrizOne.add(1, 1, 5.0F);
        matrizOne.add(1, 2, 1.0F);
        matrizOne.add(1, 3, 3.0F);

        matrizTwo.add(0, 0, 3.0F);
        matrizTwo.add(0, 1, 1.0F);
        matrizTwo.add(0, 2, 2.0F);
        matrizTwo.add(1, 0, 4.0F);
        matrizTwo.add(1, 1, 5.0F);
        matrizTwo.add(1, 2, 6.0F);
        matrizTwo.add(2, 0, 8.0F);
        matrizTwo.add(2, 1, 5.0F);
        matrizTwo.add(2, 2, 2.0F);
        matrizTwo.add(3, 0, 1.0F);
        matrizTwo.add(3, 1, 6.0F);
        matrizTwo.add(3, 2, 7.0F);

        matrizResult.add(0, 0, 96.0F);
        matrizResult.add(0, 1, 75.0F);
        matrizResult.add(0, 2, 77.0F);
        matrizResult.add(1, 0, 37.0F);
        matrizResult.add(1, 1, 50.0F);
        matrizResult.add(1, 2, 57.0F);

        System.out.println(matrizOne.times(matrizTwo).equals(matrizResult));
        System.out.println(matrizOne.times(matrizTwo));
        System.out.println();
        System.out.println(matrizResult);

        matrizResult.removeRow(1);
        matrizResult.removeColumn(1);
        System.out.println(matrizResult);

        matrizResult.salvaMMF(fullPath + "Produto_Matrizes.mtx");
        // Fim teste produto de matrizes
    }

}

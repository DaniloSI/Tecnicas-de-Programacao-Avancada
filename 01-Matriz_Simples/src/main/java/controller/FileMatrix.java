package controller;

import domain.Matrix;


import java.io.*;
import java.nio.file.Paths;

/**
 * Created by danilo on 16/02/17.
 */
public class FileMatrix {



    public static Matrix readFileMatrix(String fileMatrixName) throws IOException {
        String resourcesPath = Paths.get("").toAbsolutePath().toString() + File.separator;
        File fileMatrix = new File(resourcesPath + fileMatrixName);
        BufferedReader fileIn = new BufferedReader(new FileReader(fileMatrix));
        String line;
        Matrix matrix = new Matrix();
        int row = 0;
        int column;

        while ((line = fileIn.readLine()) != null) {
            String[] numbers = line.split("\\s");

            column = 0;
            for (String number: numbers) {
                if (!number.equals("")) {
                    number = number.replace(",", ".");
                    matrix.add(row, column, Double.parseDouble(number));
                    column++;
                }
            }

            row++;
        }

        return matrix;
    }

    public static void writeFileMatrix(Matrix matrix, String fileMatrixName) throws IOException {
        String resourcesPath = Paths.get("").toAbsolutePath().toString() + File.separator;
        File fileMatrix = new File(resourcesPath + fileMatrixName);
        Writer writerMatrix = new BufferedWriter(new FileWriter(fileMatrix));

        for (int row = 0; row < matrix.getNumberOfRows() ; row++) {
            for (int column = 0; column < matrix.getNumberOfColumns() ; column++) {
                String value = Double.toString(matrix.get(row, column));
                writerMatrix.write(value.replace(".", ","));

                if (column != (matrix.getNumberOfColumns() - 1)) {
                    writerMatrix.write("\t");
                }
            }

            if (row != (matrix.getNumberOfRows() - 1)) {
                writerMatrix.write("\n");
            }
        }

        writerMatrix.close();
    }
}

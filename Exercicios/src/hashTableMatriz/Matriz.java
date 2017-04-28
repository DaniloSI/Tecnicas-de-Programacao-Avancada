package hashTableMatriz;

import hashTable.HashTable;
import hashTable.TabelaHashChain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Matriz {

    private HashTable matriz;
    private int numberOfRows;
    private int numberOfColumns;

    public Matriz(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        matriz = new TabelaHashChain(new HashEngineMat());
    }

    /**
     * Responsável por adicionar um elemento na matriz em uma determinada linha e coluna.
     * @param row Linha da matriz.
     * @param column Coluna da matriz.
     * @param value Valor que será inserido.
     */
    public void add(int row, int column, float value) {
        Cell cell = new Cell(row, column, value);

        if (value != 0.0f && row < numberOfRows && column < numberOfColumns)
            matriz.insertItem(cell, cell);
    }

    public float get(int row, int column) {
        Object objectCell;

        if (row >= numberOfRows || row < 0 || column >= numberOfColumns || column < 0)
            throw new IllegalArgumentException("Linha ou coluna inválida.");
        else {
            objectCell = matriz.findElem(new Cell(row, column));
            return (objectCell != HashTable.NO_SUCH_KEY) ? ((Cell) objectCell).getElem() : 0;
        }

    }

    @Override
    public String toString() {
        String matriz = "";
        for (int row = 0; row < numberOfRows; row++) {
             for (int column = 0; column < numberOfColumns; column++) {
                matriz += String.format("%7.2f   ", get(row, column));
            }
            matriz += ("\n");
        }

        return matriz;
    }

    public int getNumberOfRows() {
        return numberOfRows;
    }

    public int getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * Multiplica a matriz por uma outra matriz.
     * @param matTwo Matriz a ser multiplicada.
     * @return Resultado da multiplicação das matrizes.
     */
    public Matriz times(Matriz matTwo) {
        Matriz resultMatriz = null;

        if (numberOfColumns == matTwo.getNumberOfRows()) {
            resultMatriz = new Matriz(numberOfRows, matTwo.getNumberOfColumns());

            for (int rowMatOne = 0; rowMatOne < numberOfRows; rowMatOne++) {
                for (int colMatTwo = 0; colMatTwo < matTwo.getNumberOfColumns() ; colMatTwo++) {
                    float resultValue = 0.0f;

                    for (int rowMatTwo = 0; rowMatTwo < matTwo.getNumberOfRows() ; rowMatTwo++) {
                        float vCellOne = this.get(rowMatOne, rowMatTwo);
                        float vCellTwo = matTwo.get(rowMatTwo, colMatTwo);

                        resultValue += vCellOne * vCellTwo;
                    }

                    resultMatriz.add(rowMatOne, colMatTwo, resultValue);
                }
            }
        }

        return resultMatriz;
    }

    /**
     * Duas matrizes são iguais se tiver a mesma quantidade de linhas, a mesma quantidade de colunas e os valores das células correspondentes forem iguais.
     * @param object objeto.
     * @return Se as matrizes são iguais ou não.
     */
    @Override
    public boolean equals(Object object) {
        Matriz matTwo = (Matriz) object;
        boolean qLinhasIguais = numberOfRows == matTwo.getNumberOfRows();
        boolean qColunasIguais = numberOfColumns == matTwo.getNumberOfColumns();

        if (qLinhasIguais && qColunasIguais) {
            for (int row = 0; row < numberOfRows; row++) {
                for (int column = 0; column < numberOfColumns; column++) {
                    if (matTwo.get(row, column) != this.get(row, column))
                        return false;
                }
            }

            return true;
        }

        return false;
    }

    public static Matriz carregaMMF(String nomeArq) throws IOException {
        Matriz matrizLoad;
        BufferedReader buffReader = new BufferedReader(new FileReader(nomeArq));
        String line;
        int linhas;
        int colunas;

        while ((line = buffReader.readLine()) != null && line.length() > 0 && line.charAt(0) == '%');

        linhas = Integer.parseInt(line.replaceAll("\\s+", ",").split(",")[0]);
        colunas = Integer.parseInt(line.replaceAll("\\s+", ",").split(",")[1]);

        matrizLoad = new Matriz(linhas, colunas);

        while ((line = buffReader.readLine()) != null) {
            if (line.length() > 0 && line.charAt(0) != '%') {
                String[] lineClean = line.replaceAll("\\s+", ",").split(",");
                int linha = Integer.parseInt(lineClean[0]) - 1;
                int coluna = Integer.parseInt(lineClean[1]) - 1;
                float elem = Float.parseFloat(lineClean[2]);

                matrizLoad.add(linha, coluna, elem);
            }
        }

        buffReader.close();

        return matrizLoad;
    }

    public void salvaMMF(String nomeArq) throws IOException {
        FileWriter fileWriter = new FileWriter(nomeArq);

        fileWriter.write(numberOfRows + " " + numberOfColumns + " " + matriz.size());

        for (Object cellObject: matriz.elements()) {
            Cell cell = (Cell) cellObject;
            Integer linha = cell.getI() + 1;
            Integer coluna = cell.getJ() + 1;
            Float elem = cell.getElem();

            fileWriter.write("\n" + linha + " " + coluna + " " + elem);
        }

        fileWriter.close();
    }
}

package domain;

import hashTable.HashTable;
import hashTable.ItemTabelaHash;
import hashTable.TabelaHash;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Matrix {

    private HashTable matrix;
    private int numberOfRows = 0;
    private int numberOfColumns = 0;

    public Matrix() {
        matrix = new TabelaHash(100);
    }

    public Matrix(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        matrix = new TabelaHash(100);
    }

    /**
     * Responsável por adicionar um elemento na matriz em uma determinada linha e coluna.
     * @param row Linha da matriz.
     * @param column Coluna da matriz.
     * @param value Valor que será inserido.
     */
    public void add(int row, int column, double value) {
        matrix.insert(new ItemTabelaHash<>(row + ";" + column, value));

        // A quantidade de linhas será a mesma se a linha alvo for maior. Caso o contrário passa a ser a própria linha alvo.
        numberOfRows = ((row + 1) > numberOfRows) ? (row + 1) : numberOfRows;
        numberOfColumns = ((column + 1) > numberOfColumns) ? (column + 1) : numberOfColumns;
    }

    public double get(int row, int column) {
        ItemTabelaHash cell;

        if (row >= this.numberOfRows || row < 0 || column >= this.numberOfColumns || column < 0)
            throw new IllegalArgumentException("Linha ou coluna inválida.");
        else {
            cell = matrix.find(row + ";" + column);
            return (cell == HashTable.NO_SUCH_KEY) ? 0 : (double) cell.getValue();
        }

    }

    @Override
    public String toString() {
        String matrix = "";
        for (int row = 0; row < numberOfRows; row++) {
             for (int column = 0; column < numberOfColumns; column++) {
                matrix += (get(row, column) + "\t");
            }
            matrix += ("\n");
        }

        return matrix;
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
    public Matrix times(Matrix matTwo) {
        Matrix resultMatrix = null;

        if (numberOfColumns == matTwo.getNumberOfRows()) {
            resultMatrix = new Matrix();

            for (int rowMatOne = 0; rowMatOne < numberOfRows; rowMatOne++) {
                for (int colMatTwo = 0; colMatTwo < matTwo.getNumberOfColumns() ; colMatTwo++) {
                    int resultValue = 0;

                    for (int rowMatTwo = 0; rowMatTwo < matTwo.getNumberOfRows() ; rowMatTwo++) {
                        resultValue += this.get(rowMatOne, rowMatTwo) * matTwo.get(rowMatTwo, colMatTwo);
                    }

                    resultMatrix.add(rowMatOne, colMatTwo, resultValue);
                }
            }
        }

        return resultMatrix;
    }

    /**
     * Duas matrizes são iguais se tiver a mesma quantidade de linhas, a mesma quantidade de colunas e os valores das células correspondentes forem iguais.
     * @param object objeto.
     * @return Se as matrizes são iguais ou não.
     */
    @Override
    public boolean equals(Object object) {
        Matrix matTwo = (Matrix) object;

        if (matTwo.getNumberOfRows() != numberOfRows || matTwo.numberOfColumns != numberOfColumns)
            return false;

        else {
            for (int row = 0; row < numberOfRows; row++) {
                for (int column = 0; column < numberOfColumns; column++) {
                    if (matTwo.get(row, column) != this.get(row, column))
                        return false;
                }
            }

            return true;
        }
    }
}

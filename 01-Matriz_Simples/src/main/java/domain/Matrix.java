package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Matrix {

    private List<Cell> matrix;
    private int numberOfRows = 0;
    private int numberOfColumns = 0;

    public Matrix() {
        matrix = new ArrayList<>();
    }

    public Matrix(int numberOfRows, int numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        matrix = new ArrayList<>();
    }

    /**
     * Responsável por adicionar um elemento na matriz em uma determinada linha e coluna.
     * @param row Linha da matriz.
     * @param column Coluna da matriz.
     * @param value Valor que será inserido.
     */
    public void add(int row, int column, double value) {

        if (value != 0.0D) {
            int indexCell = getIndex(row, column);

            if (indexCell == matrix.size()) {
                matrix.add(new Cell(row, column, value));
            }
            else {
                matrix.get(indexCell).setValue(value);
            }
        }

        // A quantidade de linhas será a mesma se a linha alvo for maior. Caso o contrário passa a ser a própria linha alvo.
        numberOfRows = ((row + 1) > numberOfRows) ? (row + 1) : numberOfRows;
        numberOfColumns = ((column + 1) > numberOfColumns) ? (column + 1) : numberOfColumns;
    }

    public double get(int row, int column) {
        int indexCell = getIndex(row, column);

        return (indexCell == matrix.size()) ?  0 : matrix.get(indexCell).getValue();
    }

    private int getIndex(int row, int column) {

        for (int index = 0 ; index < matrix.size() ; index++) {
            Cell cell = matrix.get(index);

            if (cell.getRow() == row && cell.getColumn() == column) {
                return index;
            }
        }

        return matrix.size();
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
     * @param matrix Matriz a ser multiplicada.
     * @return Resultado da multiplicação das matrizes.
     */
    public Matrix times(Matrix matrix) {
        Matrix resultMatrix = null;

        if (numberOfColumns == matrix.getNumberOfRows()) {
            resultMatrix = new Matrix();

            for (int rowFirstMatrix = 0; rowFirstMatrix < numberOfRows; rowFirstMatrix++) {
                for (int columnSecondMatrix = 0; columnSecondMatrix < matrix.getNumberOfColumns() ; columnSecondMatrix++) {
                    int resultValue = 0;

                    for (int rowSecondMatrix = 0; rowSecondMatrix < matrix.getNumberOfRows() ; rowSecondMatrix++) {
                        resultValue += this.get(rowFirstMatrix, rowSecondMatrix) * matrix.get(rowSecondMatrix, columnSecondMatrix);
                    }

                    resultMatrix.add(rowFirstMatrix, columnSecondMatrix, resultValue);
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
        Matrix matrix = (Matrix) object;

        if (matrix.getNumberOfRows() != numberOfRows || matrix.numberOfColumns != numberOfColumns) {
            return false;
        }
        else {
            for (int row = 0; row < numberOfRows; row++) {
                for (int column = 0; column < numberOfColumns; column++) {
                    if (matrix.get(row, column) != this.get(row, column)) {
                        return false;
                    }
                }
            }

            return true;
        }
    }
}

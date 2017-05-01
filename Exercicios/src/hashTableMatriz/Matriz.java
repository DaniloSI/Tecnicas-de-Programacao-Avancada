package hashTableMatriz;

import hashTable.HashTable;
import hashTable.HashTableChain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Matriz {

    private HashTable matriz;
    private Integer numberOfRows;
    private Integer numberOfColumns;

    public Matriz(Integer numberOfRows, Integer numberOfColumns) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;

        matriz = new HashTableChain(new HashEngineMat());
    }

    /**
     * Responsável por adicionar um elemento na matriz em uma determinada linha e coluna.
     *
     * @param row    Linha da matriz.
     * @param column Coluna da matriz.
     * @param value  Valor que será inserido.
     */
    public void add(Integer row, Integer column, Float value) {
        Cell cell = new Cell(row, column, value);

        if (row >= numberOfRows)
            numberOfRows = row + 1;

        if (column >= numberOfColumns)
            numberOfColumns = column + 1;

        if (!value.equals(0.0F))
            matriz.insertItem(cell, cell);
        else
            matriz.removeItem(cell);
    }

    public Float get(Integer row, Integer column) {
        Object objectCell;

        if (!validRow(row) || !validColumn(column))
            return null;

        else {
            objectCell = matriz.findElem(new Cell(row, column));
            return (objectCell != HashTable.NO_SUCH_KEY) ? ((Cell) objectCell).getElem() : 0.0F;
        }

    }

    private boolean validRow(Integer row) {
        return row != null && row < numberOfRows && row >= 0;
    }

    private boolean validColumn(Integer column) {
        return column != null && column < numberOfColumns && column >= 0;
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

    public Integer getNumberOfRows() {
        return numberOfRows;
    }

    public Integer getNumberOfColumns() {
        return numberOfColumns;
    }

    /**
     * Multiplica a matriz por uma outra matriz.
     *
     * @param matTwo Matriz a ser multiplicada.
     * @return Resultado da multiplicação das matrizes.
     */
    public Matriz times(Matriz matTwo) {
        Matriz resultMatriz = null;

        if (numberOfColumns == matTwo.getNumberOfRows()) {
            resultMatriz = new Matriz(numberOfRows, matTwo.getNumberOfColumns());

            for (int rowMatOne = 0; rowMatOne < numberOfRows; rowMatOne++) {
                for (int colMatTwo = 0; colMatTwo < matTwo.getNumberOfColumns(); colMatTwo++) {
                    float resultValue = 0.0f;

                    for (int rowMatTwo = 0; rowMatTwo < matTwo.getNumberOfRows(); rowMatTwo++) {
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
     * Método que funciona para matrizes de qualquer dimensão.
     * @param paramRow Linha a ser delatada da matriz.
     */
    public void removeRow(Integer paramRow) {
        if (validRow(paramRow)) {
            cleanDimension(paramRow, null);

            for (int row = paramRow + 1; row < numberOfRows; row++) {
                shiftDimension(row, null);
            }

            numberOfRows--;
        }
    }

    /**
     * Método que funciona para matrizes de qualquer dimensão.
     * @param paramColumn Coluna da matriz a ser deletada.
     */
    public void removeColumn(Integer paramColumn) {
        if (validColumn(paramColumn)) {
            cleanDimension(null, paramColumn);

            for (int col = paramColumn + 1; col < numberOfColumns; col++) {
                shiftDimension(null, col);
            }

            numberOfColumns--;
        }
    }

    /**
     * Método que funciona somente para matrizes quadradas.
     * @param paramRow Linha a ser deletada.
     * @param paramColumn Coluna a ser deletada.
     */
    public void removeRowColumn(Integer paramRow, Integer paramColumn) {
        if (validRow(paramRow) && validColumn(paramColumn) && paramRow.equals(paramColumn) && numberOfRows.equals(numberOfColumns)) {
            cleanDimension(paramRow, paramColumn);

            for (int dim = paramRow + 1; dim < numberOfRows && dim < numberOfColumns; dim++) {
                shiftDimension(dim, dim);
            }

            numberOfRows--;
            numberOfColumns--;
        }
    }

    private void cleanDimension(Integer paramRow, Integer paramColumn) {
        if (validRow(paramRow) && validColumn(paramColumn)) {
            for (int dim = 0; dim < numberOfRows && dim < numberOfColumns; dim++) {
                matriz.removeItem(new Cell(dim, paramColumn));
                matriz.removeItem(new Cell(paramRow, dim));
            }
        } else if (validRow(paramRow)) {
            for (int col = 0; col < numberOfColumns; col++) {
                matriz.removeItem(new Cell(paramRow, col));
            }
        } else if (validColumn(paramColumn)) {
            for (int row = 0; row < numberOfRows; row++) {
                matriz.removeItem(new Cell(row, paramColumn));
            }
        }
    }

    private void shiftDimension(Integer paramRow, Integer paramColumn) {

        if (validRow(paramRow) && validColumn(paramColumn)) {
            System.out.println("ENtrou aqui!");
            for (int dim = 0 ; dim < numberOfRows && dim < numberOfColumns; dim++) {
                add(paramRow - 1, dim, get(paramRow, dim));
                add(dim, paramColumn - 1, get(dim, paramColumn));
            }
        }

        else if (validRow(paramRow)) {
            for (int col = 0 ; col < numberOfColumns; col++) {
                add(paramRow - 1, col, get(paramRow, col));
            }
        }

        else if (validColumn(paramColumn)) {
            for (int row = 0 ; row < numberOfRows ; row++) {
                add(row, paramColumn - 1, get(row, paramColumn));
            }
        }

    }

    /**
     * Duas matrizes são iguais se tiver a mesma quantidade de linhas, a mesma quantidade de colunas e os valores das células correspondentes forem iguais.
     *
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
                    if (!matTwo.get(row, column).equals(this.get(row, column)))
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

        while ((line = buffReader.readLine()) != null && line.length() > 0 && line.charAt(0) == '%') ;

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

        for (Object cellObject : matriz.elements()) {
            Cell cell = (Cell) cellObject;
            Integer linha = cell.getI() + 1;
            Integer coluna = cell.getJ() + 1;
            Float elem = cell.getElem();

            fileWriter.write("\n" + linha + " " + coluna + " " + elem);
        }

        fileWriter.close();
    }
}

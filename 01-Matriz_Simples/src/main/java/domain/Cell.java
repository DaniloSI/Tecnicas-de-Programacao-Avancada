package domain;

/**
 * Created by 20142bsi0186 on 16/02/2017.
 */
public class Cell {
    private int row;
    private int column;
    private double value;

    public Cell() {}

    public Cell(int row, int column, double value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object paramCell) {
        if (paramCell instanceof Cell) {
            Cell cell = (Cell) paramCell;

            return cell.getRow() == this.row && cell.getColumn() == this.column && cell.getValue() == this.value;
        }

        return false;
    }
}

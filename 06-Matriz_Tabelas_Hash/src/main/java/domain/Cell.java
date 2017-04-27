package domain;

/**
 * Created by danilo on 24/04/17.
 */
public class Cell {
    private int i;
    private int j;
    private float elem;

    public Cell(int i, int j, float elem) {
        this.i = i;
        this.j = j;
        this.elem = elem;
    }

    public Cell(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public float getElem() {
        return elem;
    }

    public void setElem(float elem) {
        this.elem = elem;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Cell) {
            Cell cell = (Cell) object;

            return i == cell.getI() && j == cell.getJ();
        }

        return false;
    }
}

package hashTableMatriz;

import hashTable.HashEngine;

/**
 * Created by danilo on 24/04/17.
 */
public class HashEngineMat extends HashEngine {

    @Override
    public int hashCode(Object key) {
        int hashCode = 0;

        if (key instanceof Cell) {
            Cell cell = (Cell) key;

            hashCode = cell.getI() * 27;
            hashCode += cell.getJ();
        }

        return hashCode;
    }

}

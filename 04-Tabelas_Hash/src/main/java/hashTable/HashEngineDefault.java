package hashTable;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by danilo on 23/04/17.
 */
public class HashEngineDefault extends HashEngine {

    @Override
    public int hashCode(Object key) {
        byte[] bytes = null;
        int hashCode = 0;
        int base = 2;
        int expoente = 0;

        ByteArrayOutputStream bos;
        ObjectOutputStream oos;

        try {

            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(key);
            oos.flush();
            oos.close();
            bos.close();

            bytes = bos.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (key != null)
            expoente = bytes.length - 7;

        for (int i = 7 ; key != null && i < bytes.length ; i++) {
            hashCode += bytes[i] * Math.pow(base, expoente);
            expoente--;
        }

//        System.out.println(hashCode + " - " + key);

        return hashCode;
    }

}

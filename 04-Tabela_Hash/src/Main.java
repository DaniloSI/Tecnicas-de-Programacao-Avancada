import dicionario.Dicionario;

/**
 * Created by AEVO on 22/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        Dicionario<String, Integer> dicionario = new Dicionario<>();

        dicionario.insert("Danilo", 50);
        dicionario.insert("de", 75);
        dicionario.insert("Oliveira", 90);

        System.out.println(dicionario.keys());

        /*System.out.println(dicionario.find("Danilo"));

        dicionario.remove("Danilo");

        System.out.println(dicionario.size());

        System.out.println(dicionario.isEmpty());

        dicionario.remove("Oliveira");

        System.out.println(dicionario.isEmpty());*/


    }
}

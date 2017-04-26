/**
 * Created by danilo on 23/04/17.
 */
public class Main {

    public static void main(String[] args) {
        CorretorOrtografico corretorOrtografico = new CorretorOrtografico();

        String word = "Danilo";

        /*System.out.println(word.substring(0, 1));
        System.out.println(word.substring(1, 2));
        System.out.println(word.substring(2, 3));
        System.out.println(word.substring(3, 4));
        System.out.println(word.substring(4, 5));
        System.out.println(word.substring(5, 6));*/

        for (String nGrama: corretorOrtografico.calculaNGrama("Danilo")) {
            System.out.println(nGrama);
        }
    }
}

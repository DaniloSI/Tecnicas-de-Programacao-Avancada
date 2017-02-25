import org.junit.Before;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import testes.FileMatrixTeste;
import testes.MatrixTeste;

/**
 * Created by Danilo de Oliveira on 25/02/2017.
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        FileMatrixTeste.class,
        MatrixTeste.class
})
public class testeTotal {
}

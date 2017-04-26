import dicionario.Dicionario;
import dicionario.DicionarioBuilder;
import hashTable.HashEngineDefault;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

/**
 * Created by danilo on 06/04/17.
 */
public class TesteTabelaHashChain {
    private Dicionario<String, String> dicionario;

    @Before
    public void setDicionario() {
        dicionario = new DicionarioBuilder<String, String>()
                .setHashEngine(new HashEngineDefault())
                .setTipoTabelaHash(DicionarioBuilder.TipoTabelaHash.CHINING)
                .get();
    }

    @Test
    public void testeInserirRecuperar() throws Exception {
        dicionario.insert("Danilo", "156.228.747-85");
        assertEquals("156.228.747-85", dicionario.find("Danilo"));
        dicionario.remove("Danilo");
    }

    @Test
    public void testeKeysElements() {
        List<String> keys;
        List<String> elements;

        dicionario.insert("Danilo", "156");
        dicionario.insert("de", "228");
        dicionario.insert("Oliveira", "747-85");

        keys = dicionario.keys();
        elements = dicionario.elements();

        assertEquals(true, keys.contains("Danilo"));
        assertEquals(true, keys.contains("de"));
        assertEquals(true, keys.contains("Oliveira"));
        assertEquals(true, elements.contains("156"));
        assertEquals(true, elements.contains("228"));
        assertEquals(true, elements.contains("747-85"));

        dicionario.remove("Danilo");
        dicionario.remove("de");
        dicionario.remove("Oliveira");
    }

    @Test
    public void testeSize() {
        dicionario.insert("Danilo", "156");
        assertEquals(1, dicionario.size());

        dicionario.insert("de", "228");
        assertEquals(2, dicionario.size());

        dicionario.remove("Danilo");
        assertEquals(1, dicionario.size());

        dicionario.remove("de");
        assertEquals(0, dicionario.size());
    }

    @Test
    public void testeEditarItem() throws Exception {
        dicionario.insert("Danilo", "156");
        assertEquals("156", dicionario.find("Danilo"));

        dicionario.insert("Danilo", "228");
        assertEquals("228", dicionario.find("Danilo"));
    }

}

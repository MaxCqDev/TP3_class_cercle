package allumettes;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RapideTest {
	
    private static class JeuStub implements Jeu {
        private final int reste;
        JeuStub(int reste) { 
        	this.reste = reste; 
        	}
        public int getNombreAllumettes() { 
        	return this.reste; 
        	}
        public void retirer(int nb) {
        	
        }
    }

    private int prise(int reste) {
        return new Rapide().getPrise(new JeuStub(reste), "Test");
    }

    //test pour prendre le max
    @Test
    public void MaxAllumettes() {
        assertEquals(3, prise(13));
    }

    //test pour 3 2 1
    @Test
    public void MaxpourMax() {
        assertEquals(3, prise(3));
    }

    @Test
    public void RestemoinsMax() {
        assertEquals(2, prise(2));
    }

    @Test
    public void testPerdant() {
        assertEquals(1, prise(1));
    }
}
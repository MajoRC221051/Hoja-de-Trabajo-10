import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class GrafoTest {
    private Grafo grafo;

    @BeforeEach
    void setUp() {
        grafo = new Grafo(Arrays.asList("A", "B", "C", "D", "E"));
        grafo.agregarArco("A", "B", 3);
        grafo.agregarArco("A", "D", 7);
        grafo.agregarArco("B", "C", 1);
        grafo.agregarArco("B", "E", 8);
        grafo.agregarArco("C", "D", 2);
        grafo.agregarArco("D", "E", 3);
        grafo.agregarArco("E", "A", 4);
    }

    @Test
    void testAgregarYEliminarArco() {
        grafo.agregarArco("A", "C", 10);
        assertEquals(10, grafo.getMatrizAdyacencia()[0][2]);
        grafo.eliminarArco("A", "C");
        assertEquals(99999, grafo.getMatrizAdyacencia()[0][2]);
    }

    @Test
    void testFloydWarshall() {
        int[][] dist = grafo.floydWarshall();
        assertEquals(0, dist[0][0]); // A to A
        assertEquals(3, dist[0][1]); // A to B
        assertEquals(4, dist[0][2]); // A to C (A->B->C)
    }

    @Test
    void testCentroDelGrafo() {
        assertEquals("A", grafo.centroDelGrafo());
    }
}

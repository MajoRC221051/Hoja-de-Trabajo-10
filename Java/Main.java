import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Grafo grafo = new Grafo(Arrays.asList("A", "B", "C", "D", "E"));
        grafo.agregarArco("A", "B", 3);
        grafo.agregarArco("A", "D", 7);
        grafo.agregarArco("B", "C", 1);
        grafo.agregarArco("B", "E", 8);
        grafo.agregarArco("C", "D", 2);
        grafo.agregarArco("D", "E", 3);
        grafo.agregarArco("E", "A", 4);

        int[][] distancias = FloydWarshall.floyd(grafo.getMatriz());
        @SuppressWarnings("unused")
        int centro = FloydWarshall.calcularCentro(distancias);

        System.out.println("Centro del grafo: " + grafo.centroDelGrafo());
    }
}

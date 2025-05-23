import java.util.*;

public class Grafo {
    private final int INF = 99999;
    private final List<String> nodos;
    private int[][] matrizAdyacencia;

    public Grafo(List<String> nodos) {
        this.nodos = nodos;
        int n = nodos.size();
        matrizAdyacencia = new int[n][n];
        for (int[] fila : matrizAdyacencia)
            Arrays.fill(fila, INF);
        for (int i = 0; i < n; i++)
            matrizAdyacencia[i][i] = 0;
    }

    public void agregarArco(String origen, String destino, int peso) {
        int i = nodos.indexOf(origen);
        int j = nodos.indexOf(destino);
        if (i != -1 && j != -1) {
            matrizAdyacencia[i][j] = peso;
        }
    }

    public void eliminarArco(String origen, String destino) {
        int i = nodos.indexOf(origen);
        int j = nodos.indexOf(destino);
        if (i != -1 && j != -1) {
            matrizAdyacencia[i][j] = INF;
        }
    }

    public int[][] floydWarshall() {
        int n = matrizAdyacencia.length;
        int[][] dist = new int[n][n];
        for (int i = 0; i < n; i++)
            dist[i] = Arrays.copyOf(matrizAdyacencia[i], n);

        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return dist;
    }

    public String centroDelGrafo() {
        int[][] dist = floydWarshall();
        int n = dist.length;
        int centro = 0;
        int minEccentricidad = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                if (dist[i][j] > max)
                    max = dist[i][j];
            }
            if (max < minEccentricidad) {
                minEccentricidad = max;
                centro = i;
            }
        }
        return nodos.get(centro);
    }

    public int[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public int[][] getMatriz() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getMatriz'");
    }
}

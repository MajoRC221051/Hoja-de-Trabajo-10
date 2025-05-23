public class FloydWarshall {

    public static int[][] floyd(int[][] matriz) {
        int n = matriz.length;
        int[][] dist = new int[n][n];

        // Copiar matriz original
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                dist[i][j] = matriz[i][j];

        // Algoritmo Floyd
        for (int k = 0; k < n; k++)
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++)
                    if (dist[i][k] + dist[k][j] < dist[i][j])
                        dist[i][j] = dist[i][k] + dist[k][j];

        return dist;
    }

    public static int calcularCentro(int[][] dist) {
        int n = dist.length;
        int centro = -1;
        int minEcc = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int ecc = 0;
            for (int j = 0; j < n; j++)
                ecc = Math.max(ecc, dist[i][j]);

            if (ecc < minEcc) {
                minEcc = ecc;
                centro = i;
            }
        }

        return centro;
    }

    {

    }
}

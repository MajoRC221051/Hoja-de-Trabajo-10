import networkx as nx

def construir_grafo():
    G = nx.DiGraph()
    # Agregar aristas con pesos
    G.add_weighted_edges_from([
        ("A", "B", 3),
        ("A", "D", 7),
        ("B", "C", 1),
        ("B", "E", 8),
        ("C", "D", 2),
        ("D", "E", 3),
        ("E", "A", 4),
    ])
    return G

def floyd_warshall_y_centro(G):
    # Algoritmo de Floyd-Warshall de NetworkX
    distancias = dict(nx.floyd_warshall(G))

    print("Matriz de distancias más cortas:")
    for origen in distancias:
        for destino in distancias[origen]:
            print(f"{origen} -> {destino}: {distancias[origen][destino]}")

    # Calcular excentricidad para cada nodo
    excentricidades = {nodo: max(distancias[nodo].values()) for nodo in G.nodes}
    centro = min(excentricidades, key=excentricidades.get)

    print(f"\nCentro del grafo: {centro}")
    return centro

# Ejecución
if __name__ == "__main__":
    G = construir_grafo()
    floyd_warshall_y_centro(G)


import java.util.*;

class Dikjstra {

    // Function to implement Dijkstra's Algorithm
    public static void dijkstra(int V, List<List<Node>> graph, int source) {
        int[] dist = new int[V];  // shortest distances
        Arrays.fill(dist, Integer.MAX_VALUE); 
        dist[source] = 0;

        // Min-Heap based on distance
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.vertex;

            for (Node edge : graph.get(u)) {
                int v = edge.vertex;
                int weight = edge.cost;

                // Relaxation Step
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }

        // Print shortest distances
        System.out.println("Shortest distances from source " + source + ":");
        for (int i = 0; i < V; i++) {
            System.out.println("To node " + i + " = " + dist[i]);
        }
    }

    // Node structure
    static class Node {
        int vertex, cost;
        Node(int v, int c) {
            this.vertex = v;
            this.cost = c;
        }
    }

    public static void main(String[] args) {

        int V = 5; // number of nodes

        // adjacency list
        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());

        // --- Sample Graph ---
        // 0 -> 1 (4)
        // 0 -> 2 (1)
        // 2 -> 1 (2)
        // 1 -> 3 (1)
        // 2 -> 3 (5)
        // 3 -> 4 (3)

        graph.get(0).add(new Node(1, 4));
        graph.get(0).add(new Node(2, 1));

        graph.get(2).add(new Node(1, 2));
        graph.get(2).add(new Node(3, 5));

        graph.get(1).add(new Node(3, 1));

        graph.get(3).add(new Node(4, 3));

        dijkstra(V, graph, 0); // source node = 0
    }
}

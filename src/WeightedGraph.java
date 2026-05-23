import java.util.Arrays;
import java.util.LinkedList;

public class WeightedGraph {
    private final int V;
    private final LinkedList<Edge>[] adj;

    @SuppressWarnings("unchecked")
    public WeightedGraph(int vertices) {
        this.V = vertices;
        this.adj = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest, double weight) {
        Edge edge = new Edge(source, dest, weight);
        adj[source].add(edge);
    }

    public void dijkstra(int start) {
        double[] dist = new double[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(dist, Double.MAX_VALUE);
        dist[start] = 0;

        for (int count = 0; count < V; count++) {
            int u = findMinDistanceVertex(dist, visited);

            if (u == -1 || dist[u] == Double.MAX_VALUE) {
                break;
            }

            visited[u] = true;

            for (Edge edge : adj[u]) {
                int v = edge.dest;
                double weight = edge.weight;

                if (!visited[v] && dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                }
            }
        }

        printShortestPaths(start, dist);
    }

    private int findMinDistanceVertex(double[] dist, boolean[] visited) {
        double min = Double.MAX_VALUE;
        int minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!visited[v] && dist[v] < min) {
                min = dist[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    private void printShortestPaths(int start, double[] dist) {
        System.out.println("====================================================");
        System.out.println("       DIJKSTRA'S SHORTEST PATH RESULTS             ");
        System.out.println("====================================================");
        System.out.println("Starting Vertex Source Point: " + start);
        System.out.println("----------------------------------------------------");
        System.out.printf("%-20s %-20s%n", "Destination Vertex", "Shortest Distance");
        System.out.println("----------------------------------------------------");

        for (int i = 0; i < V; i++) {
            String distanceOutput = (dist[i] == Double.MAX_VALUE) ? "Infinity (Unreachable)" : String.valueOf(dist[i]);
            System.out.printf("%-20d %-20s%n", i, distanceOutput);
        }
        System.out.println("====================================================");
    }
}

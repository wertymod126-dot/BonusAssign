import java.util.LinkedList;
import java.util.Arrays;
public class main {
    public static void main(String[] args) {
        WeightedGraph graph = new WeightedGraph(5);

        graph.addEdge(0, 1, 4.0);
        graph.addEdge(0, 2, 2.0);
        graph.addEdge(1, 2, 3.0);
        graph.addEdge(1, 3, 2.0);
        graph.addEdge(1, 4, 3.0);
        graph.addEdge(2, 1, 1.0);
        graph.addEdge(2, 3, 4.0);
        graph.addEdge(2, 4, 5.0);
        graph.addEdge(3, 4, 1.0);

        graph.dijkstra(0);
    }
}
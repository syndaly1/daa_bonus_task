package algo;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    int vertices;
    List<Edge> edges = new ArrayList<>();

    public Graph(int vertices) {
        this.vertices = vertices;
    }

    public void addEdge(int u, int v, int weight) {
        edges.add(new Edge(u, v, weight));
    }

    public List<Edge> getEdges() {
        return edges;
    }
}

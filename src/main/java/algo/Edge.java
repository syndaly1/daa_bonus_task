package algo;

public class Edge {
    int u;
    int v;
    int weight;

    public Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return u + " - " + v + " (w=" + weight + ")";
    }
}

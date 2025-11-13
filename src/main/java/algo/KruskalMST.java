package algo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KruskalMST {

    public List<Edge> buildMST(Graph graph) {
        List<Edge> sorted = new ArrayList<>(graph.getEdges());
        sorted.sort(Comparator.comparingInt(e -> e.weight));

        DSU dsu = new DSU(graph.vertices);
        List<Edge> mst = new ArrayList<>();

        for (Edge e : sorted) {
            if (dsu.union(e.u, e.v)) {
                mst.add(e);
            }
        }

        return mst;
    }
}

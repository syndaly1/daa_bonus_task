package algo;

import java.util.Set;

public class ReplacementEdgeFinder {

    public Edge findReplacement(Graph graph, Set<Integer> compA, Set<Integer> compB) {
        Edge best = null;

        for (Edge e : graph.getEdges()) {

            boolean connectsAB =
                    (compA.contains(e.u) && compB.contains(e.v)) ||
                            (compA.contains(e.v) && compB.contains(e.u));

            if (connectsAB) {
                if (best == null || e.weight < best.weight) {
                    best = e;
                }
            }
        }

        return best;
    }
}

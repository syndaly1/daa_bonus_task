package algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    private static int calculateWeight(List<Edge> edges) {
        int sum = 0;
        for (Edge e : edges) {
            sum += e.weight;
        }
        return sum;
    }
    public static void main(String[] args) {

        Graph graph = new Graph(7);

        graph.addEdge(0, 1, 7);
        graph.addEdge(0, 3, 5);
        graph.addEdge(1, 2, 8);
        graph.addEdge(1, 3, 9);
        graph.addEdge(1, 4, 7);
        graph.addEdge(2, 4, 5);
        graph.addEdge(3, 4, 15);
        graph.addEdge(3, 5, 6);
        graph.addEdge(4, 5, 8);
        graph.addEdge(4, 6, 9);
        graph.addEdge(5, 6, 11);

        KruskalMST kruskal = new KruskalMST();
        List<Edge> mst = kruskal.buildMST(graph);

        System.out.println("Initial MST:");
        mst.forEach(System.out::println);
        System.out.println("Weight: " + calculateWeight(mst));

        Edge removed = mst.get(2);
        mst.remove(removed);

        System.out.println("\nRemoved edge: " + removed);

        ConnectedComponents cc = new ConnectedComponents();

        Set<Integer> compA = cc.getComponent(removed.u, mst);
        Set<Integer> compB = cc.getComponent(removed.v, mst);

        System.out.println("\nComponents after removal:");
        System.out.println("Component A: " + compA);
        System.out.println("Component B: " + compB);

        System.out.println("\nCandidate edges that reconnect components:");
        List<Edge> candidates = new ArrayList<>();

        for (Edge e : graph.getEdges()) {
            boolean connects =
                    (compA.contains(e.u) && compB.contains(e.v)) ||
                            (compA.contains(e.v) && compB.contains(e.u));
            if (connects) {
                candidates.add(e);
            }
        }
        candidates.forEach(System.out::println);

        ReplacementEdgeFinder ref = new ReplacementEdgeFinder();
        Edge replacement = ref.findReplacement(graph, compA, compB);

        System.out.println("\nReplacement edge:");
        System.out.println(replacement);

        mst.add(replacement);

        System.out.println("\nNew MST:");
        mst.forEach(System.out::println);
        System.out.println("Weight: " + calculateWeight(mst));
    }
}

package algo;

import java.util.*;

public class ConnectedComponents {

    public Set<Integer> getComponent(int start, List<Edge> mstEdges) {
        Set<Integer> visited = new HashSet<>();
        Map<Integer, List<Integer>> adj = new HashMap<>();

        for (Edge e : mstEdges) {
            adj.computeIfAbsent(e.u, k -> new ArrayList<>()).add(e.v);
            adj.computeIfAbsent(e.v, k -> new ArrayList<>()).add(e.u);
        }

        explore(start, visited, adj);
        return visited;
    }

    private void explore(int node, Set<Integer> visited, Map<Integer, List<Integer>> adj) {
        visited.add(node);

        if (!adj.containsKey(node)) {
            return;
        }

        for (int next : adj.get(node)) {
            if (!visited.contains(next)) {
                explore(next, visited, adj);
            }
        }
    }
}

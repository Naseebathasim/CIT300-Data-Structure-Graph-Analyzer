import java.util.*;

/**
 * Graph.java
 * Adjacency-list graph (directed or undirected) with basic operations.
 * Author: Mifra (23DA2-0833) - graph-performance
 */
public class Graph {
    private final Map<Integer, List<Integer>> adj = new HashMap<>();
    private final boolean directed;
    private int edgeCount = 0;

    public Graph(boolean directed) {
        this.directed = directed;
    }

    public Graph() {
        this(false);
    }

    // ---------- Building the graph ----------
    public void addVertex(int v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    public void addEdge(int u, int v) {
        addVertex(u);
        addVertex(v);
        if (adj.get(u).contains(v)) return; // ignore duplicate edges
        adj.get(u).add(v);
        if (!directed) adj.get(v).add(u);
        edgeCount++;
    }

    public void removeEdge(int u, int v) {
        if (!adj.containsKey(u) || !adj.containsKey(v)) return;
        if (adj.get(u).remove((Integer) v)) {
            if (!directed) adj.get(v).remove((Integer) u);
            edgeCount--;
        }
    }

    public void removeVertex(int v) {
        if (!adj.containsKey(v)) return;
        for (int u : new ArrayList<>(adj.get(v))) removeEdge(v, u);
        if (directed) {
            for (int u : adj.keySet()) removeEdge(u, v);
        }
        adj.remove(v);
    }

    // ---------- Queries ----------
    public boolean hasVertex(int v) {
        return adj.containsKey(v);
    }

    public boolean hasEdge(int u, int v) {
        return adj.containsKey(u) && adj.get(u).contains(v);
    }

    public int vertexCount() {
        return adj.size();
    }

    public int edgeCount() {
        return edgeCount;
    }

    public boolean isDirected() {
        return directed;
    }

    public Set<Integer> vertices() {
        return adj.keySet();
    }

    public List<Integer> neighbors(int v) {
        return adj.getOrDefault(v, Collections.emptyList());
    }

    public int degree(int v) {
        return neighbors(v).size();
    }

    // ---------- Traversals ----------
    public List<Integer> bfs(int start) {
        List<Integer> order = new ArrayList<>();
        if (!hasVertex(start)) return order;
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new ArrayDeque<>();
        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            order.add(v);
            for (int n : adj.get(v)) {
                if (visited.add(n)) queue.add(n);
            }
        }
        return order;
    }

    public List<Integer> dfs(int start) {
        List<Integer> order = new ArrayList<>();
        if (!hasVertex(start)) return order;
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited.add(v)) continue;
            order.add(v);
            List<Integer> ns = adj.get(v);
            for (int i = ns.size() - 1; i >= 0; i--) {
                if (!visited.contains(ns.get(i))) stack.push(ns.get(i));
            }
        }
        return order;
    }

    /** Shortest path (fewest edges) from src to dst using BFS. Empty list if none. */
    public List<Integer> shortestPath(int src, int dst) {
        if (!hasVertex(src) || !hasVertex(dst)) return Collections.emptyList();
        Map<Integer, Integer> parent = new HashMap<>();
        Queue<Integer> queue = new ArrayDeque<>();
        parent.put(src, null);
        queue.add(src);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            if (v == dst) break;
            for (int n : adj.get(v)) {
                if (!parent.containsKey(n)) {
                    parent.put(n, v);
                    queue.add(n);
                }
            }
        }
        if (!parent.containsKey(dst)) return Collections.emptyList();
        LinkedList<Integer> path = new LinkedList<>();
        for (Integer at = dst; at != null; at = parent.get(at)) path.addFirst(at);
        return path;
    }

    /** Number of connected components (treats edges as undirected for directed graphs). */
    public int connectedComponents() {
        Map<Integer, List<Integer>> und = new HashMap<>();
        for (int v : adj.keySet()) und.putIfAbsent(v, new ArrayList<>());
        for (int v : adj.keySet())
            for (int n : adj.get(v)) {
                und.get(v).add(n);
                und.get(n).add(v);
            }
        Set<Integer> visited = new HashSet<>();
        int count = 0;
        for (int s : und.keySet()) {
            if (visited.contains(s)) continue;
            count++;
            Deque<Integer> stack = new ArrayDeque<>();
            stack.push(s);
            while (!stack.isEmpty()) {
                int v = stack.pop();
                if (!visited.add(v)) continue;
                for (int n : und.get(v)) if (!visited.contains(n)) stack.push(n);
            }
        }
        return count;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Integer, List<Integer>> e : new TreeMap<>(adj).entrySet()) {
            sb.append(e.getKey()).append(" -> ").append(e.getValue()).append('\n');
        }
        return sb.toString();
    }
}

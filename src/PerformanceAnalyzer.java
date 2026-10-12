import java.util.*;

/**
 * PerformanceAnalyzer.java
 * Measures running time of Graph operations on random graphs of growing size.
 * Author: Mifra (23DA2-0833) - graph-performance
 */
public class PerformanceAnalyzer {

    private static final long SEED = 42L;

    /** Builds a random connected-ish graph with n vertices and about n*avgDegree/2 edges. */
    public static Graph buildRandomGraph(int n, int avgDegree, boolean directed) {
        Random rnd = new Random(SEED);
        Graph g = new Graph(directed);
        for (int i = 0; i < n; i++) g.addVertex(i);
        // chain first so the graph is connected
        for (int i = 1; i < n; i++) g.addEdge(i - 1, i);
        long extra = (long) n * Math.max(avgDegree - 2, 0) / 2;
        for (long k = 0; k < extra; k++) {
            g.addEdge(rnd.nextInt(n), rnd.nextInt(n));
        }
        return g;
    }

    /** Runs a task and returns elapsed time in milliseconds (best of several runs). */
    private static double timeMs(Runnable task, int runs) {
        long best = Long.MAX_VALUE;
        for (int i = 0; i < runs; i++) {
            long t0 = System.nanoTime();
            task.run();
            best = Math.min(best, System.nanoTime() - t0);
        }
        return best / 1_000_000.0;
    }

    public static void analyze(int[] sizes, int avgDegree) {
        System.out.printf("%-8s %-8s %-12s %-10s %-10s %-12s %-12s%n",
                "V", "E", "Build(ms)", "BFS(ms)", "DFS(ms)", "ShortPath(ms)", "Components(ms)");
        System.out.println("-".repeat(80));

        for (int n : sizes) {
            final Graph[] holder = new Graph[1];
            double build = timeMs(() -> holder[0] = buildRandomGraph(n, avgDegree, false), 3);
            Graph g = holder[0];

            double bfs = timeMs(() -> g.bfs(0), 5);
            double dfs = timeMs(() -> g.dfs(0), 5);
            double sp = timeMs(() -> g.shortestPath(0, n - 1), 5);
            double cc = timeMs(g::connectedComponents, 5);

            System.out.printf("%-8d %-8d %-12.3f %-10.3f %-10.3f %-13.3f %-12.3f%n",
                    g.vertexCount(), g.edgeCount(), build, bfs, dfs, sp, cc);
        }
    }

    public static void main(String[] args) {
        int[] sizes = {100, 500, 1000, 5000, 10000};
        System.out.println("Graph Performance Analysis (avg degree = 6)\n");
        analyze(sizes, 6);
    }
}

import java.util.*;
import java.io.*;

public class GetShortyDijkstra {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);


        while (true) {

            String[] line = in.nextLine().split(" +");
            int n = Integer.valueOf(line[0]);
            int e = Integer.valueOf(line[1]);

            if (n == 0 && e == 0)
                break;

            // Read in edges
            Map<Integer, List<Edge_Dijkstra>> edges = new HashMap<>();
            for (int i = 0; i < e; i++) {
                line = in.nextLine().split(" +");
                int u = Integer.valueOf(line[0]);
                int v = Integer.valueOf(line[1]);
                double w = Double.valueOf(line[2]);
                addEdge(edges, u, v, w);
                addEdge(edges, v, u, w);
            }

            System.out.printf("%.4f\n", dijkstra(edges, n, 0, n - 1));

        }

    }

    // Helper method to add an edge to the adjacency lists
    private static void addEdge(Map<Integer, List<Edge_Dijkstra>> edges, int u, int v, double w) {

        if (!edges.containsKey(u))
            edges.put(u, new ArrayList<>());

        edges.get(u).add(new Edge_Dijkstra(v, w));

    }

    private static Double dijkstra(Map<Integer, List<Edge_Dijkstra>> edges, int n, int s, int e) {

        Double val[] = new Double[n];
        PriorityQueue<Node> q = new PriorityQueue<>();
        q.offer(new Node(s, 1.0));
        val[s] = 1.0;

        while (!q.isEmpty()) {
            Node node = q.poll();
            if (val[node.index] < node.val || !edges.containsKey(node.index)) continue;
            List<Edge_Dijkstra> node_edges = edges.get(node.index);
            for (Edge_Dijkstra edge: node_edges) {
                double newVal = val[node.index] * edge.weight;
                if (val[edge.to] != null) {
                    if (newVal > val[edge.to]) {
                        val[edge.to] = newVal;
                        q.offer(new Node(edge.to, newVal));
                    }
                } else {
                    val[edge.to] = newVal;
                    q.offer(new Node(edge.to, newVal));
                }
            }
        }

        return val[e];

    }

}

class Node implements Comparable < Node > {
    int index;
    double val;
    Node(int index, double val) {
        this.index = index;
        this.val = val;
    }
    @Override public int compareTo(Node other) {
        return -Double.compare(val, other.val);
    }
}

class Edge_Dijkstra {
    int to;
    double weight;
    Edge_Dijkstra(int v, double w) {
        to = v;
        weight = w;
    }
}
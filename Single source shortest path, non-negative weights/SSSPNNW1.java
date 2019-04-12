import java.util.*;
import java.io.*;
import static java.lang.Math.*;

class Edge2 {
    int from, to, weight;
    public Edge2(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class SSSPNNW1 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static Double[] bellman_ford(HashMap < Integer, List<Edge2>> Edge2s, int n, int s) {

        Double[] dist = new Double[n];
        Arrays.fill(dist, Double.POSITIVE_INFINITY);
        dist[s] = 0.0;

        // int[] prev = new int[n]; // Tracks best parent nodes
        // Arrays.fill(prev, -1);

        for (int i = 0; i < n - 1; i++) {
            for (int from = 0; from < n; from++) {
                List<Edge2> Edge2List = Edge2s.get(from);
                if (Edge2List != null && dist[from] != Double.POSITIVE_INFINITY) {
                    for (int j = 0; j < Edge2List.size(); j++) {
                        Edge2 Edge2 = Edge2List.get(j);
                        int weight = Edge2.weight;
                        int to = Edge2.to;
                        if (dist[to] == Double.POSITIVE_INFINITY) {
                            dist[to] = weight + dist[from];
                        } else if (weight + dist[from] < dist[to]) {
                            dist[to] = weight + dist[from];
                            // prev[to] = from; // Track best parent
                        }
                    }
                }
            }
        }

        // Re-run bellman ford identifying negative cycles
        for (int from = 0; from < n; from++) {
            List<Edge2> Edge2List = Edge2s.get(from);
            if (Edge2List != null && dist[from] != Double.POSITIVE_INFINITY) {
                for (int j = 0; j < Edge2List.size(); j++) {
                    Edge2 Edge2 = Edge2List.get(j);
                    int weight = Edge2.weight;
                    int to = Edge2.to;
                    if (weight + dist[from] < dist[to]) {

                        dist[to] = Double.NEGATIVE_INFINITY;
                        // prev[to] = from; // Track best parent 

                        // We found a negative cycle so try to spread the 
                        // negativeness everywhere, like a disease using BFS!
                        boolean[] visited = new boolean[n];
                        Queue<Integer> q = new LinkedList < > ();
                        q.offer(from);
                        while (!q.isEmpty()) {
                            int _from = q.poll();
                            List<Edge2> _Edge2s = Edge2s.get(_from);
                            if (_Edge2s != null) {
                                for (Edge2 _Edge2: _Edge2s) {
                                    int _to = _Edge2.to;
                                    if (!visited[_to]) {
                                        q.offer(_to);
                                        visited[_to] = true;
                                        if (dist[_from] == Double.NEGATIVE_INFINITY) {
                                            dist[_to] = Double.NEGATIVE_INFINITY;
                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
        }

        // or return 'prev' if you need that
        return dist;

    }

    public static void main(String[] args) throws IOException {

        String line[] = br.readLine().split(" ");
        int N = Integer.valueOf(line[0]);
        int M = Integer.valueOf(line[1]);
        int Q = Integer.valueOf(line[2]);
        int S = Integer.valueOf(line[3]);

        HashMap < Integer, List<Edge2>> adj_list = new HashMap < > ();

        while (!(N == 0 && M == 0 && Q == 0 && S == 0)) {

            adj_list.clear();
            int u, v, w, q;

            for (int i = 0; i < M; i++) {

                line = br.readLine().split(" ");
                u = Integer.valueOf(line[0]);
                v = Integer.valueOf(line[1]);
                w = Integer.valueOf(line[2]);

                Edge2 newEdge2 = new Edge2(u, v, w);
                if (adj_list.containsKey(u)) {
                    adj_list.get(u).add(newEdge2);
                } else {
                    LinkedList<Edge2> list = new LinkedList<>();
                    list.add(newEdge2);
                    adj_list.put(u, list);
                }

            }

            Double[] dist = bellman_ford(adj_list, N, S);

            for (int i = 0; i < Q; i++) {

                q = Integer.valueOf(br.readLine());

                if (dist[q] == Double.POSITIVE_INFINITY) {
                    System.out.println("Impossible");
                } else if (dist[q] == Double.NEGATIVE_INFINITY) {
                    System.out.println("-Infinity");
                } else {
                    System.out.println((int) dist[q].doubleValue());
                }

            }

            line = br.readLine().split(" ");
            N = Integer.valueOf(line[0]);
            M = Integer.valueOf(line[1]);
            Q = Integer.valueOf(line[2]);
            S = Integer.valueOf(line[3]);

            if (!(N == 0 && M == 0 && Q == 0 && S == 0))
                System.out.println();

        }
    }
}
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


class Edge{
    int from, to, weight;
    public Edge(int f, int t, int w){
        from = f;
        to = t;
        weight = w;
    }
}

public class SSSPNNW2 {

    static final int INFINITY = Integer.MAX_VALUE/2;

    private static int[] bellmanFord(Edge[] edges, int V, int startingV) {
        int[] dist = new int[V];

        for (int i = 0; i < V; i++){
            dist[i] = INFINITY;
        }

        dist[startingV] = 0;

        for (int v = 0; v < V-1; v++) {
            boolean changed = false;
            for (Edge edge : edges) {

                if (dist[edge.from] + edge.weight < dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] + edge.weight;
                    changed = true;
                }
            }

            if (!changed) return dist;
        }
        return dist;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(new File(args[0]));

        while (in.hasNext()) {

            int n = in.nextInt();
            int m = in.nextInt();
            int q = in.nextInt();
            int s = in.nextInt();
            //in.nextLine();

            if (n==0&&m==0&&q==0&&s==0) return;

            Edge[] edges = new Edge[m];

            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                int w = in.nextInt();
                in.nextLine();

                edges[i] = new Edge(u, v, w);
            }

            int[] arrays = bellmanFord(edges, n,s);

            for (int i = 0; i < q; i++) {
                int distTo = in.nextInt();
                calcDistance(distTo, s, arrays);
            }
            System.out.println();

        }
    }

    private static void calcDistance(int distTo, int start, int[] arrays) {
        if (arrays[distTo]>= INFINITY || arrays[start] >= INFINITY){
            System.out.println("Impossible");
        }else {
            System.out.println(arrays[distTo] - arrays[start]);
        }
    }


}

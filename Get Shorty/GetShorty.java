import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Edges{
    int from, to;
    double weight;
    Edges(int f, int t, double w){
        from = f;
        to = t;
        weight = w;
    }
}

public class GetShorty {

    //private static final int INFINITY = 0;//Integer.MAX_VALUE/2;

    private static double[] bellmanFord(Edges[] edges, int V) {
        double[] dist = new double[V];

      /*  for (int i = 0; i < V; i++){
            dist[i] = INFINITY;
        }
*/
        dist[0] = 1;

        for (int v = 0; v < V-1; v++) {
            boolean changed = false;
            for (Edges edge : edges) {

                if (dist[edge.from] * edge.weight > dist[edge.to]) {
                    dist[edge.to] = dist[edge.from] * edge.weight;
                    changed = true;
                }
            }

            if (!changed) return dist;
        }
        return dist;
    }

    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {

            int V = in.nextInt();
            int E = in.nextInt();

            if (V==0 && E==0){
                return;
            }

            Edges[] edges = new Edges[E*2];

            for (int i = 0; i < E; i++) {
                int x = in.nextInt();
                int y = in.nextInt();
                double f = in.nextDouble();

                edges[i] = new Edges(x,y,f);
                edges[i+E] = new Edges(y,x,f);

            }
            double[] arrays = bellmanFord(edges, V);
            double ans = arrays[V-1];
            System.out.printf("%.4f\n", ans);
        }
    }
}

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;


public class PickUpSticks {

    public static ArrayList<Integer> toPrint = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public static void main(String[] args) throws FileNotFoundException {

        Scanner in = new Scanner(System.in);

        int numOfSticks = in.nextInt();
        int numOfLines = in.nextInt();

        LinkedList<Integer>[] linkedLists = new LinkedList[numOfSticks+numOfLines];

        for (int i = 1; i <= numOfSticks; i++) {
            linkedLists[i] = new LinkedList<>();
        }

        int u;
        int v;

        boolean[] loopDetect = new boolean[numOfSticks+numOfLines];
        boolean[] isVisited = new boolean[numOfSticks + 1];
        boolean hasLoop = false;

        StringBuilder stringBuilder = new StringBuilder();

        while (in.hasNext()) {
            u = in.nextInt();
            v = in.nextInt();
            linkedLists[u].add(v);
            loopDetect[v] = true;
        }

        for (int i = 1; i < numOfSticks && !hasLoop; i++) {
            hasLoop = (!loopDetect[i]);

            if (!loopDetect[i]) {
                topologicalSort(i, isVisited, linkedLists);
            }

        }

        if (!hasLoop) {
            System.out.println("IMPOSSIBLE");
        } else {
            for (int i = toPrint.size()-1; i>=0; i--) {
                stringBuilder.append(toPrint.get(i) + "\n");
            }
            System.out.print(stringBuilder);
        }
    }


    private static void topologicalSort(int vertex, boolean[] isVisited, LinkedList<Integer>[] linkedLists) {
        if (!isVisited[vertex]) {
            isVisited[vertex]=true;
            if (linkedLists[vertex]!=null) {

                for (Integer neighbour : linkedLists[vertex]) {
                    topologicalSort(neighbour, isVisited, linkedLists);
                }

            }
            toPrint.add(vertex);
        }
    }
}

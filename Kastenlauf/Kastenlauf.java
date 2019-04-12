
import java.util.Scanner;
import java.util.Stack;

import static java.lang.Math.abs;


public class Kastenlauf {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        
        int testCases = in.nextInt();

        while (testCases!=0) {

            // Initialize a stack
            Stack<Integer> dfsStack = new Stack<>();
            // add the first element
            dfsStack.add(0);

            int totalVertices = in.nextInt() + 2;

            // create a testcase object
            TestCase testCase = new TestCase(totalVertices);

            // populate the testcase object with the correct coordinates
            for (int i = 0; i < totalVertices; i++) {
                testCase.xCords[i] = in.nextInt();
                testCase.yCords[i] = in.nextInt();
            }

            // DFS algorithm implemented using stacks.
            while (!dfsStack.isEmpty()){
                int p = dfsStack.pop();
                if (!testCase.visited[p]){
                    testCase.visited[p] = true;
                    for (int i = 0; i < totalVertices ; i++) {
                        if (p != i){
                            if (abs(testCase.xCords[p] - testCase.xCords[i]) + abs(testCase.yCords[p] - testCase.yCords[i]) <= 1000){
                                dfsStack.add(i);
                            }
                        }
                    }
                }
            }

            if (testCase.visited[totalVertices-1]) System.out.println("happy");
            else System.out.println("sad");
            testCases--;
        }
    }

    public static class TestCase{
        // fields for x,y coordinates and visited array
        int[] xCords, yCords;
        boolean[] visited;

        public TestCase(int N){
            // initial the size based off graph vertices
            xCords = new int[N];
            yCords = new int[N];
            visited = new boolean[N];
        }
    }

}



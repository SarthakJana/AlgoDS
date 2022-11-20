package graph;

import java.util.*;

public class MonkAndIslands {
    public static int findMinimumBridges(int nodes, ArrayList<LinkedList<Integer>> adjGraph, int src) {
        int[] visited = new int[nodes];
        int[] distance = new int[nodes];

        for (int i = 0; i < nodes; i++) {
            visited[i] = 0;
            distance[i] = 0;
        }

        visited[0] = 1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);

        while (!queue.isEmpty()) {
            int curr = queue.poll();

            for (int i = 0; i < adjGraph.get(curr).size(); i++) {
                int adj = adjGraph.get(curr).get(i);
                if (visited[adj] == 0) {
                    visited[adj] = 1;
                    queue.add(adj);
                    distance[adj] = distance[curr] + 1;
                }
            }
        }

        return distance[nodes - 1];
    }

    public static void main(String args[]) throws Exception {

        //Scanner
        Scanner s = new Scanner(System.in);
        int testCases = s.nextInt();

        while (testCases > 0) {
            int n = s.nextInt();
            int m = s.nextInt();

            ArrayList<LinkedList<Integer>> adjGraph = new ArrayList<LinkedList<Integer>>();

            for (int i = 0; i < n; i++) {
                adjGraph.add(new LinkedList<Integer>());
            }

            while (m > 0) {
                int x = s.nextInt();
                int y = s.nextInt();


                adjGraph.get(x - 1).add(y - 1);
                adjGraph.get(y - 1).add(x - 1);

                m--;
            }

            System.out.println(findMinimumBridges(n, adjGraph, 0));
            testCases--;
        }
    }


}

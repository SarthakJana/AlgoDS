package graph;

import java.util.*;

public class SubTreeSize {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
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

        calculateSubtreeSize(adjGraph, n);
    }

    private static void calculateSubtreeSize(ArrayList<LinkedList<Integer>> adjGraph, int nodes) {
        int[] subTreeSize = new int[nodes];

        for (int i = nodes/2 + 1; i < nodes; i++) {
            subTreeSize[i] = 1;
        }

        for (int i = nodes/2; i >= 0; i--) {
            for (int j = 0; j < adjGraph.get(i).size(); j++) {
                int node = adjGraph.get(i).get(j);

                if (subTreeSize[node] != 0) {
                    subTreeSize[i] += subTreeSize[node];
                }
            }

            subTreeSize[i] = subTreeSize[i] + 1;
        }

        System.out.println(Arrays.toString(subTreeSize));
    }
}

package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DiameterOfTree {

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

        System.out.println("Diameter of tree: " + calculateDiameterOfTree(adjGraph, n));
    }

    private static int calculateDiameterOfTree(ArrayList<LinkedList<Integer>> adjGraph, int n) {
        int x = dfs(adjGraph, n, 0, false);

        return dfs(adjGraph, n, x, true);
    }

    private static int dfs(ArrayList<LinkedList<Integer>> adjGraph, int nodes, int src, boolean isDiameter) {
        int[] visited = new int[nodes];
        int[] distance = new int[nodes];
        int maxDistantNode = -1;
        int maxDistance = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();

        stack.push(src);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();

            if (visited[currNode] == 0) {
                visited[currNode] = 1;
            }

            for (int i = 0; i < adjGraph.get(currNode).size(); i++) {
                int node = adjGraph.get(currNode).get(i);

                if (visited[node] == 0) {
                    stack.push(node);
                    distance[node] = distance[currNode] + 1;
                }
            }

            for (int i = 0; i < distance.length; i++) {
                if (distance[i] > maxDistance) {
                    maxDistance = distance[i];
                    maxDistantNode = i;
                }
            }


        }

        return isDiameter ? maxDistance : maxDistantNode;
    }
}

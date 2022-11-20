package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class SingleSourceShortestPath {
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

        depthFirstSearch(adjGraph, n, 0);
    }

    private static void depthFirstSearch(ArrayList<LinkedList<Integer>> adjGraph, int n, int src) {
        int[] visited = new int[n];
        int[] distance = new int[n];

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
        }

        int minDistance = Integer.MAX_VALUE;
        int minDistanceNode = 0;

        for (int i = 1; i < distance.length; i++) {
            if (distance[i] < minDistance) {
                minDistance = distance[i];
                minDistanceNode = i;
            }
        }

        System.out.println("Nearest Node is " + (minDistanceNode + 1) + " at a distance of " + minDistance);
    }
}

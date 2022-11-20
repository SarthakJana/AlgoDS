package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CountConnectedComponents {

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

        System.out.println("No. of connected components: " + findConnectedComponents(n, adjGraph));
    }

    private static int findConnectedComponents(int n, ArrayList<LinkedList<Integer>> adjGraph) {
        int visited[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        int connectedComp = 0;

        for (int i = 0; i < n; i++) {

            if (visited[i] == 0) {
                connectedComp = DFS(adjGraph, visited, stack, connectedComp, i);
            }
        }

        return connectedComp;
    }

    private static int DFS(ArrayList<LinkedList<Integer>> adjGraph, int[] visited, Stack<Integer> stack, int connectedComp, int i) {
        stack.push(i);

        while (!stack.isEmpty()) {
            int currNode = stack.pop();

            if (visited[currNode] == 0) {
                visited[currNode] = 1;
                System.out.print(currNode + 1 + " ");
            }
            for (int j = 0; j < adjGraph.get(currNode).size(); j++) {
                int adj = adjGraph.get(currNode).get(j);
                if (visited[adj] == 0) {
                    stack.push(adj);
                }
            }
        }
        connectedComp++;
        return connectedComp;
    }
}

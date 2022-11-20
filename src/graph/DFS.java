package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class DFS {

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

    private static void depthFirstSearch(ArrayList<LinkedList<Integer>> adjGraph, int nodes, int src) {
       int[] visited = new int[nodes];
       Stack<Integer> stack = new Stack<>();

       stack.push(src);

       while (!stack.empty()) {
           int currNode = stack.pop();

           if (visited[currNode] == 0) {
               visited[currNode] = 1;
               System.out.print(currNode);
           }

           for (int i = 0; i < adjGraph.get(currNode).size(); i++) {
               int node = adjGraph.get(currNode).get(i);
               if (visited[node] == 0) {
                   stack.push(node);
               }
           }
       }

    }
}

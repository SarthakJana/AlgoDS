package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CycleDetectionInDirectedGraph {
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
            //adjGraph.get(y - 1).add(x - 1);

            m--;
        }

        System.out.println("Has cycle: " + detectCycle(adjGraph, n));
    }

    private static boolean detectCycle(ArrayList<LinkedList<Integer>> adjGraph, int n) {
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();

        stack.push(0);

        while (!stack.isEmpty()) {
            int currNode = stack.peek();

            if (visited[currNode] == 0) {
                visited[currNode] = 1;
                for (int i = 0; i < adjGraph.get(currNode).size(); i++) {
                    int node = adjGraph.get(currNode).get(i);
                    if (visited[node] == 0) {
                        stack.push(node);
                    } else if (visited[node] == 1){
                        return true;
                    }
                }
            } else if (visited[currNode] == 1) {
                stack.pop();
                visited[currNode] = 2;
            }
        }

        return false;
    }
}

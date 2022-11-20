package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class CycleDetection {
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

        System.out.println("Has cycle: " + detectCycle(adjGraph, n));
    }

    private static boolean detectCycle(ArrayList<LinkedList<Integer>> adjGraph, int n) {
        int visited[] = new int[n];
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> ancestorStack = new Stack<>();
        int ancestor = Integer.MIN_VALUE;

            stack.push(0);

            while (!stack.isEmpty()) {
                int currNode = stack.pop();

                if (visited[currNode] == 0) {
                    visited[currNode] = 1;
                    System.out.print(currNode + 1 + " ");
                }

                if (!(adjGraph.get(currNode).size() == 1 && adjGraph.get(currNode).getFirst() == ancestor)) {
                    ancestorStack.push(currNode);
                } else {
                    ancestorStack.pop();
                }

                for (int j = 0; j < adjGraph.get(currNode).size(); j++) {
                    int adj = adjGraph.get(currNode).get(j);

                    if (visited[adj] == 0) {
                        stack.push(adj);
                    } else {
                        if (adj != ancestor) {
                            return true;
                        }
                    }
                }

                ancestor = ancestorStack.peek();
            }

        return false;
    }
}

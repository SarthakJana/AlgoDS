package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class BFS {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int nodes = s.nextInt();
        int edges = s.nextInt();

        ArrayList<LinkedList<Integer>> adjGraph = new ArrayList<LinkedList<Integer>>();

        for (int i = 0; i < nodes; i++) {
            adjGraph.add(new LinkedList<Integer>());
        }

        while (edges > 0) {
            int x = s.nextInt();
            int y = s.nextInt();

            adjGraph.get(x - 1).add(y -1);
            adjGraph.get(y - 1).add(x - 1);

            edges--;
        }

        breadthFirstSearch(adjGraph, nodes, 0);
    }

    private static void breadthFirstSearch(ArrayList<LinkedList<Integer>> adjGraph, int nodes, int i) {
        int[] visited = new int[nodes];
        LinkedList<Integer> queue = new LinkedList<>();

        queue.add(i);

        while (!queue.isEmpty()) {
            int currNode = queue.removeFirst();

            if (visited[currNode] == 0) {
                visited[currNode] = 1;
                System.out.print(currNode + " ");
            }

            for (int j = 0; j < adjGraph.get(currNode).size(); j++) {
                int node = adjGraph.get(currNode).get(j);
                if (visited[node] == 0) {
                    queue.add(node);
                    visited[node] = 1;
                    System.out.print(node + " ");
                }
            }
        }
    }

}

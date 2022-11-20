package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class CountNumberOfPaths {

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

            m--;
        }

        System.out.println("No. of connected components: " + countPaths(n, adjGraph));
    }


    public static int countPaths(int nodes, ArrayList<LinkedList<Integer>> adjGraph) {
        int[] visited = new int[nodes];
        int destination = nodes - 1;
        int count = 0;

        dfs(adjGraph, count, destination, visited, 0);

        return count;
    }

    public static void dfs(ArrayList<LinkedList<Integer>> adjGraph, int count, int destination, int[] visited, int source) {

        if (source == destination) {
            count++;
            System.out.println(count);
            visited[destination] = 0;
            return;
        }

        for (int i = 0; i < adjGraph.get(source).size(); i++) {

            int node = adjGraph.get(source).get(i);
            if (visited[node] == 0) {
                visited[node] = 1;
                dfs(adjGraph, count, destination, visited, node);
            }
        }

        visited[source] = 0;
    }
}

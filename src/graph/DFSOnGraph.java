package graph;

import java.util.Stack;

public class DFSOnGraph {
    public static void main(String[] args) {
        int grid[][] = {{-1, 2, 3},
                {0, 9, 8},
                {1, 0, 1}};

        dfsGraph(grid, 3, 3);
    }

    private static void dfsGraph(int[][] grid, int rows, int cols) {
        int dRow[] = { 0, 1, 0, -1 };
        int dCol[] = { -1, 0, 1, 0 };

        int[][] visited = new int[rows][cols];
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(0, 0));

        while (!stack.isEmpty()) {
            Pair curr = stack.pop();
            int r = curr.x;
            int c = curr.y;

            if (visited[r][c] == 0) {
                visited[r][c] = 1;
                System.out.println(grid[r][c]);
            }


        }
    }
}

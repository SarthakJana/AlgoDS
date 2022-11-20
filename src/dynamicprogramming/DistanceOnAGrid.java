package dynamicprogramming;

import java.util.Stack;

public class DistanceOnAGrid {

    static class Cell {
        public int x;
        public int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public void distanceOnAGrid(int row, int column) {
        int[][] grid = new int[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = 0;
            }
        }

        System.out.println("Distance Matrix is: " + dfsOnGrid(grid, row, column));
    }

    private String dfsOnGrid(int[][] grid, int row, int column) {
        int[][] visited = new int[row][column];
        Stack<Cell> stack = new Stack<>();
        int[] drow = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dCol = {0, 0, 1, -1, -1, 1, 1, -1};

        stack.push(new Cell(1, 1));

        while (!stack.isEmpty()) {
            Cell currCell = stack.pop();
            int x = currCell.x;
            int y = currCell.y;

            if (visited[x][y] == 0) {
                visited[x][y] = 1;
            }

            for (int i = 0; i < 8; i++) {
                int adjX = x + drow[i];
                int adjY = y + dCol[i];

                if (isValidGrid(adjX, adjY, row, column, visited)) {
                    stack.push(new Cell(adjX, adjY));

                    if (grid[adjX][adjY] == 0) {
                        grid[adjX][adjY] = grid[x][y] + 1;
                    }
                }
            }
        }

        return String.valueOf(grid);
    }

    private boolean isValidGrid(int adjX, int adjY, int row, int column, int[][] visited) {
        if (adjX >= row || adjX < 0 || adjY >= column || adjY < 0) return false;

        if (visited[adjX][adjY] == 1) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        DistanceOnAGrid distanceOnAGrid = new DistanceOnAGrid();
        distanceOnAGrid.distanceOnAGrid(3, 3);
    }

}

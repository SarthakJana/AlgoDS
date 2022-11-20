package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class AssassinSneak {

    static class Cell {
        public int x;
        public int y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean solution(String[] B) {
        int rows = B.length;
        int col = B[0].length();
        Cell cell = null;

        char[][] grid = new char[rows][col];

        for (int i = 0; i < rows; i++) {
            char[] chars = B[i].toCharArray();
            for (int j = 0; j < col; j++) {
                grid[i][j] = chars[j];
                if (chars[j] == 'A') {
                    cell = new Cell(i, j);
                }
            }
        }

        return canAssassinSneak(grid, rows, col, cell);
    }

    private static boolean canAssassinSneak(char[][] grid, int rows, int col, Cell cell) {
        List<Character> obstacles = new ArrayList<>();
        obstacles.add('X');
        obstacles.add('^');
        obstacles.add('v');
        obstacles.add('>');
        obstacles.add('<');


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < col; j++) {
                int k;
                char c = grid[i][j];
                switch (c) {
                    case '^':
                        grid[i][j] = 0;
                        k = i;
                        while (--k >= 0 && !obstacles.contains(grid[k][j])) {
                            grid[k][j] = 0;
                        }
                        break;

                    case 'v' :
                        grid[i][j] = 0;
                        k = i;
                        while (++k < rows && !obstacles.contains(grid[k][j])) {
                            grid[k][j] = 0;
                        }
                        break;

                    case '>' :
                        grid[i][j] = 0;
                        k = j;
                        while (++k < col && !obstacles.contains(grid[i][k])) {
                            grid[i][k] = 0;
                        }
                        break;

                    case '<' :
                        grid[i][j] = 0;
                        k = j;
                        while (--k >= 0 && !obstacles.contains(grid[i][k])) {
                            grid[i][k] = 0;
                        }
                        break;
                }
            }
        }


        return dfsA(grid, rows, col, cell);
    }

    private static boolean dfsA(char[][] grid, int rows, int col, Cell cell) {
        int[][] visited = new int[rows][col];
        int dRow[] = {0, 1, 0, -1};
        int dCol[] = {-1, 0, 1, 0};

        int r;
        int c;

        Stack<Cell> stack = new Stack<>();
        stack.push(cell);

        while (!stack.isEmpty()) {
            Cell currCell = stack.pop();

            r = currCell.x;
            c = currCell.y;

            if (visited[r][c] == 0) {
                visited[r][c] = 1;
            }

            for (int i = 0; i < 4; i++) {
                int adjx = r + dRow[i];
                int adjy = c + dCol[i];
                if (isValid(visited, grid, adjx, adjy, rows, col)) {
                    stack.push(new Cell(adjx, adjy));
                }
            }

        }

        return visited[rows - 1][col - 1] == 1;


    }

    private static boolean isValid(int[][] visited, char[][] grid, int i, int j, int rows, int col) {
        if (i < 0 || i >= rows || j < 0 || j >= col)
            return false;

        if (visited[i][j] == 1 || grid[i][j] == 'X' || grid[i][j] == 0)
            return false;

        return true;
    }

    public static void main(String[] args) {
        String[] B = {"X.....>", "..v..X.", ".>..X..", "A......"};
        System.out.println(solution(B));
    }
}

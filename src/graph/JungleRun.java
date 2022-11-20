package graph;

import java.util.LinkedList;

public class JungleRun {

    public int findWayToCity() {
        char[][] grid =
                {       {'S', 'P', 'P', 'P', 'P'},
                        {'T', 'P', 'T', 'P', 'P'},
                        {'T', 'P', 'P', 'P', 'P'},
                        {'P', 'T', 'E', 'T', 'T'},
                        {'P', 'T', 'P', 'T', 'T'}
                };

        int[][] visited = new int[5][5];
        int[][] distance = new int[5][5];
        int[] dRow = {1, -1, 0, 0};
        int[] dCol = {0, 0, 1, -1};
        int waysToReach = 0;

        LinkedList<Cell> queue = new LinkedList<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }

        distance[0][0] = 0;

        queue.add(new Cell(0, 0));

        while (!queue.isEmpty()) {
            Cell currCell = queue.removeFirst();

            int currR = currCell.row;
            int currC = currCell.col;

            if (visited[currR][currC] == 0) {
                visited[currR][currC] = 1;
            }

            for (int i = 0; i < 4; i++) {
                int adjR = currR + dRow[i];
                int adjC = currC + dCol[i];

                if (adjR == 3 && adjC == 2) {
                    waysToReach++;
                }

                if (isValidCell(adjR, adjC, visited, grid)) {


                    distance[adjR][adjC] = distance[currR][currC] + 1;

                    visited[adjR][adjC] = 1;
                    queue.addLast(new Cell(adjR, adjC));
                }
            }
        }

        System.out.println("Ways to reach end are: " + waysToReach);
        return distance[3][2];
    }

    private boolean isValidCell(int adjR, int adjC, int[][] visited, char[][] grid) {
        if (adjR < 0 || adjR >= 5 || adjC < 0 || adjC >= 5) return false;
        if (grid[adjR][adjC] == 'T') return false;
        if (visited[adjR][adjC] == 1) return false;

        return true;
    }

    public static void main(String[] args) {
        JungleRun jungleRun = new JungleRun();
        System.out.println(jungleRun.findWayToCity());
    }
}

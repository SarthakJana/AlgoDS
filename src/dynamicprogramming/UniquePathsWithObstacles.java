package dynamicprogramming;

public class UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        int[][] grid = new int[rows][cols];

        boolean flag = false;

        for (int i = 0; i < cols; i++) {
            if (flag || obstacleGrid[0][i] == 1) {
                flag = true;
                grid[0][i] = 0;
            } else {
                grid[0][i] = 1;
            }
        }

        flag = false;
        for (int i = 0; i < rows; i++) {
            if (flag || obstacleGrid[i][0] == 1) {
                flag = true;
                grid[i][0] = 0;
            } else {
                grid[i][0] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                if (obstacleGrid[i][j] == 1) {
                    grid[i][j] = 0;
                } else {
                    grid[i][j] = grid[i - 1][j] + grid[i][j - 1];
                }
            }
        }

        return grid[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        UniquePathsWithObstacles uniquePathsWithObstacles = new UniquePathsWithObstacles();
        System.out.println(uniquePathsWithObstacles.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}

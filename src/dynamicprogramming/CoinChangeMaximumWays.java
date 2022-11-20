package dynamicprogramming;

public class CoinChangeMaximumWays {

    public static int change(int amount, int[] coins) {
        int[][] ways = new int[coins.length + 1][amount + 1];

        for (int i = 1; i <= amount; i++) {
            ways[0][i] = 0;
        }

        for (int i = 0; i <= coins.length; i++) {
            ways[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (coins[i - 1] <= j) {
                    ways[i][j] = ways[i][j - coins[i - 1]] + ways[i - 1][j];
                } else {
                    ways[i][j]= ways[i - 1][j];
                }
            }
        }

        return ways[coins.length][amount];
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 5};
        System.out.println(CoinChangeMaximumWays.change(5, a));
    }
}

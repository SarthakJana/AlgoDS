package dynamicprogramming;


public class MinCoinChange {

    public static int coinChange(int[] coins, int amount) {
        int[] change = new int[amount + 1];
        change[0] = 0;

        for (int i = 1; i <= amount; i++) {
            change[i] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    change[i] = Math.min(change[i], 1 + change[i - coins[j]]);
                }
            }
        }

        if (change[amount] == Integer.MAX_VALUE + 1) {
            return -1;
        } else {
            return change[amount];
        }

    }

    public static void main(String[] args) {
        int[] c = {2};
        System.out.println(MinCoinChange.coinChange(c, 3));
    }
}

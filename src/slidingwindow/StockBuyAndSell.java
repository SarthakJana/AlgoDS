package slidingwindow;

public class StockBuyAndSell {

    public static int maxProfit(int[] prices) {
        int dBuy = 0;
        int dSell = 1;
        int maxProfit = Integer.MIN_VALUE;

        while (dSell < prices.length) {
            if (prices[dBuy] > prices[dSell]) {
                dBuy = dSell;
            } else {
                maxProfit = Math.max(maxProfit, prices[dSell] - prices[dBuy]);
            }

            dSell++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("Max Profit: " + maxProfit(new int[]{7, 6, 5, 4, 3, 2}));
    }
}

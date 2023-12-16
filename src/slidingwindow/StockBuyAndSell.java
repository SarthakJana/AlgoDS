package slidingwindow;

public class StockBuyAndSell {

    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        int dBuy = 0;
        int dSell = 1;

        if(prices.length <= 1) {
            return 0;
        }

        while (dSell < prices.length) {
            if (prices[dBuy] > prices[dSell]) {
                dBuy = dSell;
            }
            maxProfit = Math.max(maxProfit, prices[dSell] - prices[dBuy]);
            dSell++;
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        System.out.println("Max Profit: " + maxProfit(new int[]{7, 6, 5, 3, 2, 1}));
    }
}

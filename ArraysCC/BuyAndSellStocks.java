package ArraysCC;

public class BuyAndSellStocks { //O(n)
    public static void main(String[] args) { 
        int arr[] = { 4, 10, 23, 11, 6 };
        System.out.println(buyAndSellStocks(arr));
    }

    // BUY AND SELL STOCKS
    public static int buyAndSellStocks(int price[]) {
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < price.length; i++) {

            int sellPrice = price[i];

            if (buyPrice < sellPrice) { // profit
                int profit = sellPrice - buyPrice;
                maxProfit = Math.max(profit, maxProfit);
            } else {
                buyPrice = sellPrice;
            }

        }
        return maxProfit;
    }
}

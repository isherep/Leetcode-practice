package Array;

public class BestTimeToBuySellStock {
    // brute force - start buy at i and sell at i+1
    public int maxProfit(int[] prices) {
        int max = 0;
        for(int i = 0; i< prices.length-1; i++){
            for(int j = i+1; j < prices.length; j++){
                if(prices[j] > prices[i]){
                    max = Math.max(prices[j] - prices[i], max);
                    // System.out.println(max);
                }
            }
        }
        return max;
    }
    public int maxProfitDP(int[] prices){
        int minBuy = Integer.MAX_VALUE;
        int max = 0;

        for(int i = 0; i< prices.length; i++){
            minBuy = Math.min(prices[i], minBuy);
            max = Math.max(prices[i] - minBuy, max);

        }
        return max;
    }
}

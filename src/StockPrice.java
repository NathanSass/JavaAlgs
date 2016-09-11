/*
    Write an efficient function that takes stockPricesYesterday and returns the best profit
    I could have made from 1 purchase and 1 sale of 1 stock yesterday.
 */
public class StockPrice {
    public static void main(String [] args) {
        int[] stockPricesYesterday = new int[]{10, 7, 5, 8, 11, 9};
//        int maxProf = new StockPrice().getMaxProfit(stockPricesYesterday);
        int maxProf = new StockPrice().getMaxProfit_greedy(stockPricesYesterday);
        System.out.println(maxProf);
    }

    public int getMaxProfit(int[] stockPrices) {
        int currentMax = 0;
        int pointer, runner;
        for(int x = 0; x < stockPrices.length; x++) {
           pointer = stockPrices[x];
            for(int y = 0; y < stockPrices.length; y++) {
                runner = stockPrices[y];
                int profit = runner - pointer;
                Math.max(profit, currentMax);
            }
        }
        if (currentMax < 0) {
            currentMax = 0;
        }
        return currentMax;
    }

    public int getMaxProfit_greedy(int[] stockPrices){
        int minPrice = stockPrices[0];
        int maxProf = 0;

        for(int currentPrice : stockPrices){
            minPrice = Math.min(minPrice, currentPrice);

            int currentProf = currentPrice - minPrice;

            maxProf = Math.max(currentProf, maxProf);

        }

        return maxProf;
    }
}

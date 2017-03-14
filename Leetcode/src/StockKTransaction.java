import java.util.Arrays;

public class StockKTransaction {
    public static int maxProfit(int k, int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[][] profit = new int[k + 1][prices.length];
        int[][] lastSell = new int[k + 1][prices.length];
        
        for (int i = 1; i <= k; i++) {
            profit[i][0] = 0;
            lastSell[i][0] = 0;
            for (int j = 0; j < prices.length; j++) {
                if (j < i) {
                    profit[i][j] = profit[i - 1][j];
                    lastSell[i][j] = lastSell[i -1][j];
                } else {
                    int max = profit[i][j - 1];
                    lastSell[i][j] = lastSell[i - 1][j - 1];
//                    for (int p = lastSell[i - 1][j - 1]; p <= j - 1; p++) {
                    for (int p = 0; p <= j - 1; p++) {
                        if (profit[i - 1][p] + prices[j] - prices[p] > max) {
                            max = profit[i - 1][p] + prices[j] - prices[p];
                            lastSell[i][j] = j;
                        }
                        
                    }
                    profit[i][j] = max;
                }
            }
        }
//        for (int q = 0; q <= k; q++) {
//        	System.out.println(Arrays.toString(profit[q]));
//            System.out.println(Arrays.toString(lastSell[q]));
//        }
        
        return profit[k][prices.length - 1];
    }
    
    public static void main(String[] args) {
    	int[] prices = {6, 1, 3, 2, 4, 7};
    	System.out.println(maxProfit(2, prices));
    }
}
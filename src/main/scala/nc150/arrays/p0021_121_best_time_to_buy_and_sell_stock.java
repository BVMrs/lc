package nc150.arrays;

public class p0021_121_best_time_to_buy_and_sell_stock {
  public static void main(String[] args) {
    int[] nums = new int[] { 7,1,5,3,6,4 };
    
    int result = maxProfit(nums);
    
    System.out.println(result);
  }
  
  private static int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = -1;
    for (int i = 0; i < prices.length; i++) {
      if (prices[i] > minPrice) {
        maxProfit = Math.max(maxProfit, prices[i] - minPrice);
      } else minPrice = prices[i];
    }
    
    return maxProfit;
  }
  
}

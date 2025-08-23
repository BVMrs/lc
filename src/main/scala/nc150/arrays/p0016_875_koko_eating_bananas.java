package nc150.arrays;

public class p0016_875_koko_eating_bananas {
  public static void main(String[] args) {
    int[] nums = {3, 6, 7, 11};
    int h = 6;
    
    int result = minEatingSpeed(nums, h);
    
    System.out.println(result);
  }
  
  public static int minEatingSpeed(int[] piles, int h) {
    int rate = 1;
    
    int i = 0;
    int timeElapsed = 0;
    while (i < piles.length) {
      int curr = piles[i];
      
      timeElapsed += Math.ceil((double) curr / rate);
      
      if (timeElapsed > h) {
        i = 0;
        timeElapsed = 0;
        rate++;
        continue;
      }
      
      i++;
    }
    
    return rate;
  }
}

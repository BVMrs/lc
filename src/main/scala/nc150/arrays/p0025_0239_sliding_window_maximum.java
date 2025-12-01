package nc150.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p0025_0239_sliding_window_maximum {
  public static void main(String[] args) {
    int[] nums = { 1,3,-1,-3,5,3,6,7 };
    int k = 3;
    
    int[] result = maxSlidingWindow(nums, k);
    
    System.out.println(Arrays.toString(result));
  }
  
  public static int[] maxSlidingWindow(int[] nums, int k) {
    int[] ans = new int[k];
    Arrays.fill(ans, -1);
    
    int max = 0;
    int currSum = 0;
    Map<Integer, Integer> windowSizesFromIndex = new HashMap<>();
    
    // Starter
    for (int i = 0; i < k; i++) {
      currSum += nums[i];
      max = Math.max(currSum, max);
    }
    windowSizesFromIndex.put(currSum, 0);
    
    for (int i = 1; i <= nums.length - k; i++) {
      currSum -= nums[i - 1];
      currSum += nums[i + k - 1];
      
      max = Math.max(currSum, max);
      windowSizesFromIndex.put(currSum, i);
    }
    
    int startIdx = windowSizesFromIndex.get(max);
    for (int i = startIdx; i < startIdx + k; i++) {
      ans[i - startIdx] = nums[i];
    }
    
    return ans;
  }
}

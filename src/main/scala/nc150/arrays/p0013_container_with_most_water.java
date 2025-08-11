package nc150.arrays;

import java.util.*;

public class p0013_container_with_most_water {
  public static void main(String[] args) {
    int [] nums = { 1,8,6,2,5,4,8,3,7 };
    int result = maxArea(nums);
    
    System.out.println(result);
  }

  
  public static int maxArea(int[] height) {
    int ans = 0;
    
    int curr = 0;
    
    int lo = 0;
    int hi = height.length - 1;
    
    while (lo < hi) {
      curr = Math.min(height[hi], height[lo]) * (hi - lo);
      
      if (height[lo] > height[hi]) hi--;
      else lo++;
      
      ans = Math.max(ans, curr);
    }
    
    return ans;
  }
}

package nc150.arrays;

public class p0014_42_trapping_rain_water {
  public static void main(String[] args) {
    int[] nums = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
    int result = trap(nums);
    
    System.out.println(result);
  }
  
  
  public static int trap(int[] height) {
    int lo = 0;
    int hi = height.length - 1;
    
    int leftMax = 0;
    int rightMax = 0;
    
    int ans = 0;
    
    while (lo < hi) {
      if (height[lo] < height[hi]) {
        leftMax = Math.max(height[lo], leftMax);
        ans += leftMax - height[lo];
        lo++;
      } else {
        rightMax = Math.max(height[hi], rightMax);
        ans += rightMax - height[hi];
        hi--;
      }
    }
    
    return ans;
  }
}

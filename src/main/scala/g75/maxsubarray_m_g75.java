package g75;

public class maxsubarray_m_g75 {
  
    public static void main(String [] args) {
      int [] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
      int result = Solution.maxSubArray(nums);
      System.out.println(result);
    }
  
  static class Solution {
    public static int maxSubArray(int[] nums) {
      int currSum = 0;
      int maxSum = 0;
      for (int i = 0; i < nums.length; i++) {
        currSum += nums[i];
        
        if (currSum < 0) // reset algorithm
          currSum = 0;
        
        maxSum = Math.max(maxSum, currSum);
      }
      
      return maxSum;
    }
  }
}

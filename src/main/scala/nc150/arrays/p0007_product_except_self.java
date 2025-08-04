package nc150.arrays;

import java.util.Arrays;

public class p0007_product_except_self {
  public static void main(String [] args) {
    int [] nums = { 1,2,3,4 };
    int[] result = productExceptSelf(nums);
    System.out.println(Arrays.toString(result));
  }
  
  public static int[] productExceptSelf(int[] nums) {
    int [] L = new int[nums.length];
    int [] R = new int[nums.length];
    int [] ans = new int[nums.length];
    
    Arrays.fill(ans, 1);
    
    L[0] = 1;
    R[ans.length - 1] = 1;
    
    
    for (int i = 1; i < nums.length; i++) {
      L[i] = L[i - 1] * nums[i - 1];
    }
    
    for (int i = nums.length - 2; i >= 0; i--) {
      R[i] = R[i + 1] * nums[i + 1];
    }
    
    for (int i = 0; i < nums.length; i++) {
      ans[i] = L[i] * R[i];
    }
    
    return ans;
  }
}

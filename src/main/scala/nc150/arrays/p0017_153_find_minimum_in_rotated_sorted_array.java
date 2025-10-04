package nc150.arrays;

public class p0017_153_find_minimum_in_rotated_sorted_array {
  public static void main(String[] args) {
    int[] nums = { 3, 1, 2};
    
    int result = findMin(nums);
    
    System.out.println(result);
  }
  
  public static int findMin(int[] nums) {
    // binary search to find pivot
    int lo = 0;
    int hi = nums.length - 1;
    
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      
      if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      } else {
        hi = mid;
      }
    }
    
    return nums[lo];
  }
}


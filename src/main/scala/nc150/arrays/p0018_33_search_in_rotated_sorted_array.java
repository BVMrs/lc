package nc150.arrays;

public class p0018_33_search_in_rotated_sorted_array {
  public static void main(String[] args) {
    int[] nums = { 4,5,6,7,0,1,2};
    int target = 4;
    
    int result = search(nums, target);
    
    System.out.println(result);
  }
  
  public static int search(int[] nums, int target) {
    int lo = 0;
    int hi = nums.length - 1;
    
    // Two binary searches -> find min, then find wanted solution
    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;
      
      if (nums[mid] > nums[hi]) {
        lo = mid + 1;
      } else hi = mid;
    }
    
    int pIdx = lo;
    
    if (target == nums[pIdx]) return pIdx;
    
    int ans = binarySearch(nums, 0, pIdx - 1, target);
    
    return ans != - 1 ? ans : binarySearch(nums, pIdx, nums.length - 1, target);
  }
  
  static int binarySearch(int nums[], int lo, int hi, int target) {
    while (lo <= hi) {
      int mid = lo + (hi - lo) /  2;
      if (nums[mid] == target)
        return mid;
      if (nums[mid] < target)
        lo = mid + 1;
      else
        hi = mid - 1;
    }
    
    return -1;
  }
  
}


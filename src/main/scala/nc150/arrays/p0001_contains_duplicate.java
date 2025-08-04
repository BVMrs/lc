package nc150.arrays;

import g75.maxsubarray_m_g75;

import java.util.HashSet;
import java.util.Set;

public class p0001_contains_duplicate {
  
  public static void main(String [] args) {
    int [] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    boolean result = Solution.solution(nums);
    System.out.println(result);
  }
  
  static class Solution {
    public static boolean solution(int[] nums) {
      // brute force approach -> compare each with each -> complexity O(n^2)
      // use a hashset -> complexity O(n) -> space complexity O(n)
      
      Set<Integer> set = new HashSet<>();
      
      for (int i = 0; i < nums.length; i++) {
        if (set.contains(nums[i])) return true;
        set.add(nums[i]);
      }
      
      return false;
    }
  }
}

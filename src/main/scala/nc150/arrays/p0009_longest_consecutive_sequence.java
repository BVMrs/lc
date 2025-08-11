package nc150.arrays;

import java.util.*;

public class p0009_longest_consecutive_sequence {
  public static void main(String[] args) {
    int[] input = { 1, 1, 1, 2, 3, 2, 3 };
    
    int result = longestConsecutive(input);
    
    System.out.println(result);
  }
  
  public static int longestConsecutive(int[] nums) {
    int ans = 0;
    Set<Integer> set = new HashSet<>();
    
    for (int i = 0; i < nums.length; i++) {
      set.add(nums[i]);
    }
    
    int currSeq = 0;
    for (int tmp : set) {
      if (!set.contains(tmp - 1)) {
        int curr = tmp;
        currSeq = 1;
        
        while (set.contains(curr + 1)) {
          curr++;
          currSeq++;
        }
        
        ans = Math.max(ans, currSeq);
      }
    }
    
    return ans;
  }
  
}

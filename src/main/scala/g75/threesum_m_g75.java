package g75;

import java.util.*;

public class threesum_m_g75 {
  public static void main (String [] args) {
    int[] nums = new int[]{1, -1, -1, 0}; // [[-3,-1,4],[-4,1,3],[-3,0,3],[-2,0,2],[-4,0,4]]
    List<List<Integer>> result = threeSum(nums);
    System.out.println(result);
  }
  public static List<List<Integer>> threeSum(int[] nums) {
    // find the sum of all tuples of two elements
    // store their difference to zero in a hashmap of [Difference, Pair]
    // go through the array again and find solutions
    
    Set<List<Integer>> ans = new HashSet<>();
    Map<Integer, Pair> pairs = new HashMap<>();
    
    // compute all pairs of two
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) { // avoid duplicates
        pairs.put(-nums[i] - nums[j], new Pair(i, j)); // these are guaranteed to be different
      }
    }
    
    // a + b + c = 0
    // c = - a - b
    
    // fmm mi-e lene sa continui codul asta
    
    // now we need to find the third so the tuple satisfies the problem
    for (int i = 0; i < nums.length; i++) {
      Pair tmp = pairs.get(nums[i]);
      if (tmp != null && i != tmp.first && i != tmp.second) {
        List<Integer> tmpList = Arrays.asList(nums[tmp.first], nums[tmp.second], nums[i]);
        tmpList.sort((e1, e2) -> {
          if (e1 > e2) {
            return 1;
          } else if (e1.equals(e2)) return 0;
          else return -1;
        });
        
        ans.add(tmpList);
      }
    }
    
    return ans.stream().toList();
  }
  
  public static class Pair {
    int first;
    int second;
    
    public Pair(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
}

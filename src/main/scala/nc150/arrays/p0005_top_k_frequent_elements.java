package nc150.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class p0005_top_k_frequent_elements                   {
  
  public static void main(String [] args) {
    int[] input = { 1, 1, 1, 2, 2, 3 };
    
    int[] result = topKFrequent(input, 2);
    
    System.out.println(Arrays.toString(result));
  }
  
  public static int[] topKFrequent(int[] nums, int k) {
    Map<Integer, Integer> ans = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
      if (ans.containsKey(nums[i])) ans.put(nums[i], ans.get(nums[i]) + 1);
      else ans.put(nums[i], 1);
    }
    
    List<Integer> sortedValues = ans.entrySet().stream().sorted((e1,e2) -> {
      if (e1.getValue() < e2.getValue()) return -1;
      else return 1;
    }).map(Map.Entry::getValue).toList();
    
    int [] ans0 = new int[k];
    
    for (int i = 0; i < k; i++)
      ans0[i] = sortedValues.get(i);
    
    return ans0;
    
  }
}

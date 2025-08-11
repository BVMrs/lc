package nc150.arrays;

import java.util.*;

public class p0012_three_sum {
  public static void main(String[] args) {
    int [] nums = { -1,0,1,2,-1,-4 };
    List<List<Integer>> result = threeSum(nums);
    
    result.forEach(System.out::println);
    System.out.println();
  }
  
  public static List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> ans = new HashSet<>();
  
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length; i++) {
      ans.addAll(twoSum(nums, i));
    }
    
    return new ArrayList<>(ans);
  }
  
  public static Set<List<Integer>> twoSum(int[] numbers, int orig) {
    Set<List<Integer>> ans = new HashSet<>();
    int lo = 0;
    int hi = numbers.length - 1;
   
    while (lo < hi) {
      int sum = numbers[lo] + numbers[hi] + numbers[orig];
      if (sum == 0 && lo != orig && hi != orig) {
        List<Integer> tmp = Arrays.asList(numbers[lo], numbers[hi], numbers[orig]);
        Collections.sort(tmp);
        ans.add(tmp);
        lo++;
        hi--;
      } else if (sum > 0) hi--;
      else lo++;
    }
    
    return ans;
  }
}

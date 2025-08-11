package nc150.arrays;

import java.util.Arrays;

public class p0011_two_sum {
  public static void main(String[] args) {
    int [] input = { 2,7,11,15 };
    int target = 9;
    
    int [] result = twoSum(input, target);
    
    System.out.println(Arrays.toString(result));
  }
  
  public static int[] twoSum(int[] numbers, int target) {
    int lo = 0;
    int hi = numbers.length - 1;
    
    
    while (hi > lo) {
      int sum = numbers[lo] + numbers[hi];
      if (sum == target) return new int[] { lo + 1, hi + 1 };
      else if (sum > target) hi--;
      else lo++;
    }
    
    return new int[] { -1, -1 };
  }
}

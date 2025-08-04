package nc150.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p0003_two_sum {
  
  public static void main(String [] args) {
    int [] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    int target = 6;
    
    int[] result = solution(nums, target);
    
    System.out.println(Arrays.toString(result));
  }
  
  public static int[] solution(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{nums[i], nums[map.get(complement)]};
      } else {
        map.put(nums[i], i);
      }
    }
    
    return new int[] { -1, -1 };
  }

}

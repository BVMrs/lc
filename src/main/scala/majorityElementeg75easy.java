import java.util.HashMap;
import java.util.Map;

public class majorityElementeg75easy {
  public int majorityElement(int[] nums) {
    HashMap<Integer, Integer> counts = new HashMap<>();
    
    for (int i = 0; i < nums.length; i++) {
      counts.merge(nums[i], 1, Integer::sum);
    }
    
    int threshold = nums.length / 2;
    
    for (Map.Entry<Integer, Integer> entry : counts.entrySet()) {
      if (entry.getValue() > threshold) return entry.getKey();
    }
    
    return -1;
  }
}

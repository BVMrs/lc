package aoc2025;

import java.io.IOException;
import java.util.*;

import static aoc2025.Utils.loadContents;

public class d3 {
  
  public static void main(String[] args) throws IOException {
    String inputs = loadContents("3", "1", "2025");
    System.out.println(inputs);
    
    inputs = "987654321111111\n" +
        "811111111111119\n" +
        "234234234234278\n" +
        "818181911112111";
    
    Long ans_2s = Arrays.stream(inputs.split("\n")).map(d3::findLargestJoltage_2s).reduce(0L, Long::sum);;
    
    System.out.println(ans_2s);
  }
  
  static long findLargestJoltage_2s(String number) {
    // replace low numbers on the right with larger numbers on the left
    long ans = -1L;
    StringBuilder sb = new StringBuilder();
    
    Map<Character, List<Integer>> nums = new HashMap<>();
    
    for (int i = number.length() - 1; i >= 0; i--) {
      if (sb.length() < 12) {
        List<Integer> tmp = nums.getOrDefault(number.charAt(i), new ArrayList<>());
        tmp.add(sb.length());

        nums.put(number.charAt(i), tmp);
        sb.append(number.charAt(i));
      } else {

        // lowest number
        char lowestNumber = nums.keySet().stream().min(Character::compare).get();
        int lowestNumberPosition = nums.get(lowestNumber).removeFirst();
        if (nums.get(lowestNumber).isEmpty())
          nums.remove(lowestNumber);
        
        // claude generated
        for (List<Integer> positions : nums.values()) {
          for (int j = 0; j < positions.size(); j++) {
            if (positions.get(j) > lowestNumberPosition) {
              positions.set(j, positions.get(j) - 1);
            }
          }
        }
        
        sb.deleteCharAt(lowestNumberPosition);
        
        List<Integer> tmp = nums.getOrDefault(number.charAt(i), new ArrayList<>());
        tmp.add(sb.length());
        nums.put(number.charAt(i), tmp);
        
        sb.append(number.charAt(i));
      }
      
      
      ans = Math.max(Long.parseLong(new StringBuilder(sb).reverse().toString()), ans);
      System.out.println("best combination:\t" + ans + "\t\t| number:\t" + number);
    }

    return ans;

  }
  
//  170018169146777
}
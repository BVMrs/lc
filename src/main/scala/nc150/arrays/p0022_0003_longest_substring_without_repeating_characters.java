package nc150.arrays;

import java.util.HashMap;
import java.util.HashSet;

public class p0022_0003_longest_substring_without_repeating_characters {
  public static void main(String[] args) {
    String nums = "AABABBA";
    int k = 1;
    
    int result = lengthOfLongestSubstring(nums, k);
    
    System.out.println(result);
  }
  
  private static int lengthOfLongestSubstring(String s, int k) {
    int lo = 0; int hi = 0;
    
    HashMap<Character, Integer> freqs = new HashMap<>();
    int ans = -1;
    
    char maxChar = '-';
    int maxFreq = -1;
    for (hi = 0; hi < s.length(); hi++) {
      char curr = s.charAt(hi);
      
      // window length is at minimum k
      // the freq map needs to have one max and the others need to be less than k
      int currFreq = freqs.getOrDefault(curr, 0) + 1;
      freqs.put(curr, currFreq);
      
      if (currFreq > maxFreq) {
        maxFreq = currFreq;
        maxChar = curr;
      }

      
      // if window size too large, restrict by increasing lo
      if (hi - lo + 1 > maxFreq + k) {
        char currR = s.charAt(lo);
        int currLo = freqs.get(s.charAt(lo)) - 1;
        freqs.put(currR, currLo);
        
        lo++;
      }
      
      ans = Math.max(ans, hi - lo + 1);
      
    }
    
    return Math.min(ans, s.length());
  }
}

package g75;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class longestsubstringwithoutrepeatingchartacters_m_g75 {
  public static void main(String [] args) {
    int result = lengthOfLongestSubstring("abcabcbb");
    System.out.println(result);
  }
  
  public static int lengthOfLongestSubstring(String s) {
    int lo = 0;
    int hi = 1;
    
    int maxSize = 1;
    int currSize = 1;
    
    Set<Character> chars = new HashSet<>();
    
    chars.add(s.charAt(0));
    
    while (hi < s.length()) {
      if (!chars.contains(s.charAt(hi))) {
        chars.add(s.charAt(hi));
        currSize++;
        hi++;
      }
      else {
        // found a duplicate, it means that the start index is in conflict
        chars.remove(s.charAt(lo));
        currSize--;
        lo++;
      }
      
      maxSize = Math.max(maxSize, currSize);
    }
    
    return maxSize;
  }
}

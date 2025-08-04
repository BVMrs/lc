package nc150.arrays;

import java.util.*;

public class p0004_group_anagrams {
  
  public static void main(String [] args) {
    String [] strs = { "eat", "tea", "tan", "ate", "nat", "bat", "t", "t" };
    
    List<List<String>> result = solution(strs);
    
    System.out.println(result);
  }
  
  public static List<List<String>> solution(String [] strs) {
    int[] chars = new int[27];
    Map<String, List<String>> solution = new HashMap<>();
    
    
    for (String s: strs) {
      Arrays.fill(chars, 0);
      for (char c: s.toCharArray()) {
        chars[c - 'a']++;
      }
      
      StringBuilder sb = new StringBuilder();

      for (int i = 0; i < 27; i++) {
        sb.append(chars[i]);
        sb.append("separator");
      }
      
      String tmp = sb.toString();
      
      if (solution.containsKey(tmp)) solution.get(tmp).add(s);
      else solution.put(tmp,new ArrayList<>(List.of(s)));
    }
    
    return solution.values().stream().toList();
  }
}

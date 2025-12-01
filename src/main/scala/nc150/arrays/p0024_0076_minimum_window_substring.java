package nc150.arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class p0024_0076_minimum_window_substring {
  public static void main(String[] args) {
    String s1 = "abc", s2 = "cba";
    
    String result = minWindow(s1, s2);
    
    System.out.println(result);
  }
  
  public static String minWindow(String s, String t) {
    if (t.length() > s.length())  return "";
//    if (t.length() == s.length() && !t.equals(s))  return "";
    if (t.equals(s))  return s;
    
    Map<Character, Integer> histS = new HashMap<>();
    String ans = s + "-1";
    
    int[] histArrT = new int[58];
    
    for (char c : t.toCharArray()) {
      histArrT[c - 'A']++;
    }
    
    int l = 0;
    int r = 0;
    
    
    r = 0;
    
    while (l <= s.length() && r <= s.length()) {
      String curr = s.substring(l, r);
      int[] histArrCurr = new int[58];
      
      for (char c : curr.toCharArray()) {
        histArrCurr[c - 'A']++;
      }
      
      String curr1 = s.substring(l, r);
      int[] histArrCurr1 = new int[58];
      for (char c : curr1.toCharArray()) {
        histArrCurr1[c - 'A']++;
      }
      if (isSubHistogram(histArrCurr1, histArrT)) {
        // save solution
        int lower = Math.min(r - l, ans.length());
        if (lower < ans.length()) ans = s.substring(l, r);
      }
      
      
      // advance l as needed
      while (isSubHistogram(histArrCurr, histArrT) && (r - l) > t.length()) {
        int lower = Math.min(r - l, ans.length());
        if (lower < ans.length()) ans = s.substring(l, r);
        
        l++;
        curr = s.substring(l, r);
        Arrays.fill(histArrCurr, 0);
        
        for (char c : curr.toCharArray()) {
          histArrCurr[c - 'A']++;
        }
        
        if (isSubHistogram(histArrCurr, histArrT)) {
          lower = Math.min(r - l, ans.length());
          if (lower < ans.length()) ans = s.substring(l, r);
        }
      }
      
      // continue search
      r++;
    }
    
    
    return !ans.equals(s + "-1") ? ans : "";
  }
  
  private static boolean isSubHistogram(int [] first, int [] sub) {
    for (int i = 0; i < first.length; i++) {
      if (first[i] - sub[i] < 0) return false;
    }
    
    return true;
  }
}

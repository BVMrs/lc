package nc150.arrays;

import java.util.HashSet;
import java.util.Set;

public class p0010_valid_palindrome {
  public static void main(String[] args) {
    String input = "A man, a plan, a canal: Panama";
    
    boolean result = isPalindrome(input);
    
    System.out.println(result);
  }
  
  public static boolean isPalindrome(String s) {
    String strippedString = s.replaceAll("[^a-zA-Z]", "").toLowerCase();
    int len = strippedString.length();
    
    int lo = 0;
    int hi = len - 1;
    
    while (hi > lo) {
      if (strippedString.charAt(hi) != strippedString.charAt(lo)) return false;
      lo++;
      hi--;
    }
    
    return true;
  }
}

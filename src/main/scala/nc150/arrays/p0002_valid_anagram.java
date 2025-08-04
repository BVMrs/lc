package nc150.arrays;

public class p0002_valid_anagram {
  
  public static void main(String [] args) {
    String str1 = "oof";
    String str2 = "foo";
    
    boolean result = solution(str1, str2);
    
    System.out.println(result);
  }
  
  public static boolean solution(String s, String t) {
    // order and compare -> O(max(n,n) log (max(m,n)))
    
    int[] cnt = new int[26];
    
    for (int i = 0; i < s.length(); i++) {
      cnt[s.charAt(i) - 'a']++;
    }
    
    for (int i = 0; i < t.length(); i++) {
      cnt[t.charAt(i) - 'a']--;
    }
    
    for (int i = 0; i < 26; i++) {
      if (cnt[i] != 0) return false;
    }
    
    return true;
  }
}

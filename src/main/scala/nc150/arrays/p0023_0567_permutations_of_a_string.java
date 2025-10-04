package nc150.arrays;

public class p0023_0567_permutations_of_a_string {
  public static void main(String[] args) {
    String s1 = "ab", s2 = "eidboaoo";
    
    boolean result = checkInclusion(s1, s2);
    
    System.out.println(result);
  }
  
  public static boolean checkInclusion(String s1, String s2) {
    int lo = 0, hi = 0;
    int[] arr1 = new int[26];
    int[] arr2 = new int[26];
    
    
    for (int i = 0; i < s1.length(); i++) {
      arr1[s1.charAt(i) - 'a']++;
      arr2[s2.charAt(i) - 'a']++;
    }
    
    for (int i = s1.length(); i < s2.length() - s1.length(); i++) {
      if (histogramsMatch(arr1, arr2)) return true;
      arr2[s2.charAt(i) - 'a']++;
      arr2[s2.charAt(i + s1.length()) - 'a']--;
    }
      
    return histogramsMatch(arr1, arr2);
  }
  
  private static boolean histogramsMatch(int[] arr1, int[] arr2) {
    for (int i = 0; i < arr1.length; i++) {
      if (arr1[i] != arr2[i]) return false;
    }
    
    return true;
  }
}

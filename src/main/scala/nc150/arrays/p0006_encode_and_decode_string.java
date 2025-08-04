package nc150.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class p0006_encode_and_decode_string {
  
  public static void main(String [] args) {
    List<String> strs = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat", "t", "t");
    
    SizeDelimitedCodec codec = new SizeDelimitedCodec();
    List<String> result = codec.decode(codec.encode(strs));
    System.out.println(result);
    
    List<String> strs1 = Arrays.asList("eat", "tea", "tan", "ate", "n:/at", "bat", "t", "t");
    
    List<String> result1 = codec.decode(codec.encode(strs1));
    System.out.println(result1);
  }
  
  private static class DelimiterCodec {
    private String separator = "/:";
    private String escapeSequence = "//:";
    private char escapeCharacter = '/';
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
         StringBuilder sb = new StringBuilder();
         
         for (int i = 0; i < strs.size(); i++) {
           String tmp = strs.get(i).replace(separator, escapeSequence);
           sb.append(tmp);
           sb.append(separator);
         }
         
         return sb.toString();
    }
    
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      int idx = 0;
      List<String> ans = new ArrayList<>();
      
      for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == escapeCharacter && s.charAt(i + 1) ==  escapeCharacter) {
          continue;
        } else
        if (s.charAt(i) == escapeCharacter && s.charAt(i + 1) == ':'){
          ans.add(s.substring(idx, i));
          i=i+1;
          idx = i + 1;
        }
      }
      
      return ans;
    }
  }
  
  private static class SizeDelimitedCodec {
    private String separator = "/:";
    
    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      
      for (int i = 0; i < strs.size(); i++) {
        sb.append(strs.get(i).length()).append(separator).append(strs.get(i));
      }
      


      return sb.toString();
    }
    
    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
      int idx = 0;
      List<String> ans = new ArrayList<>();
      String tmp = new String(s);
      
      while (idx < tmp.length()) {
        int tmpIdx = tmp.indexOf(separator);
        
        int size = Integer.parseInt(tmp.substring(idx, tmpIdx));
        int startIdx = tmpIdx + separator.length();
        String decodedString = tmp.substring(startIdx, startIdx +  size);
        ans.add(decodedString);
        tmp = tmp.substring(startIdx + decodedString.length(), tmp.length());
      }
      
      return ans;
    }
  }
}

package aoc2024;

import scala.Int;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static aoc2024.Utils.loadContents;

public class d3 {
  public static void main(String[] args) throws IOException {
    String inputs = loadContents("3", "1");
    
    Solution ans = solution(inputs);

    System.out.println("One Star: " + ans.oneStar);
    System.out.println("Two Stars: " + ans.twoStars);
  }
  
  public static Solution solution(String input) {
    
    // Define the regex pattern to match "mul(\\d+,\\d+)"
    String regex = "mul\\(\\d+,\\d+\\)";
    
    // Compile the pattern
    Pattern pattern = Pattern.compile(regex);
    
    // Create a matcher for the input string
    Matcher matcher = pattern.matcher(input);
    
    List<Elements> elements = new ArrayList<>();
    // Find all matches
    System.out.println("Found occurrences:");
    while (matcher.find()) {
      // Print the matched substring
      System.out.println(matcher.group());
      
      String input0 = matcher.group();
      input0 = input0.replace("mul(", "");
      input0 = input0.replace(")", "");
      
      String[] split = input0.split(",");
      
      elements.add(new Elements(Integer.parseInt(split[0]), Integer.parseInt(split[1])));
    }
    
    int ans0 = elements.stream().map(e -> e.first * e.second).reduce(Integer::sum).get();
    
    return new Solution(ans0, ans0);
  }
  
  static class Elements {
    int first;
    int second;
    
    public Elements(int first, int second) {
      this.first = first;
      this.second = second;
    }
  }
  
  static class Solution {
    int oneStar;
    int twoStars;
    
    public Solution(int oneStar, int twoStars) {
      this.oneStar = oneStar;
      this.twoStars = twoStars;
    }
  }
}
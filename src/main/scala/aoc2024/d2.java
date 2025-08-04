package aoc2024;

import java.io.IOException;
import java.util.*;

import static aoc2024.Utils.loadContents;

public class d2 {
  public static void main (String [] args) throws IOException {
    String inputs = loadContents("2", "1");
    
    String [] rows = inputs.split("\n");
    
    Solution ans = solution(rows);
    
    System.out.println("One Star: " + ans.oneStar);
    System.out.println("Two Stars: " + ans.twoStars);
  }
  
  public static Solution solution(String[] rows) {
    SolutionContext solutionContext0 = new SolutionContext(new ArrayList<>(), 0);
    SolutionContext solutionContext1 = new SolutionContext(new ArrayList<>(), 0);
    
    for (String row : rows) {
      String [] elements = row.split(" ");
      List<String> elementsList = new ArrayList<>(Arrays.asList(elements));
      isSafe(elementsList, solutionContext0);
    }
    
    int ans0 = 0;
    for (UnsafeRecord unsafeRecord : solutionContext0.unsafeRecords) {
      for (int i = 0; i < unsafeRecord.record.size(); i++) {
        List<String> elementsList = new ArrayList<>(unsafeRecord.record);
        elementsList.remove(i);
        boolean isSafe = isSafeSimple(elementsList);
        
        if (isSafe) {
          ans0++;
          break;
        }
      }
    }
    
    return new Solution(solutionContext0.safeRecords, solutionContext0.safeRecords + ans0);
  }
  
  static boolean isSafeSimple(List<String> elements) {
    boolean safe = true;
    boolean increasing = true;
    
    if (Integer.parseInt(elements.get(0)) < Integer.parseInt(elements.get(1)))
      increasing = true;
    else
      increasing = false;
    
    for (int i = 1; i < elements.size(); i++) {
      int prev = Integer.parseInt(elements.get(i - 1));
      int curr = Integer.parseInt(elements.get(i));
      
      if (Math.abs(curr - prev) > 3 ||
          Math.abs(curr - prev) < 1 ||
          increasing && curr - prev < 0 ||
          !increasing && curr - prev > 0) {
        safe = false;
      }
    }
    
    return safe;
  }
  
  static SolutionContext isSafe(List<String> elements, SolutionContext solutionContext) {
    
    boolean safe = true;
    boolean increasing = true;
    
    if (Integer.parseInt(elements.get(0)) < Integer.parseInt(elements.get(1)))
      increasing = true;
    else
      increasing = false;
    
    int firstUnsafeEntry = -1;
    
    int errorCount0 = 0;
    
    for (int i = 1; i < elements.size(); i++) {
      int prev = Integer.parseInt(elements.get(i - 1));
      int curr = Integer.parseInt(elements.get(i));
      
      if (Math.abs(curr - prev) > 3 ||
          Math.abs(curr - prev) < 1 ||
          increasing && curr - prev < 0 ||
          !increasing && curr - prev > 0) {
        safe = false;
        errorCount0++;
        if (firstUnsafeEntry == -1) firstUnsafeEntry = i;
      }
    }
    
    if (safe) solutionContext.safeRecords++;
    else solutionContext.unsafeRecords.add(new UnsafeRecord(elements, firstUnsafeEntry, errorCount0));
    
    return solutionContext;
  }
  
  static class SolutionContext {
    List<UnsafeRecord> unsafeRecords;
    int safeRecords;
    
    public SolutionContext(List<UnsafeRecord> unsafeRecords, int safeRecords) {
      this.unsafeRecords = unsafeRecords;
      this.safeRecords = safeRecords;
    }
  }
  
  static class UnsafeRecord {
    List<String> record;
    int firstErrorIndex;
    int errorCount;
    
    public UnsafeRecord(List<String> record, int firstErrorIndex, int errorCount) {
      this.record = record;
      this.firstErrorIndex = firstErrorIndex;
      this.errorCount = errorCount;
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

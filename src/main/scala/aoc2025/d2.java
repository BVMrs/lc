package aoc2025;

import java.io.IOException;
import java.util.Arrays;

import static aoc2025.Utils.loadContents;

public class d2 {
  public static void main (String [] args) throws IOException {
    String inputs = loadContents("2", "1", "2025");
    System.out.println(inputs);
    
    String [] intervals = inputs.split(",");
    
    Long ans_1s = 0L;
    Long ans_2s = 0L;
    
    ans_1s = Arrays.stream(intervals).map(Interval::apply).map(e -> {
      Long currSum = 0L;
      // need a while with a long
      for (int i = Math.toIntExact(e.start); i < e.end; i++) {
        if (isInvalid(i)) currSum += i;
      }
      
      return currSum;
    }).reduce(0L, Long::sum);
    
  
    System.out.println(ans_1s);
    System.out.println(ans_2s);
    
  }
  
  
  static boolean isInvalid(long number) {
    int nrDigits = Interval.countDigits(number);
    int maxSequenceLength = Interval.maxSequenceLength(nrDigits);
    
    boolean isInvalid = true;
    
    for (int i = 1; i <= maxSequenceLength; i++) {
      if (!Interval.isMultipleOf(nrDigits, i)) continue;
      
      int lo = 0;
      int hi = i;
      
      String tmp = String.valueOf(number);
      
      String cmp = tmp.substring(lo, hi);
      while (hi < tmp.length() - i) {
        lo += i;
        hi += i;
       
        if (!tmp.substring(lo, hi).equals(cmp)) {
          isInvalid = false;
          break;
        }
      }
    }
    
    return isInvalid;
  }
  
  record Interval(long start, long end) {
    static Interval apply(String str) {
      String[] limits = str.split("-");
      
      return new Interval(
          Long.parseLong(limits[0]),
          Long.parseLong(limits[1])
      );
    }
    
    static int countDigits(long value) {
      long tmp = value;
      int cnt = 0;
      while (tmp % 10 != 0) {
        tmp = tmp / 10;
        cnt++;
      }
      
      return cnt;
    }
    
    static int maxSequenceLength(int digitCount) {
      return digitCount / 2;
    }
    
    static boolean isMultipleOf(long value, long divisor) {
      long tmp = value;
      while (tmp > 0) {
        if (tmp % divisor == 0) {
          tmp = tmp / 10;
          continue;
        };
        
        return false;
      }
      
      return true;
    }
  }
}

package g75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeinterval_m_g75 {
  // todo: use a linked list to represent the new array
  public static void main(String [] args) {
    int [][] nums = {{1,3},{6,9}};
    int [] newInterval = { 2,5 };
    int[][] result = insert(nums, newInterval);
    System.out.println(Arrays.deepToString(result));
  }
  
  public static int[][] insert(int[][] intervals, int[] newInterval) {
    int[][] newIntervals = new int[2 * intervals.length][2];
    
    // find the start of the overlap
    int i = 0;
    while (newInterval[0] >= intervals[i][0]) {
      newIntervals[i] = intervals[i];
      i++;
    }
    
    int j = i + 1;
    // there is no overlap
    if (newInterval[1] < intervals[j][0]) {
      newIntervals[j] = newInterval;
      i++;
      j++;
      
      // copy the rest of the array
      while (i < intervals.length) {
        newIntervals[j] = intervals[i];
        i++;
        j++;
      }
    } else {
      // there is at least one overlaps
      while (newInterval[1] > intervals[j][0] && newInterval[1] < intervals[j][1]) {
        j++; // only increment the old array's index
      }
      
      newIntervals[i] = new int[]{newInterval[0], intervals[j][1]};
      i++;
      j++;
      
      while(j < intervals.length) {
        newIntervals[i] = intervals[j];
        i++;
        j++;
      }
    }
    return newIntervals;
  }
}

package g75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class k_closest_points {
  public static void main(String [] args) {
    int [][] nums = {{1,3},{-2,2}};
    int[][] result = kClosest(nums, 1);
    System.out.println(Arrays.deepToString(result));
  }
  
  public static int[][] kClosest(int[][] points, int k) {
    List<Points> ans = new ArrayList<>();
    
    for (int i = 0; i < points.length; i++) {
      ans.add(
          new Points(
              computeDistance(points[i][0], points[i][1]),
              new int[] { points[i][0], points[i][1] }
          )
      );
    }
    
    ans.sort((o1, o2) -> o2.distance <= o1.distance ? 1 : -1);
    List<int[]> ans1 = ans.stream().map(e -> e.xy).toList();
    
    int[][] karr = new int[k][2];
    
    for (int i = 0; i < k; i++){
      karr[i] = ans1.get(i);
    }
    
    return karr;
  }
  
  public static double computeDistance(int x, int y) {
    return Math.sqrt(y * y + x * x);
  }
  
  public static class Points {
    double distance;
    int[] xy;
    
    public Points(double distance, int[] xy) {
      this.distance = distance;
      this.xy = xy;
    }
  }
}

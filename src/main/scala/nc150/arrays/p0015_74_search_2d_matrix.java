package nc150.arrays;

public class p0015_74_search_2d_matrix {
  public static void main(String[] args) {
//    int[][] nums = { {1,3,5,7},{10,11,16,20},{23,30,34,50} };
    int[][] nums = { {1} };
    boolean result = searchMatrix(nums, 1);
    
    System.out.println(result);
  }
  
  public static boolean searchMatrix(int[][] matrix, int target) {
    // 2 binary search ->
    // 1. find row
    // 2. find column
    
    if(matrix.length == 0 || matrix[0].length == 0) return false;
    
    int cols = matrix[0].length - 1;
    int rows = matrix.length - 1;
    
    int lo = 0;
    int hi = rows;
    
    while (hi >= lo) {
      int mid = (hi + lo) / 2;
      
      if (target < matrix[mid][0]) hi = mid - 1;
      else if (target > matrix[mid][cols]) lo = mid + 1;
      else {
        lo = mid;
        break;
      }
    }
    
    if (lo < 0 || lo >= rows + 1) return false;
    
    int targetRow = lo;
    
    lo = 0;
    hi = matrix[0].length - 1;
    
    while (hi >= lo) {
      int mid = (hi + lo) / 2;
      int curr = matrix[targetRow][mid];
      
      if ( curr == target) return true;
      else if (curr > target) hi = mid - 1;
      else lo = mid + 1;
    }
    
    int targetColumn = lo;
    
    return matrix[targetRow][targetColumn] == target;
  }
}









































































































































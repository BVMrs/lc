package nc150.arrays;

import java.util.HashSet;
import java.util.Set;

public class p0008_valid_sudoku {
  public static void main(String[] args) {
    char[][] nums = {
        {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
    };
    boolean result = isValidSudoku(nums);
    System.out.println(result);
  }
  
  public static boolean isValidSudoku(char[][] board) {
    // create sets for each entity
    int N = board.length;
    Set<Character> [] rowsSet = new HashSet[N];
    Set<Character> [] columnsSet = new HashSet[N];
    Set<Character> [] boxSet = new HashSet[N];
    
    // initialize sets
    
    for (int i = 0; i < N; i++) {
      rowsSet[i] = new HashSet<>();
      columnsSet[i] = new HashSet<>();
      boxSet[i] = new HashSet<>();
    }
    
    for (int r = 0; r < N; r++) {
      for (int c = 0; c < N; c++) {
        char curr = board[r][c];
        if (curr == '.') continue;
        
        if (rowsSet[r].contains(curr)) return false;
        else rowsSet[r].add(curr);
        
        if (columnsSet[c].contains(curr)) return false;
        else columnsSet[c].add(curr);
        
        int box = (r / 3) * 3 + c / 3;
        if (boxSet[box].contains(curr)) return false;
        else boxSet[box].add(curr);
      }
    }
    
    return true;
  }
}

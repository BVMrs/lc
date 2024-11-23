package g75;

import java.util.*;

public class levelordertraversal_m_g75 {
  public static void main(String[] args) {
    TreeNode root = new TreeNode(
        1,
        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3)
    );
    List<List<Integer>> result = levelOrderBfs(root);
    System.out.println(result);
  }
  
  public static List<List<Integer>> levelOrderBfs(TreeNode root) {
    Map<Integer, List<Integer>> temp = new HashMap<>();
    
    // do a bfs
    // we need a queue
    Queue<TreeNode> queue = new LinkedList<>();
    queue.add(root);
    
    int level = 0;
    while (!queue.isEmpty()) {
      int levelLength = queue.size();
      List<Integer> levelValues = new ArrayList<>();
      
      for (int i = 0; i < levelLength; i++) {
        TreeNode curr = queue.poll();
        levelValues.add(curr.val);
        
        if (curr.left != null) queue.add(curr.left);
        if (curr.right != null) queue.add(curr.right);
      }
      
      temp.put(level, levelValues);
      level++;
    }
    
    List<List<Integer>> ans = new ArrayList<>();
    for (int i = 0; i < temp.keySet().size(); i++) {
      ans.add(temp.get(i));
    }
    
    return ans;
  }

  public static int height(TreeNode root, int i) {
    if (root == null) return i;
    else return Math.max(height(root.left, i + 1), height(root.right, i + 1)) + 1;
  }
  
  public static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode() {
    }
    
    TreeNode(int val) {
      this.val = val;
    }
    
    TreeNode(int val, TreeNode left, TreeNode right) {
      this.val = val;
      this.left = left;
      this.right = right;
    }
  }
}

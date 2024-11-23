package g75;

public class diameterbinarytreeeg75easy {
  static int max = 0;
  
  public static void main(String [] args) {
    TreeNode root = new TreeNode(
        1,
          new TreeNode(2, new TreeNode(4), new TreeNode(5)),
          new TreeNode(3)
    );
    
    int result = diameterOfBinaryTree(root);
    System.out.println(result);
  }
  
  public static int diameterOfBinaryTree(TreeNode node) {
    max = 0;
    getLongestPath(node);
    return max;
  }
  
  public static int getLongestPath(TreeNode node) {
    // longest path is always between two leaves
    // need to apply dfs to see which branch has the largest depth
    // use a global variable
    if (node == null) return 0;
    
    int leftDiameter = getLongestPath(node.left);
    int rightDiameter = getLongestPath(node.right);
    
    // the "diameter" is the path between two leaf nodes
    max = Math.max(max, leftDiameter + rightDiameter);
    
    return Math.max(leftDiameter, rightDiameter) + 1;
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

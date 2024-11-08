public class maxDepthOfBinaryTree {
  public static void main(String [] args) {
    TreeNode root = new TreeNode(
        1,
        new TreeNode(2, new TreeNode(4), new TreeNode(5)),
        new TreeNode(3)
    );
    
    int result = maxDepth(root);
    System.out.println(result);
  }
  
  public static int maxDepth(TreeNode root) {
    return maxDepthHelper(root, 0);
  }
  
  public static int maxDepthHelper(TreeNode node, int currDepth) {
    if (node == null) {
      return currDepth;
    }
    
    int leftDepth = maxDepthHelper(node.left, currDepth + 1);
    int rightDepth = maxDepthHelper(node.right, currDepth + 1);
    
    return Math.max(leftDepth, rightDepth) + 1;
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
  
  int maxDepth1(TreeNode node) {
    if (node == null) return 0;
    
    int leftDepth = maxDepth1(node.left);
    int rightDepth = maxDepth1(node.right);
    
    return Math.max(leftDepth, rightDepth) + 1;
  }
  
}

import java.util.List;

public class reverselisteg75easy {
  
  public static void main(String[] args) {
    ListNode n5 = new ListNode(5);
    ListNode n4 = new ListNode(4, n5);
    ListNode n3 = new ListNode(3, n4);
    ListNode n2 = new ListNode(2, n3);
    ListNode n1 = new ListNode(1, n2);
    
    ListNode reversedHead = reverseList(n1);
    
    System.out.println("reversedHead=" + reversedHead.val);
    
  }
  
  public static ListNode reverseList(ListNode head) {
    ListNode firstNode = null;
    ListNode secondNode = head;
    
    while (secondNode != null) {
      ListNode tmp = secondNode.next;
      
      secondNode.next = firstNode;
      
      firstNode = secondNode;
      secondNode = tmp;
    }
    
    return firstNode;
  }
  
  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

}

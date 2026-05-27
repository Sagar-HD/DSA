package LeetCode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

      public class ListNode {
     int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public ListNode helper (ListNode head){
        if(head==null || head.next==null ){
            return head;
        }
        
        ListNode nextNode=head.next;
        ListNode future=nextNode.next;
        nextNode.next=head;
        head.next=helper(future);
        return nextNode;
        
    }
    public ListNode swapPairs(ListNode head) {
        return helper(head);
    }
}

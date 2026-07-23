package Heap.minHeapMerge;

import java.util.PriorityQueue;
 


public class MergeKsortedArray {

     public static class ListNode {
      int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

     public static ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> minHeap=new PriorityQueue<>((node1,node2)->Integer.compare(node1.val,node2.val));

        for(int i=0;i<lists.length;i++){
              if (lists[i] != null) {
        minHeap.add(lists[i]);
    }
        }
        ListNode head=new ListNode();
        ListNode tail=head;


        while(!minHeap.isEmpty()){
            ListNode node=minHeap.poll();
            tail.next=node;
            tail=tail.next;
            if(node.next!=null){
            minHeap.add(node.next);
            }
        }

        
        return head.next;
    }
    public static void main(String[] args) {
       

        ListNode head1=new ListNode(1);
        head1.next=new ListNode(4);
        head1.next.next=new ListNode(5);


        ListNode head2=new ListNode(1);
        head2.next=new ListNode(3);
        head2.next.next=new ListNode(4);

        ListNode head3=new ListNode(2);
        head3.next=new ListNode(6);

        ListNode[] lists={head1,head2,head3};

        ListNode merged=mergeKLists(lists);

        while(merged!=null){
            System.out.println(merged.val);
            merged=merged.next;
        }

        
    }
    
}

import java.util.*;

class Node{
  int val;
  Node next;
  public Node(int val){
    this.val=val;
  }
}
public class DetectLoopInLinkedList{
  static Node head;
  static Node tail;
  


  static void addLast(int val){
    if(head!=null){
      Node newNode=new Node(val);
      tail.next=newNode;
      tail=newNode;
      
    }else{
      
  Node newNode=new Node(val);
  head=newNode;
  tail=newNode;
    }
}
static void display(){
  if(head!=null){
    Node ptr=head;
    while(ptr!=null){
      System.out.println(ptr.val);
      ptr=ptr.next;
    }
  
    
    
  }else{
    System.out.println("list is empty");
  }
}
static void reverse(){
  if(head==null)return ;
  tail=head;
  
  Node prev=null;
  Node ptr=head;
  Node future=head.next;
  while(ptr!=null){
    future=ptr.next;
    ptr.next=prev;
    prev=ptr;
    ptr=future;
    
  }
  head=prev;
}
  
    public static void main(String[] args) {
      Node head1=new Node(1);
      Node node1=new Node(3);
      Node node2=new Node(5);
      head1.next=node1;
      node1.next=node2;
      
      Node node3=new Node(2);
      Node node4=new Node(4);
      Node node5=new Node(6);
      node2.next=node3;
      node3.next=node4;
      node4.next=node5;
      node5.next=node3;
      
      Node slowPtr=head1;
      Node fastPtr=head1.next;
      while(fastPtr!=null && fastPtr.next!=null){
        slowPtr=slowPtr.next;
        fastPtr=fastPtr.next.next;
        if(slowPtr==fastPtr){
          System.out.println("loop exists ");
          return;
        }
        
      }
      System.out.println("no loop");
      
    }
}
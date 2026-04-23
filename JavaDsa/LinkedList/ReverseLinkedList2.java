import java.util.*;

class Node{
  int val;
  Node next;
  public Node(int val){
    this.val=val;
  }
}
public class ReverseLinkedList{
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
      addLast(2);
      addLast(3);
      addLast(4);
      display();
      reverse();
      display();
      
      
    }
}
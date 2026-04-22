import java.util.*;

class Node{
  int val;
  Node next;
  public Node(int val){
    this.val=val;
  }
}
public class Merge2SortedLinkedList{
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
      Node node11=new Node(3);
      Node node12=new Node(5);
      head1.next=node11;
      node11.next=node12;
      
      Node head2=new Node(2);
      Node node21=new Node(4);
      Node node22=new Node(6);
      head2.next=node21;
      node21.next=node22;
      
      Node newHead=null;
      if(head1==null){
        newHead=head2;
      }
      else if(head2==null){
        newHead=head1;
      }
      else{
      if(head1.val < head2.val ){
        newHead=head1;
        head1=head1.next;
        
      }else{
        newHead=head2;
        head2=head2.next;
      }
      }
      Node newPtr=newHead;
      while(head1!=null && head2!=null){
              if(head1.val < head2.val ){
                newPtr.next=head1;
             newPtr=head1;
                
                head1=head1.next;
                
              }
              else{
                newPtr.next=head2;
newPtr=head2;
                
                head2=head2.next;
                
              }
      }
      
      while(head1!=null){
        newPtr.next=head1;
        newPtr=head1;
        head1=head1.next;
      }
      while(head2!=null){
        newPtr.next=head2;
        newPtr=head2;
        head2=head2.next;
      }
      
      if(newHead!=null){
    Node ptr=newHead;
    while(ptr!=null){
      System.out.println(ptr.val);
      ptr=ptr.next;
    }
  
    
    
  }else{
    System.out.println("list is empty");
  }
      
    }
}
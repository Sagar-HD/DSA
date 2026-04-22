import java.util.*;

public class Heap {
  static int heap[]=new int[10];
  static int index=0;
  
 static void order(int ind){
    if(ind<=0 || heap[ind]>=heap[(ind-1)/2]){
      System.out.println("inserted");
      return;
    }
    int temp=heap[ind];
    heap[ind]=heap[(ind-1)/2];
    heap[(ind-1)/2]=temp;
    order((ind-1)/2);
    
  }
  static void orderDown(int ind){
    int left=(ind*2)+1;
    int right=(ind*2)+2;
    int smallest=ind;
    if(left<index && heap[left]<heap[smallest]){
      smallest=left;
    }
    if(right<index && heap[right]<heap[smallest])
    {
      smallest=right;
    }
    
     if(smallest!=ind){
      int temp=heap[ind];
      heap[ind]=heap[smallest];
      heap[smallest]=temp;
      orderDown(smallest);
}
    
  }

 static void insert(int i){
    if(index==heap.length){
      System.out.println("heap is full");
      return;
    }
    if(index==0){
      heap[index]=i;
      index++;
      return;
    }
    heap[index]=i;
    order(index);
    index++;
    
  }
  static void delete(){
    if(index == 0){
        System.out.println("Heap empty");
        return;
    }
    heap[0]=heap[index-1];
    index--;
    orderDown(0);
    
    heap[index]=0;
    System.out.println("deleted ");
  }
  
  static void delete(int ind){
    if(ind>=index || ind<0 || index==0){
      System.out.println("cannot delete");
      return;
    }
    heap[ind]=heap[index-1];
    index--;
    
    if(ind>0 && heap[ind]<heap[((ind-1)/2)]){
      order(ind);
      
    }
    else {
      
      orderDown(ind);
    }
    heap[index]=0;
    System.out.println("deleted");
    
  }
    public static void main(String[] args) {
      int[] arr={3,5,1,7,8,9};
      insert(3);
      insert(5);
      insert(2);
      insert(8);
      delete();
     delete(1);
  
      
      for(int i:heap){
        System.out.println(i);
      }
    }
}
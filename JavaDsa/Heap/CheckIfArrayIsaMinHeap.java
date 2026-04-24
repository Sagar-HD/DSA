

public class CheckIfArrayIsaMinHeap{
  
  
  static boolean check(int[] arr,int node){
    if(node<=(arr.length/2)-1){
      int left=(node*2)+1;
      int right=(node*2)+2;
      if(left<arr.length && arr[left]<arr[node] ){
        return false ;
        
      }
      if(right<arr.length && arr[right]<arr[node])
      {
        return false;
     }
      
return check(arr,(node*2)+1)&&check(arr,(node*2)+2);
    
    }
    
  return true;
  

  }
    public static void main(String[] args) {
      int[] arr={2,3,4,6,8};
         System.out.println(check(arr,0));
    }
}
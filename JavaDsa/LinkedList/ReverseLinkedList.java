import java.util.*;


public class ReverseLinkedList{
    public static void main(String[] args) {
      LinkedList<Integer> list=new LinkedList<>();
      list.add(3);
      list.add(4);
      list.add(5 );
      list.add(6);
      System.out.println(list);
      int[] arr=new int[list.size()];
      int j=0;
      for(Integer i:list){
        arr[j]=i;
        j++;
        
      }
      j=0;
      for(int i=arr.length-1;i>=0;i--){
        list.set(j,arr[i]);
        j++;
      }
      System.out.println(list);
    }
}
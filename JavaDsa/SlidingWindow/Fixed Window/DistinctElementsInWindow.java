import java.util.*;

public class DistinctElementsInWindow{
    public static void main(String[] args) {
      int[] arr={1,2,3,2,1,3,5,6,6,7,8,9,7};
      HashMap<Integer,Integer> map=new HashMap<>();
      int start=0;
      int end=0;
      int k=4;
      int count=0;
      while(end<arr.length){
        
          
          map.put(arr[end],map.getOrDefault(arr[end],0)+1);
          
        if(end-start+1<k){
          end++;
        }
        else{
          System.out.println(map.size());
          map.put(arr[start],map.get(arr[start])-1);
          if(map.get(arr[start])==0){
            map.remove(arr[start]);
          }
         
          start++;
          end++;
        }
      }
    }
}
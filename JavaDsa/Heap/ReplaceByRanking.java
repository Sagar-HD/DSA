import java.util.*;
public class ReplaceByRanking {
    public static void main(String[] args) {
        int[] arr={4,1,2,78,34,91,6};
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.offer(arr[i]);
        }
        int i=1;
        HashMap<Integer,Integer> map=new HashMap<>();

        while(!pq.isEmpty()){

            int temp=pq.poll();
          if(!map.containsKey(temp)){
              map.put(temp,i);
              i++;
          }

        }
       for(int k=0;k<arr.length;k++){
           arr[k]=map.get(arr[k]);
       }
       for(int k=0;k<arr.length;k++){
           System.out.print(arr[k]+" ");
       }
    }
}

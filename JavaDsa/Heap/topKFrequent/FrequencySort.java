package topKFrequent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class FrequencySort {
    static ArrayList<Integer> getSorted(int[] arr){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i:arr){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        PriorityQueue<Pair<Integer,Integer>> maxHeap=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair2.getValue(), pair1.getValue()));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            maxHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
    
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!maxHeap.isEmpty()){
            ans.add(maxHeap.poll().getKey());
        }
        return ans;
    }
    public static void main(String[] args) {
          int[] arr={1,2,2,3,3,5,5,4,4,4,4,6};
          System.out.println(getSorted(arr));

        
    }
    
}

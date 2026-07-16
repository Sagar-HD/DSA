package topKFrequent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class KfrequentElements {
    static ArrayList<Integer> getKfrequent(int[] arr,int k){
        PriorityQueue<Pair<Integer,Integer>> minHeap=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair1.getValue(), pair2.getValue()));
        HashMap<Integer,Integer> freqMap=new HashMap<>();
        for(int i:arr){
          freqMap.put(i,freqMap.getOrDefault(i, 0)+1);
        }

        
        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            minHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ans.add(minHeap.poll().getKey());
            
        }
        return ans;


    }
    public static void main(String[] args) {
        int[] arr={1,2,2,3,3,3,3,1,1,2};
        int k=2;
        System.out.println(getKfrequent(arr, k));

        
    }
    
}

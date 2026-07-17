package topKFrequent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import javafx.util.Pair;

public class KfrequentWordsWithTieBreaker {
    static ArrayList<String> getFrequentWords(String[] words,int k){
        HashMap<String,Integer> freqMap=new HashMap<>();
        for(String word:words){
            freqMap.put(word,freqMap.getOrDefault(word, 0)+1);

        }
        PriorityQueue<Pair<String,Integer>> minHeap= new PriorityQueue<>((pair1,pair2)->{
            int cmp=Integer.compare(pair1.getValue(), pair2.getValue());
            if(cmp!=0){
                return cmp;
            }
            return pair2.getKey().compareTo(pair1.getKey());
        });

        for(Map.Entry<String,Integer> entry : freqMap.entrySet()){
            minHeap.add(new Pair<>(entry.getKey(), entry.getValue()));
            if(minHeap.size()>k){
                minHeap.poll();
            }
            
        }
        ArrayList<String> ans=new ArrayList<>();
        while(!minHeap.isEmpty()){
            ans.add(minHeap.poll().getKey());
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main(String[] args) {
        String[] words={ "i","love","leetcode","i","love","coding"};
        System.out.println(getFrequentWords(words, 2));

    }
    
}

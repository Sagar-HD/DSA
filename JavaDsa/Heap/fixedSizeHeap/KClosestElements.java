import java.util.ArrayList;

import java.util.PriorityQueue;

import javafx.util.Pair;


/**
 * KClosestElements
 */
public class KClosestElements {
    static ArrayList<Integer> getClosest(int num,int k,Integer[] arr){
        PriorityQueue<Pair<Integer,Integer>> maxHeap=new PriorityQueue<>((pair1,pair2)->Integer.compare(pair2.getKey(), pair1.getKey()));
        for(int n :arr){
            maxHeap.add(new Pair<>(Math.abs(num-n), n));
            if(maxHeap.size()>k){
            maxHeap.poll();
            }
        }
        ArrayList<Integer> ans=new ArrayList<>();
        while(!maxHeap.isEmpty()){
            ans.add(maxHeap.poll().getValue());

        }
        return ans;
    
    }

    public static void main(String[] args) {
            Integer[] arr={6,5,3,2,8,10,9};
            int k=3;
            int num=4;
            System.out.println(getClosest(num, k, arr));
    }
}
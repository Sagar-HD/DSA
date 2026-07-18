package Heap.twoHeaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOnlineQuery{
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianOnlineQuery() {
        this.minHeap=new PriorityQueue<>();
        this.maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        
    }
    
    public void addNum(int num) {
        if(maxHeap.size()==0){
            maxHeap.add(num);
            return;
        }

        if(num>maxHeap.peek()){
            minHeap.add(num);
        }
        else{
            maxHeap.add(num);
        }
        int minSize=minHeap.size();
        int maxSize=maxHeap.size();
        int balanceFactor=minSize-maxSize;
        if(balanceFactor>=0){
            if(balanceFactor>1){
                int rm=minHeap.poll();
                maxHeap.add(rm);
            }
        }
        else{
              if(balanceFactor<-1){
                int rm=maxHeap.poll();
                minHeap.add(rm);
            }

        }

        

        
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size()){
            double sum=minHeap.peek()+maxHeap.peek();
            return (sum)/2.0;

        }

        if(maxHeap.size()>minHeap.size()){
            return maxHeap.peek();
        }
        else{
           return minHeap.peek();
        }

        
    }
    public static void main(String[] args) {
        MedianOnlineQuery mq=new MedianOnlineQuery();
        mq.addNum(4);
        System.out.println(mq.findMedian());
        mq.addNum(9);
        mq.addNum(3);
         System.out.println(mq.findMedian());
         mq.addNum(6);
         mq.addNum(7);
         mq.addNum(1);
         System.out.println(mq.findMedian());
         //1 3 4 7 9 6
         
    }
}


package PrefixSum;

import java.util.HashMap;

public class SumEqualTokWithHashMap {
    //we can solve this using sliding window bcs we cant predict eindow behaviour by expanding or shrinking bcs we have negative values
    //the question is to find total sub arrays with sum=k
    //we can do brute force by 3 loops generating all sub array and find no of array sum=k O(n3)
    //we can calculate prefix sum of array but still need to find all starting and ending pairs using 2 loops O(n2)
    //we have another option
    //at every index of prefix sum we can calculate prefix needed to get the k 
    //we can have hashmap and keep on storing prefix sums and their frequencies
    //at every index of prefix sum if its equal to k just do count++ then calculate any prefix sum seen before make it as k, we know prefixsum(j)-prefixsum(i)=sum between them
    //now we need sum between them =k ; prefixsum(j)-prefixsum(i)=k //prefixsum(j) is the index we are standing in prefix sum
    //we need to find how many prefsum(i) exists so prefixsum(i)=prefixsum(j)-k
    //now we can count for all index in prefix sum
  static int countOfSubArray(int[] nums, int k){
    if(nums==null || nums.length==0){
        return 0;
    }
    int count=0;
    int[] prefixsum=new int[nums.length];
    prefixsum[0]=nums[0];
    for(int i=1;i<nums.length;i++){
        prefixsum[i]=prefixsum[i-1]+nums[i];
    }
    HashMap<Integer,Integer> map=new HashMap<>();
    for(int i=0;i<prefixsum.length;i++){
        int neededPrefSum=prefixsum[i]-k;
        if(prefixsum[i]==k){
            count++;
        }
        if(map.containsKey(neededPrefSum)){
            count+=map.get(neededPrefSum);
        }
        map.put(prefixsum[i],map.getOrDefault(prefixsum[i], 0)+1);
    }

    return count;
  }

    public static void main(String[] args) {
    
        
    }
    
}

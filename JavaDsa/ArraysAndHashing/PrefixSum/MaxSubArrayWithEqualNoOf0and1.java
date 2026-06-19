package PrefixSum;

import java.util.HashMap;

public class MaxSubArrayWithEqualNoOf0and1 {

    // this problem at first looks like sliding window
    // but we cant predict the window to shrink or expand
    // so its not sliding window
    // for prefix sum , we need count to be equal
    // so we make all 0s as -1 so when there is equal no of 0s and 1s it becomes 0
    // we need max length sub array
    // this is similar to count sub array sum =k
    // at any point in prefix we can check by formula previous sufix where we get
    // required condition
    // here prefix[j]=prefix[i] is condition bcs
    // now we need sum between them =0 ; prefixsum(j)-prefixsum(i)=0
    // prefixsum(j) is the index we are standing in prefix sum
    // prefixsum(j)-prefixsum(i)=0 ; ---> this becomes prefix[i] = prefix[j]
    // we need to maximixe the subarray length it happens only when we maintain first index where that sub array occured 
    //we maintain that using hashmap
    //we put 0 prefix is found at -1 index to map bcs when we encounter 1st 0 and 1st one we need to count that as length 2 soo we add that
     
    public static int findMaxLength(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                nums[i] = -1;
            }
        }
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int length = 0;
         //instead of looping again we can do this while calculating prefix sum only
        for (int i = 0; i < prefixSum.length; i++) {
            if (!map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], i);
            } else {
                int thisLength = i - map.get(prefixSum[i]);
                length = Math.max(length, thisLength);
            }
        }
        return length;

    }

    public static void main(String[] args) {

    }
}
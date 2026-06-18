package PrefixSum;

import java.util.HashMap;

public class BinarySubArraySumEqualToK {
    public static int numSubarraysWithSum(int[] nums, int goal) {
        int[] prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];

        }
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        freqMap.put(0, 1);
        int count = 0;
        for (int i = 0; i < prefixSum.length; i++) {

            int needed = prefixSum[i] - goal;
            if (freqMap.containsKey(needed)) {
                count += freqMap.get(needed);
            }
            freqMap.put(prefixSum[i], freqMap.getOrDefault(prefixSum[i], 0) + 1);

        }
        return count;
    }
    public static void main(String[] args) {
        
    }

}

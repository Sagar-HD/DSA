package BruteForceVsPrefixSumVsSlidingWindow;

import java.util.HashMap;

public class MaxLengthSubArrayWithSumEqualK {

    static int solveBruteForce(int[] arr, int target) {
        /*
         * so this is the the brute force approach
         * we just do loop for every starting point possible and every ending point
         * possible
         * we check if sub array sum=k in every sub array , then updates its length if
         * greater than max len until now
         * O(n3) time complexity
         * 
         */
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == target) {
                    // updating with array len which is j-i+1
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;

    }

    static int solveBruteForce2(int[] arr, int target) {
        /*
         * in this approach also we are finding all possible sub array
         * but we noticed why we need to calculate sum again from first which has same
         * starting point
         * this is imoportant only for all subarray with same starting pointing we are
         * mainating one sum varibale
         * for next sub array we can consider this only + currnt index
         * then updatimg sum=0 when the starting point changed
         * by this we can reduce one loop going all again back to same starting point to
         * calculate again
         * O(n2) time complexity
         * 
         */
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];

                if (sum == target) {
                    // updating with array len which is j-i+1
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    static int solveUsingPrefixSumAndHash(int[] arr, int target) {
        /*
         * Now comes our hero Prefix Sum.
         *
         * In brute force 1 we were recalculating sums again and again.
         * We fixed that in brute force 2.
         *
         * But even after that, we were still checking every possible
         * starting point for every ending point.
         *
         * So the next question we observed was:
         *
         * Can we calculate the sum of any subarray instantly
         * without traversing that subarray again?
         *
         * Prefix Sum solves this problem.
         *
         * If prefix[i] stores sum from index 0 to i,
         * it doesn't directly give every subarray sum,
         * but it gives sum from 0 to any index.
         *
         * Using this we can derive any subarray sum instantly.
         *
         * Suppose we want sum from start to end.
         *
         * prefix[end] contains:
         * sum(0...end)
         *
         * prefix[start-1] contains:
         * sum(0...start-1)
         *
         * So removing the second from the first leaves only:
         *
         * sum(start...end)
         *
         * Therefore:
         *
         * subarraySum = prefix[end] - prefix[start-1]
         *
         * Great. Now we can calculate any subarray sum in O(1).
         *
         * But there is still a problem.
         *
         * We still don't know WHICH starting index to choose.
         * We are still trying all possible starting points.
         *
         * Let's use the same formula:
         *
         * subarraySum = prefix[end] - prefix[start-1]
         *
         * We want:
         *
         * subarraySum = target
         *
         * Therefore:
         *
         * target = prefix[end] - prefix[start-1]
         *
         * Rearranging:
         *
         * prefix[start-1] = prefix[end] - target
         *
         * This is the key observation.
         *
         * While standing at current index 'end',
         * if we already know some previous index where
         * prefix sum = prefix[end] - target,
         * then the subarray between them must have sum = target.
         *
         * So instead of checking every starting point,
         * we only need to ask:
         *
         * "Have I seen prefix[end] - target before?"
         *
         * HashMap answers this question in O(1).
         *
         * We store prefix sums as we move.
         *
         * Whenever (currentPrefixSum - target) exists,
         * we found a valid subarray.
         *
         * To get maximum length,
         * we store the FIRST occurrence of every prefix sum,
         * because the earliest occurrence gives the longest distance.
         *
         * Thus we remove the need to check all starting points
         * and achieve O(n) time complexity.
         */

        int[] prefixSum = new int[arr.length];
        int maxLen = 0;

        // Hashmap of prefixSum-->index as key value
        HashMap<Integer, Integer> map = new HashMap<>();

        prefixSum[0] = arr[0];
        // add this also to map saving prefix sum and its index in map
        map.put(arr[0], 0);
        // if first elem prefix sum is target saving in len
        if (prefixSum[0] == target) {
            maxLen = 1;
        }

        // these 3 steps we did for 1st element we will do for rest of the elements
        // these 3 steps for first element would have included in loop if i had
        // calculated prefix sum first then iterate over it
        // iam just doing both together which is not necessary but i was experiment
        // while both give O(n) time complexity only
        // iterating again after calculating prefix sum is only recommended by me bcs it
        // handle first elemnt also in it
        /*
         * i recommend below approach
         * Another common implementation first builds the entire
         * prefix sum array and then processes it.
         *
         * Here I am building prefix sums and processing them
         * together in a single traversal.
         *
         * Both approaches have O(n) time complexity.
         */

        for (int i = 1; i < arr.length; i++) {

            prefixSum[i] = prefixSum[i - 1] + arr[i];

            // this condition when prefix sum of index is required target
            if (prefixSum[i] == target) {
                // 0 to i has required target
                maxLen = Math.max(i + 1, maxLen);
            } else {
                // else we calculate wt prefix sum we need that exits , by subtracting this
                // prefix sum for this index prefix sum we get target sum subarray
                // target=prefixSum[i]-neededprefixSum;
                // neededPrefixSum=prefixSum[i]-target; when we get neededprefix sum we can gets
                // its index by hashmap
                int neededPrefixSum = prefixSum[i] - target;
                if (map.containsKey(neededPrefixSum)) {
                    int len = i - map.get(neededPrefixSum);
                    maxLen = Math.max(maxLen, len);
                }

            }

            // adding this prefix sum to hashmap for future calculattions for all elements
            // note add this only if this doesnt exist in map bcs
            // we need first index where we have this prefix sum to maximize the len
            // We keep only the first occurrence of a prefix sum.
            // The earliest occurrence gives the maximum possible length.
            if (!map.containsKey(prefixSum[i])) {
                map.put(prefixSum[i], i);
            }

        }

        return maxLen;

    }

    static int solveUsingSlidingWindow(int[] arr, int target) {
        /*
         * this works when we have no negative in array
         * it works when window is predictable by expanding or shrinking window some
         * change consitently happens
         * 
         * in this method we wont remeber all history just keep on expanding and
         * shrinking window as per requirement
         * and only store the window value not whole history
         * by this space needed for prefix sum and hashmap is eleminated
         * this works only for positive numbers so we can predict window
         *
         *
         *
         *
         * 
         * If current sum < target,
         * expanding the window can only increase the sum.
         *
         * If current sum > target,
         * shrinking the window can only decrease the sum.
         *
         * Since we always know which direction to move,
         * we don't need Prefix Sum or HashMap anymore.
         *
         * We simply maintain a current window and its sum.
         *
         * If sum < target -> expand window.
         * If sum > target -> shrink window.
         * If sum == target -> update answer.
         *
         * In this method we do not remember the entire history.
         * We only keep track of the current window,
         * eliminating the extra space used by
         * Prefix Sum and HashMap.
         *
         * Every element enters and leaves the window
         * at most once.
         *
         * Time Complexity : O(n)
         * Space Complexity : O(1)
         *
         * Important:
         *
         * This works only because the window behaves
         * predictably.
         *
         * Negative numbers break this property.
         *
         * Expanding the window may decrease the sum,
         * and shrinking the window may increase the sum.
         *
         * In such cases we must go back to
         * Prefix Sum + HashMap.
         */
        int maxLen=Integer.MIN_VALUE;
        int start=0;
        int end=0;
        int sum=0;
        while(end<arr.length){
            //adding current element
             sum+=arr[end];
            
             //mainatining valid window
            while(start<=end&&sum>target){
             sum-=arr[start];
             start++;
            }
           
            
            //if window id required target update
            if(sum==target){
                int len=end-start+1;
                maxLen=Math.max(len, maxLen);
            }

            //moving end index to process next element
              end++;

        }


        return maxLen;

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 6, -4, 3, 1, 2, 3 };
        int target = 6;
        System.out.println(solveBruteForce(arr, target));
        System.out.println(solveBruteForce2(arr, target));
        System.out.println(solveUsingPrefixSumAndHash(arr, target));
        int[] positiveArray={1,5,3,6,4,2,1,3,1,1};
        System.out.println(solveUsingSlidingWindow(positiveArray, target));


    }

}

//Kadane solves a diffrent problem just added so that all patterns will be together
//kadane is all about thinking will previous sum help me or hurt me


/*
 * A related observation:
 *
 * In this problem we are searching for a subarray
 * whose sum equals a specific target.
 *
 * Because of this exact target requirement,
 * Prefix Sum + HashMap is needed.
 *
 * If the problem changes to:
 *
 * "Find the subarray with maximum sum"
 *
 * then we no longer care about a fixed target.
 *
 * We only care whether extending the current
 * subarray helps or hurts the answer.
 *
 * This observation leads to Kadane's Algorithm,
 * which solves Maximum Subarray Sum in O(n).
 *
 * Therefore:
 *
 * Sum == K              -> Prefix Sum + HashMap
 * Maximum Sum           -> Kadane
 * Positive array only   -> Sliding Window
 */
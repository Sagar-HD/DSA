package fixedSizeHeap;

import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class SumOfElementsBetweenK1SmallestAndK2Smallest {
    static int sumBetween(int[] arr, int k1, int k2) {
        int bound1 = getKthSmallest(arr, k1);
        int bound2 = getKthSmallest(arr, k2);
        int lowerBound = Math.min(bound1, bound2);
        int upperBound = Math.max(bound1, bound2);
        int sum = 0;
        for (int i : arr) {
            if (i > lowerBound && i < upperBound) {

                sum += i;
            }
        }
        return sum;
    }

    static int getKthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i : arr) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }

        }
        return maxHeap.poll();

    }

    public static void main(String[] args) {

        int[] arr = { 1, 3, 5, 11, 12, 15 };
        int k1 = 3;
        int k2 = 6;
        System.out.println(sumBetween(arr, k1, k2));

    }

}

import java.util.*;

public class minToMaxHeap{

    static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    static void minToMaxHeap(int[] arr) {
        int n = arr.length;

        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 8, 10, 12, 15, 20};
        minToMaxHeap(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
package Basic;

public class MinAbsoluteDifOfElem {
    static int getElemWithMinAbsoluteDif(int[] arr, int elem) {
        int start = 0;
        int end = arr.length - 1;
        int min = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == elem) {
                return arr[mid];
            } else if (elem < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        if (end < 0) {
            // floor doesnt exist
            return arr[start];

        }

        if (start >= arr.length) {
            // ceiling doesnt exist
            return arr[end];
        }

        // start is ceiling
        // end is floor
        if (Math.abs(elem - arr[start]) < Math.abs(elem - arr[end])) {

            return arr[start];
        }

        return arr[end];

    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 9, 13 };
        int elem = 6;
        System.out.println(getElemWithMinAbsoluteDif(arr, elem));

    }

}

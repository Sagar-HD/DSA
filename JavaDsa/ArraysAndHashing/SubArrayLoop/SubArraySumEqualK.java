package SubArrayLoop;

public class SubArraySumEqualK {
    // Optiaml to this is prefix sum
    public static void main(String[] args) {
        int[] arr = { 1, 2, -2, 3, 1, 3, 2 };
        int value = 3;
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                if (sum == value) {
                    count++;
                }

            }
        }
        System.out.println(count);

    }
}

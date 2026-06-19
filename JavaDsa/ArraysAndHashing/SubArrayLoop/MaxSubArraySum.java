package SubArrayLoop;

public class MaxSubArraySum {
    // optimal for this is kadanes algorithm
    public static void main(String[] args) {
        int[] arr = { 1, 2, -2, 3, 1, 3, 2 };
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                int sum = 0;

                for (int k = i; k <= j; k++) {
                    sum += arr[k];
                }
                maxSum = Math.max(maxSum, sum);

            }
        }
        System.out.println(maxSum);
        /*
        instead of calculating sum again from start at every index we can just add and find max
     
        
        */
       maxSum = Integer.MIN_VALUE;
          for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                

           
                    sum += arr[j];
           
                maxSum = Math.max(maxSum, sum);

            }
        }
        System.out.println(maxSum);



    }

}

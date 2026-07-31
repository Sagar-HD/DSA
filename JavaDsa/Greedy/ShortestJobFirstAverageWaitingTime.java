import java.util.Arrays;

public class ShortestJobFirstAverageWaitingTime {
    static int getMinAverageWaitingTime(int[] arr){
        Arrays.sort(arr);
        int timer=0;
        int sumOfWaitingTimes=0;
        for(int i : arr){
            //or else can store individual waiting time of all and sum later
            sumOfWaitingTimes+=timer;
            timer+=i;
          

        }
        return sumOfWaitingTimes/arr.length;


    }
    public static void main(String[] args) {
        int[] arr={5,3,2,9,4,1};
        System.out.println(getMinAverageWaitingTime(arr));

    }
    
}

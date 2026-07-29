package problems;
import java.util.*;
public class PrintPowerSet {
    static ArrayList<ArrayList<Integer>> getSubSets(int[] arr){

        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        int n=arr.length;
        int noOfSubsets=1<<n;  //2 power n

        // 0 to n-1 binary represnts exactly the bits of take and not take 
        //we just need to check bit and add if its one corresponsinf array element
        for(int i=0;i<noOfSubsets;i++){
            //j represent jth bit in binary from last and jth element in array
            ArrayList<Integer> subset=new ArrayList<>();
            for(int j=0;j<arr.length;j++){
                //creating bit mask 1<<j and doing and with i to check if 0 or any bigger number
                //observe first bit 1 means last elem in array included it may not be same index it doesnt matter
                //wt matters is the taking and not taking

                if((i & (1<<j)) != 0){
                    subset.add(arr[j]);

               }

            }
            ans.add(subset);


        }

  return ans;

    }
    public static void main(String[] args) {
        int[] arr={1,2,3};
        System.out.println(getSubSets(arr));
    }
    
}

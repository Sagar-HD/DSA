package PrefixSum;

import java.util.HashMap;
// analyse again
public class CountSubArraySumDivibleByk {
    static int count(int[] arr,int k){
        int count=0;
        int[] prefixSum=new int[arr.length];
        prefixSum[0]=arr[0];
        for(int i=1;i<arr.length;i++){
            prefixSum[i]=prefixSum[i-1]+arr[i];
        }
        //remainder-->frequency
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        //sum[j]-sum[i]%k==0  --> prefixSum[j]%k=prefixSum[i]%k

          for(int sum:prefixSum){

         int neededReminder=((sum % k) + k) % k;
         if(map.containsKey(neededReminder)){
            count+=map.get(neededReminder);
         }
         map.put(sum%k, map.getOrDefault(sum%k, 0)+1);


          }
       
    return count;
        //
    }
    public static void main(String[] args) {
        
    }
    
}

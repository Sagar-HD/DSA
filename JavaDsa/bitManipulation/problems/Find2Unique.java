package problems;

import java.util.ArrayList;

public class Find2Unique {
    static void display2UniqueNumbers(int[] arr){
        //first lets find 2 unique numbers 
        //as we xor all remaning is 2 unique numbers 
        int xor=0;
        for(int i :arr){
            xor^=i;
        }
        //now we have unique numbers remining thing is to seperate them 
        //now we find any one set bit in this xor and in same place we divide the whole array into 2 groups
        //ones which have 0 in that set bit place and others which have 1 in that set bit place 
        //set bit in xor means two unique numbers in that place bit was 0 , 1 
     
        int i=0;

        //now we can find any setbit but left find roghtmost set bit index bcs we have a trick xor & - xor gives mask of rightmost set bit

        int mask= xor & -xor;
        //now we got mask where right most bit is we can find its index 
        while (mask > 1) {
              mask >>= 1;
             i++;
          }
     
        //now we have set bit at ith place in xor 
        //now our work is to group all numbers into two side means the group of numbers same bit in that place as first unique number and second unique number
        ArrayList<Integer> groupOf0=new ArrayList<>();
        ArrayList<Integer> groupOf1=new ArrayList<>();
        for(int num :arr){

            if((num & (1 << i)) !=0 ){
                groupOf1.add(num);
            }
            else{
                groupOf0.add(num);
            }



        }
        //now as we have 2 groups just xor all in elements in both group among themself to get 2 integers 

        int unique1=0;
        for(int num : groupOf0){
            unique1^=num;

        }

        int unique2=0;
        for(int num : groupOf1){
            unique2^=num;

        }
        System.out.println(" unique 1 "+unique1);
        System.out.println("unique 2 :"+unique2);






    }
    public static void main(String[] args) {
        int[] arr={1,2,6,2,8,1,3,8};
        display2UniqueNumbers(arr);
    }
    
}

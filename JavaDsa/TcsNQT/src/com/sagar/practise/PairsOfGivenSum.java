package com.sagar.practise;

import java.util.HashSet;

public class PairsOfGivenSum {
    public static void main(String[] args) {
        int[] arr={1,5,3,2,4};
        int sum=6;
        HashSet<Integer> set=new HashSet<Integer>();
        for(int i:arr){
         if(set.contains(sum-i)){
             System.out.println(i+" + "+(sum-i));
         }
         set.add(i);
        }

    }
}

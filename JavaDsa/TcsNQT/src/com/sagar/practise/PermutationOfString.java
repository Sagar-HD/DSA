package com.sagar.practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationOfString {
    static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }
    static void permutationOfString(char[] arr, int i, List<String> result){
   if(i==arr.length){
       result.add(new String(arr));
       return;

   }
for(int j=i;j<arr.length;j++){
    swap(arr,i,j);
    permutationOfString(arr,i+1,result);
    swap(arr,i,j);
}
    }
    public static void main(String[] args) {
        String str = "abc";
        char[] arr = str.toCharArray();
        List<String> result = new ArrayList<>();
        permutationOfString(arr,0,result);
        System.out.println(result);



    }
}

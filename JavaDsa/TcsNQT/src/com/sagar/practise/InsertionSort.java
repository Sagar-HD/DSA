package com.sagar.practise;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={2,1,4,2,8,4};
        for(int i=1;i<arr.length;i++){
            for(int j=i-1;j>=0;j--){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for(int i:arr){
            System.out.print(i+" ");
        }
    }
}

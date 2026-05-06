package com.sagar.practise;

import java.util.Arrays;

public class CountOcurrenceOfWordInString {
    public static void main(String[] args) {
        String word="the";
        String sentence="the cat is sitting on the mat";
        String[] arr=sentence.split(" ");
        int count=0;
        for(String s:arr){
            if(s.equals(word)){
                count++;
            }
        }
        System.out.println(count);
    }
}

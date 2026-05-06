package com.sagar.practise;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateInString {
    public static void main(String[] args) {
        String str = "programming";
        StringBuilder sb = new StringBuilder();
        Set<Character> set = new HashSet<>();
        for(int i=0;i<str.length();i++){
            if(!set.contains(str.charAt(i))){
                set.add(str.charAt(i));
                sb.append(str.charAt(i));
            }
        }
        System.out.println(sb.toString());
    }
}

package com.sagar.practise;

import java.util.HashSet;
import java.util.Set;

public class LongestSubStringWithoutRepeatingChar {
    public static void main(String[] args) {
        String str = "abcabcbb";

        int count=0;

        int start = 0;
        int end = 0;
        Set<Character> set = new HashSet<>();
        while(end<str.length()){

          while(start<end && set.contains(str.charAt(end))){
              set.remove(str.charAt(start));
              start++;

          }
            set.add(str.charAt(end));


          if(end-start+1>count){
              count=end-start+1;
          }
            end++;

        }
        System.out.println(count);
    }
}

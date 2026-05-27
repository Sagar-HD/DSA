package LeetCode;
import java.util.*;
class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character,Integer> lower=new HashMap<>();
         HashMap<Character,Integer> upper=new HashMap<>();
         for(int i=0;i<word.length();i++){
            if(word.charAt(i)>='a' &&word.charAt(i)<='z'){
                lower.put(word.charAt(i),i);
            }
            else{
               Character ch = (char)(word.charAt(i) + 32);
                if(!upper.containsKey(ch)){
                upper.put(ch,i);
                }
            }
         }
         int count=0;
         for(Map.Entry<Character,Integer> entry : lower.entrySet()){
               Character ch=entry.getKey();
               if(upper.containsKey(ch)){
                if(upper.get(ch)>lower.get(ch)){
                    count++;
                }
               }
         }

        return count;
    }
}
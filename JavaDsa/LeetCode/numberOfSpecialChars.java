package LeetCode;


import java.util.*;

class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> lowerSet=new HashSet<>();
        HashSet<Character> upperSet=new HashSet<>();
        
        for(int i=0;i<word.length();i++)
        {
            Character letter=word.toLowerCase().charAt(i);
        if(letter==word.charAt(i)){
            lowerSet.add(word.charAt(i));
        }
        else{
            upperSet.add(letter);
        }
        
    }
    int count=0;
    for(Character alpha : lowerSet){
           if(upperSet.contains(alpha)){
            count=count+1;
           }
        
    }
    return count;
}
}
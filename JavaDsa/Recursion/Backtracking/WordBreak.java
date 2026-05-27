package Backtracking;


import java.util.ArrayList;
import java.util.HashSet;

public class WordBreak {
    static boolean isPossible(String sentence,HashSet<String> dict){
        if(sentence.isEmpty()){
            return true;
        }
        for(int i=0;i<sentence.length();i++){
            if(isPresent(sentence.substring(0,i+1), dict)){
                //dont return directly here bcs in firs wrong case only it gets return doesnt checks for all cases then 
                if(isPossible(sentence.substring(i+1), dict)){
                    return true;
                }
            }
        }
        // only return false after checking all possibilities
        return false;

    }
     static boolean isPossibleAndPrint(String sentence,HashSet<String> dict,ArrayList<String> ansSoFar){
        if(sentence.isEmpty()){
            System.out.println(ansSoFar);
            return true;
        }
        for(int i=0;i<sentence.length();i++){
            if(isPresent(sentence.substring(0,i+1), dict)){
                //dont return directly here bcs in firs wrong case only it gets return doesnt checks for all cases then 
                ansSoFar.add(sentence.substring(0,i+1));
                if(isPossibleAndPrint(sentence.substring(i+1), dict,ansSoFar)){
                    return true;
                }
                ansSoFar.remove(ansSoFar.size()-1);
            }
        }
        // only return false after checking all possibilities
        return false;

    }
    static boolean isPresent(String s,HashSet<String> dict){
        return dict.contains(s);
    }
    public static void main(String[] args) {
        String sentences="applepenapple";
        HashSet<String> dict=new HashSet<>();
        dict.add("apple");
        dict.add("pen");
        System.out.println(isPossible(sentences, dict));
        isPossibleAndPrint(sentences, dict, new ArrayList<>());
        //
        sentences="catsandog";
        dict.clear();
        dict.add("cats");
        dict.add("and");
        dict.add("sand");
        dict.add("dog");
        dict.add("cat");
        //at any point we do we dont all words as valid 
        //og is not there
          System.out.println(isPossible(sentences, dict));
            isPossibleAndPrint(sentences, dict, new ArrayList<>());
    }
}

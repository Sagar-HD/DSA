import java.util.*;

public class LongestNonRepeatingSubString{
    public static void main(String[] args) {
      String s="zxyzxyz";
      HashMap<Character,Integer> map=new HashMap<>();
      int start=0;
      int end=0;
      int max=0;
      int count=0;
      while(end<s.length()){
        
        if(map.containsKey(s.charAt(end))){
           start=Math.max(start,map.get(s.charAt(end))+1);
         map.put(s.charAt(end),end);
          end++;
          count=end-start;
          
          
          
        }else{
          map.put(s.charAt(end),end);
          end++;
          count=end-start;
          
        }
        if(count>max){
          max=count;
        }
      }
      System.out.println(max);
    }
}
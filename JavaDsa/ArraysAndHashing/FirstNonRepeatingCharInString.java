
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatingCharInString {
    static char firstNonRepating(String str){
        LinkedHashMap<Character,Integer> map=new LinkedHashMap<>();
        for(int i=0;i<str.length();i++){
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i), 0)+1);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()){
            if(entry.getValue()==1){
                return entry.getKey();
            }
        }
        return '@';
    }
    public static void main(String[] args) {
        String str="aacvbcs";
        System.out.println(firstNonRepating(str));
    }
    
}

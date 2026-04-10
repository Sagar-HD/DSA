import java.util.*;
class LongestSubStringWithoutRepeating{
	
	public static void main(String... args){
		String str="attachedtonothingconnecttoeverything";
		int start=0;
		int end=0;
		int max=Integer.MIN_VALUE;
		HashMap<Character,Integer> map=new HashMap<>();
		while(end<str.length()){
			
		
			
			if(map.containsKey(str.charAt(end))){
				
				start=Math.max(map.get(str.charAt(end)),start+1);
				
			}
			map.put(str.charAt(end),end);
			
			if(end-start+1>max){
				max=end-start+1;
			}
			
			end++;
		}
		System.out.println(max);
		
		
		
	}
}
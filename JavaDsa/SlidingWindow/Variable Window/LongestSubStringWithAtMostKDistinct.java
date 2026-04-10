import java.util.*;
class LongestSubStringWithAtMostKDistinct{
	public static void main(String... args){
		String str="attachedtonothingconnectedtoevrything";
		int start=0;
		int end=0;
		int k=4;
		int max=Integer.MIN_VALUE;
		HashMap<Character,Integer> map=new HashMap<>();
		while(end<str.length()){
			map.put(str.charAt(end),map.getOrDefault(str.charAt(end),0)+1);
			
			while(map.size()>k){
			 map.put(str.charAt(start),map.get(str.charAt(start))-1);
			 if(map.get(str.charAt(start))==0){
				 map.remove(str.charAt(start));
			 }
			 start++;
			}
			if(end-start+1>max){
				max=end-start+1;
			}
			
			
			
			end++;
		}
		System.out.println(max);
		
		
		
	}
	
	
	
	
	
}
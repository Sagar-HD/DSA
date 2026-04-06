import java.util.*;
class PermutationInString{
	static boolean find(String s2,String s1){
		
		HashMap<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s1.length();i++){
			if(map.containsKey(s1.charAt(i)))
			{
			map.put(s1.charAt(i),map.get(s1.charAt(i))+1);
			}
			else{
				map.put(s1.charAt(i),1);
			}
		}
		int ptr1=0;
		int ptr2=0;
		
		while(ptr2<s2.length()){
			if(ptr2-ptr1==s1.length()){
				return true;
			}
			if(map.containsKey(s2.charAt(ptr2)) && map.get(s2.charAt(ptr2))>0){
				
				
				map.put(s2.charAt(ptr2),map.get(s2.charAt(ptr2))-1);
				ptr2++;
				
				
				
			}
			else{
				
				ptr2++;
				ptr1=ptr2;
				
			}
			
			
		}
		return false;
		
	}
	public static void main(String... args){
		System.out.println(find("aaaabbbccc","abc"));
	}
}
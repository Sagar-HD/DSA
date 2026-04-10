import java.util.*;
class MinimumWindowSubString{
	
	public static void main(String... args){
		String s1="mamatatamaramat";
		String s2="ata";
		int start=0;
		int end=0;
		int k=s2.length();
		int max=Integer.MIN_VALUE;
		int[] freq=new int[26];
		int[] s2Freq=new int[26];
		for(int i=0;i<s2.length();i++){
			s2Freq[s2.charAt(i)-'a']++;
		}
		while(end<s1.length()){
			
			freq[s1.charAt(end)-'a']++;
			
			if(end-start+1<k){
				end++;
				
			}
			else{
				while(!Arrays.equals(freq,s2Freq)){
					
					freq[s1.charAt(start)-'a']--;
					start++;
					
				}
				if(end-start+1>max){
					max=end-start+1;
				}
				
				end++;
			}
			
			
		}
		System.out.println(max);
		
		
		
	}
	
	
}
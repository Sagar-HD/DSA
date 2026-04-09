import java.util.*;
class PrintAllAnagrams{
	
	static void print(String s1,String s2,int k){
		int[] freq=new int[26];
		int start=0;
		int end=0;
		int[] subFreq=new int[26];
		for(int i=0;i<s2.length();i++){
			subFreq[s2.charAt(i)-'a']++;
		}
		while(end<s1.length()){
			freq[s1.charAt(end)-'a']++;
			if(end-start+1<k){
				end++;
			}
			else{
				if(Arrays.equals(freq, subFreq)){
					for(int i=start;i<=end;i++){
						System.out.print(s1.charAt(i));
						
					}
					System.out.println();
				}
				freq[s1.charAt(start)-'a']--;
				
				start++;
				end++;
			}
		}
		
	}
	
	public static void main(String... args){
		
		String s1="mattamatmy";
		String s2="mat";
		int k=3;
		print(s1,s2,k);
		
		
		
		
	}
}
class LongestRepeatingCharacterReplacement{
	static int getMaxFreq(int[] arr){
		int maxFreq=Integer.MIN_VALUE;
	
		for(int i=0;i<arr.length;i++){
			if(arr[i]>maxFreq){
				maxFreq=arr[i];
				
			}
		}
		return maxFreq;
	}
	public static void main(String... args){
		String str="attachedtonothingconnectedtoevrything";
		int start=0;
		int end=0;
		int k=2;
		int max=Integer.MIN_VALUE;
		int[] freq=new int[26];
		while(end<str.length()){
			freq[str.charAt(end)-'a']++;
			
			int maxFreq=getMaxFreq(freq);
			while(start<end && (end-start+1)-maxFreq>k){
				freq[str.charAt(start)-'a']--;
				maxFreq=getMaxFreq(freq);
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
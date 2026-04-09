class CountOfVowelsInWindow{
	
	public static void main(String... args){
		String str="sagarisagoodboy";
		int k=5;
		int start=0;
		int end=0;
		int count=0;
		while(end<str.length()){
			
			if(str.charAt(end)=='a' ||str.charAt(end)=='e' ||str.charAt(end)=='i' ||str.charAt(end)=='o' ||str.charAt(end)=='u'  ){
				count++;
			}
			
			if(end-start+1<k){
				end++;
			}
			else{
				System.out.println(count);
				if(str.charAt(start)=='a' ||str.charAt(start)=='e' ||str.charAt(start)=='i' ||str.charAt(start)=='o' ||str.charAt(start)=='u'  ){
				count--;
			        }
				start++;
				end++;
			}
			
		}
	}
}
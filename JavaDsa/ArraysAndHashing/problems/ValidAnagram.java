import java.util.HashMap;
class ValidAnagram{
	static boolean isValid(String s1,String s2){
		if(s1.length()!=s2.length()) return false;
		int arr1[]=new int[26];
		int arr2[]=new int[26];
		for(int i=0;i<s1.length();i++){
			int index=(int)s1.charAt(i)-97;
			arr1[index]=arr1[index]+1;
		}
		for(int i=0;i<s2.length();i++){
			int index=(int)s2.charAt(i)-97;
			arr2[index]=arr2[index]+1;
		}
		for(int i=0;i<26;i++){
			if(arr1[i]!=arr2[i]){
				return false;
			}
		}
		
		return true;
		
	}
	
	
	public static void main(String... args){
		
		System.out.println(isValid("car","rac"));
			
		System.out.println(isValid("car","race"));
			
		System.out.println(isValid("car","mac"));
		
	}
	
	
}
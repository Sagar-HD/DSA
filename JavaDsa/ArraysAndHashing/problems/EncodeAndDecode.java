import java.util.*;
class EncodeAndDecode{
	
	static String encode(String[] arr){
		
		StringBuilder sb=new StringBuilder("");
		
		for(String s : arr){
			
			sb.append(s.length());
			sb.append('#');
			sb.append(s);
		}
		String ans=sb.toString();
		return ans;
	}
	
	static ArrayList<String> decode(String s){
		StringBuilder sb=new StringBuilder("");
		ArrayList<String> ans=new ArrayList<>();
		int i=0;
		while(i<s.length()){
			int j=i;
			while(s.charAt(j)!='#'){
				j++;
			}
			int len=Integer.parseInt(s.substring(i,j));
			j++;
			while(len>0){
				sb.append(s.charAt(j));
				j++;
				len--;
			}
			String str=sb.toString();
			ans.add(str);
			sb.setLength(0);
			i=j;
		}
		
	return ans;	
	}
	public static void main(String... args){
		String[] arr={"sagar","is","a"};
		System.out.println(decode(encode(arr)));
	}
	
	
}
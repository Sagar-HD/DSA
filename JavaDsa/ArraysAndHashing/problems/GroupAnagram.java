import java.util.HashMap;
import java.util.Map;
import java.util.*;
class GroupAnagram{
	static ArrayList<ArrayList<String>> group(String[] arr){
		ArrayList<ArrayList<String>> ans=new ArrayList<>();
		HashMap<String,ArrayList<String>> map=new HashMap<>();
		for(String str:arr){
			int arr1[]=new int[26];
			for(int i=0;i<str.length();i++){
				
				int index=str.charAt(i)-97;
				arr1[index]=arr1[index]+1;
				
			}
			StringBuilder key=new StringBuilder("");
			for(int i=0;i<26;i++){
				key.append(arr1[i]);
				key.append('#');
			}
			String keyString=key.toString();
			if(map.containsKey(keyString)){
				map.get(keyString).add(str);
			}
			else{
				ArrayList<String> list=new ArrayList<>();
				list.add(str);
				map.put(keyString,list);
			}
		}
		for (Map.Entry<String,ArrayList<String>> entry : map.entrySet()) {
    String key = entry.getKey();
    ArrayList<String> value = entry.getValue();
	ans.add(value);
	
   
}
return ans;
	}
	
	public static void main(String... args){
		String[] arr={"mat","sag","ram","gas","tam"};
		 ArrayList<ArrayList<String>> ans=group(arr);
		 for(ArrayList arr1:ans){
			 System.out.println(arr1);
		 }
		
	}
}
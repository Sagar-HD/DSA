import java.util.*;

class TopKFrequent{
	
	static ArrayList<Integer> findTopK(int arr[],int k){
		HashMap<Integer,Integer> map=new HashMap<>();
		
		for(int i : arr){
			if(map.containsKey(i)){
				map.put(i,map.get(i)+1);
			}
			else{
				map.put(i,1);
			}
		}
		ArrayList<Map.Entry<Integer,Integer>> list=new ArrayList<>(map.entrySet());
		list.sort((a,b)->{
			return b.getValue().compareTo(a.getValue()
		);});
		ArrayList<Integer> ans=new ArrayList<>();
		int i=0;
		while(k>0){
			
			ans.add(list.get(i).getKey());
			i++;
			k--;
		}
		
		return ans;
		
	}
	
	
	
	public static void main(String... args){
		int arr[]={1,2,2,6,6,6,7,7,7,7,7};
		ArrayList<Integer> ans=findTopK(arr,2);
		for(Integer val : ans){
			System.out.println(val);
		}
		
	}
	
	
}
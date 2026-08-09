import java.util.*;

class LongestCommonSequence{
	static int find(int[] arr){
		HashMap<Integer,Integer> map=new HashMap<>();
		for(int i=0;i<arr.length;i++){
			map.put(arr[i],i);
		}
		int max=0;
		for(Map.Entry<Integer,Integer> entry : map.entrySet()){
			int count=0;
			if(!map.containsKey(entry.getKey()-1)){
				int key=entry.getKey();
				while(map.containsKey(key)){
					count++;
					key++;
				}
				if(count>max){
					max=count;
				}
				count=0;
			}
		}
		return max;
		
	}
	public static void main(String... args){
		int arr[]={1,5,7,9,8,2,4,3};
		System.out.println(find(arr));
	}
}
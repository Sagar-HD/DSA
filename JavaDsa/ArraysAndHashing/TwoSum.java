import java.util.HashMap;
import java.util.Map;
class TwoSum{
	static int[] twoSumSorted(int arr[],int target){
		int p1=0;
		int p2=arr.length-1;
		int ans[]={-1,-1};
		while(p1<p2){
			if(arr[p1]+arr[p2]==target){
				ans[0]=p1;
				ans[1]=p2;
				return ans;
			}
			else if(arr[p1]+arr[p2]>target){
				p2--;
			}
			else{
				p1++;
			}
		}
		
		return ans;
	}
	static int[] twoSumUnSorted(int arr[],int target){
		HashMap<Integer,Integer> map=new HashMap<>();
		int ans[]={-1,-1};
		for(int i=0;i<arr.length;i++){
			int needed=target-arr[i];
			if(map.containsKey(needed)){
				ans[0]=(int)map.get(needed);
				ans[1]=i;
				return ans;
			}
			else{
				map.put(arr[i],i);
			}
		}
		return ans;
	}
	
	public static void main(String... args){
		int arr[]={1,2,3,8,9};
		int[] ans=twoSumSorted(arr,10);
		for(int i:ans){
			System.out.println(i);
		}
	  int arr1[]={1,8,3,2,7};
		 ans=twoSumUnSorted(arr1,10);
		for(int i:ans){
			System.out.println(i);
		}
	}
}
class ThreeSum{
	static boolean find3Sum(int arr[],int target){
		for(int i=0;i<arr.length;i++){
			int p1=i+1;
			int p2=arr.length-1;
			int needed=target-arr[i];
			while(p1<p2){
				if(arr[p1]+arr[p2]==needed){
					
					System.out.println("values :"+arr[i]+" "+arr[p1]+" "+arr[p2]);
					return true;
				}
				else if(arr[p1]+arr[p2]<needed){
					p1++;
				}
				else{
					p2--;
				}
			}
		}
		System.out.println("values not found");
		return false;
	}
	
	
	
	public static void main(String... args){
		int arr[]={1,4,6,8,2};
		int target=12;
		find3Sum(arr,target);
		
		
		
		
		
		
	}
	
	
}
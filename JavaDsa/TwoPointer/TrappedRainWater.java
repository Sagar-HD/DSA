class TrappedRainWater{
	static int getWater(int arr[]){
		int maxHeight=0;
		int maxWater=0;
		for(int i=0;i<arr.length;i++){
			if(arr[i]>arr[maxHeight]){
				maxHeight=i;
			}
		}
		int leftMax=arr[0];
		for(int i=1;i<maxHeight;i++){
			if(arr[i]>leftMax){
				leftMax=arr[i];
			}
			maxWater+=leftMax-arr[i];
			
		}
		int rightMax=arr[arr.length-1];
		for(int i=arr.length-2;i>maxHeight;i--){
			if(arr[i]>rightMax){
				rightMax=arr[i];
			}
			maxWater+=rightMax-arr[i];
		}
		return maxWater;
	}
	public static void main(String... args){
		int[] height = {0,2,0,3,1,0,1,3,2,1};
		System.out.println(getWater(height));
	}
	
	
	
}
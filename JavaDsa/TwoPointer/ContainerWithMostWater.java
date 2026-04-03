class ContainerWithMostWater{
	
	static void findMax(int arr[]){
		int p1=0;
		int p2=arr.length-1;
		int maxArea=0;
		while(p1<p2){
			int minHeight;
			if(arr[p1]>arr[p2]){
				minHeight=arr[p2];
				
			}
			else{
				minHeight=arr[p1];
			}
			int area=(p2-p1)*minHeight;
			if(area>maxArea){
				maxArea=area;
			}
			
			if(arr[p1]<arr[p2]){
				p1++;
			}
			else if(arr[p1]>arr[p2]){
				p2--;
			}
			else{
				p1++;
				p2--;
			}
			
			
			
		}
		System.out.println("max area: "+maxArea);
		
	}
	
	public static void main(String... args){
		int arr[]={1,4,3,5,7};
		findMax(arr);
		
	}
	
	
	
}
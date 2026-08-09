class ProductOfArrayExceptSelf{
	static int[] find(int arr[]){
		int prefProd[]=new int[arr.length];
		int sufProd[]=new int[arr.length];
		int prod=1;
		for(int i=0;i<arr.length;i++){
			prefProd[i]=prod;
			prod*=arr[i];
		}
		prod=1;
		for(int i=arr.length-1;i>=0;i--){
			sufProd[i]=prod;
			prod*=arr[i];
		}
		int ans[]=new int[arr.length];
		for(int i=0;i<arr.length;i++){
			ans[i]=prefProd[i]*sufProd[i];
		}
		return ans;
	}
	public static void main(String... args){
		int arr[]={1,2,3,4,5};
		int ans[]=find(arr)	;
		for(int i : ans){
			System.out.println(i);
		}
	}
	
}
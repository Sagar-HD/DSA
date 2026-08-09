import java.util.Map;
import java.util.HashMap;
class ContainsDuplicate{
    static boolean containsDuplicate(int[] arr){
int i=0;
     while(i<arr.length){
         int count=0;
         while(i<arr.length-1 && arr[i]==arr[i+1]){
         i++;
         count++;

         }
         if(count>0) return true;
        i++;
     }
     return false;
     }
	 static boolean containsDuplicateUnsorted(int arr[]){
		 Map<Integer,Integer> map=new HashMap<Integer,Integer>();
		 for(int elem:arr){
			 if(map.containsKey(elem)){
				 return true;
			 }
			 else{
				 map.put(elem,1);
			 }
		 }
		 return false;
	 }
	 
	 
	 
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        System.out.println(containsDuplicate(arr));
       System.out.println(containsDuplicateUnsorted(arr));
    }
}
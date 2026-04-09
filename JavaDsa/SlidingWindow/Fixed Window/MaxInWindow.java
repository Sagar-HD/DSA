import java.util.*;
class MaxInWindow{
	
	public static void main(String... args){
		int[] arr={1,2,4,8,1,3,5};
		int k=3;
		int start=0;
		int end=0;
		Deque<Integer> dq = new ArrayDeque<>();
		while(end<arr.length){
			if(dq.isEmpty()){
				dq.offerLast(end);
			}
			else{
				while(!dq.isEmpty() && arr[dq.peekLast()]<arr[end]){
					dq.pollLast();
					
				}
				dq.offerLast(end);
			}
			
			if(end-start+1<k){
				end++;
			}
			else{
				System.out.println("the max : "+arr[dq.peekFirst()]);
				if(dq.peekFirst()==start){
					dq.pollFirst();
				}
				start++;
				end++;
				
			}
			
		}
	}
	
	
}
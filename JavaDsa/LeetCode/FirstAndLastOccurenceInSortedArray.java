class Solution {
  
    public int[] searchRange(int[] nums, int target) {
        int[] ans=new int[2];
        int first=-1;
        int last=-1;
       for(int i=0;i<nums.length;i++){
        if(nums[i]==target){
            if(first==-1){
                first=i;
                last=i;
            }
            else{
                last=i;
            }
        }
       }
       ans[0]=first;
       ans[1]=last;
        return ans;

        
    }
}
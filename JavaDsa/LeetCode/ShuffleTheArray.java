package LeetCode;

class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int j=0;
        int k=n;
        for(int i=0;i<nums.length;i++){
         if(i%2==0){
     ans[i]=nums[j];
     j++;
         }
         else{
ans[i]=nums[k];
k++;
         }
        }
        return ans;
    }
}
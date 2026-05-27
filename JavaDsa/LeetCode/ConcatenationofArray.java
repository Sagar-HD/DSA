package LeetCode;
class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] ans=new int[nums.length*2];
        int j=0;
        for(int i:nums){
ans[j]=i;
j++;
        }
         for(int i:nums){
ans[j]=i;
j++;
        }
        return ans;
    }
}
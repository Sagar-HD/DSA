class Solution {
    
    static List<List<Integer>> helper(int[] nums, int index, ArrayList<Integer> sub){
       
        if(index==nums.length){
            List<List<Integer>> ans=new  ArrayList<>();

            ans.add(new ArrayList<>(sub));
            return ans;
            
        }
        sub.add(nums[index]);
         List<List<Integer>> returnedIncludedAns=helper(nums,index+1,sub);
        sub.remove(sub.size()-1);
        List<List<Integer>> returnedExcludeddAns = helper(nums,index+1,sub);
        returnedIncludedAns.addAll(returnedExcludeddAns);
        return  returnedIncludedAns;
        
        
    }
    public List<List<Integer>> subsets(int[] nums) {
       
        ArrayList<Integer> sub=new ArrayList<>();
        return helper(nums,0,sub);
       
    }
}
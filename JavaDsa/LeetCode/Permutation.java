class Solution {

    public List<List<Integer>> getPerm(int[] nums, int index) {
        List<List<Integer>> ans = new ArrayList<>();

        if (index == nums.length) {
            List<Integer> perm = new ArrayList<>();
            for (int num : nums) {
                perm.add(num);
            }
            ans.add(perm);
            return ans;
        }

        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);

            ans.addAll(getPerm(nums, index + 1));

            swap(nums, index, i); // backtrack
        }

        return ans;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public List<List<Integer>> permute(int[] nums) {
        return getPerm(nums, 0);
    }
}
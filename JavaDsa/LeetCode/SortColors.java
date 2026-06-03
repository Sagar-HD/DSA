class Solution {
public:
    
    void sortColors(vector<int>& nums) {
        int left=0;
        int right=nums.size()-1;
        int scan=0;
        while(scan<=right){
            if(nums[scan]==0){
int temp=nums[left];
nums[left]=nums[scan];
nums[scan]=temp;
scan++;
left++;
            }
            else if(nums[scan]==1){
                scan++;
            }
            else{
              int temp=nums[right];
nums[right]=nums[scan];
nums[scan]=temp;

right--;  
            }
        }
    }
};
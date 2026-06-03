class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int ptr1=0;
        int ptr2=numbers.size()-1;
        vector<int> ans;
        while(ptr1<ptr2){
       if(numbers[ptr1]+numbers[ptr2]==target){
ans.push_back(ptr1+1);
ans.push_back(ptr2+1);
return ans;
       }
       else if(numbers[ptr1]+numbers[ptr2]>target){
        ptr2--;

       }
       else{
        ptr1++;
       }


        }
        return ans;
    }
};
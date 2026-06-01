class Solution {
public:
    int addDigits(int num) {
        while(num>=10){
            int ans=0;
            while(num!=0){
                int digit=num%10;
                ans+=digit;
                num/=10;
            }
            num=ans;
        }

        return num;
    }
};
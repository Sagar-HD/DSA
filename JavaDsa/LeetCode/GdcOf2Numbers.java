class Solution {
    public int findGCD(int[] nums) {
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int gcd=1;
        for(int num:nums){
            min=Math.min(min,num);
            max=Math.max(max,num);
        }
        int a=min;
        int b=max;

       while(b!=0){
        int temp=b;
        b=a%b;
        a=temp;
       }
        return a;
    }
}
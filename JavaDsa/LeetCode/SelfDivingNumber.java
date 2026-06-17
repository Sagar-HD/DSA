class Solution {
    public boolean isSelfD(int num){
      int copy=num;
        while(copy>0){
            int digit=copy%10;
            if(digit==0){
                return false;
            }
            if(num%digit!=0){
                return false;
            }
            copy=copy/10;

        }

        return true;

    }
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> ans=new ArrayList<>();
        for(int i=left;i<=right;i++){
            if(isSelfD(i)){
                ans.add(i);
            }

        }
        return ans;
        
    }
}
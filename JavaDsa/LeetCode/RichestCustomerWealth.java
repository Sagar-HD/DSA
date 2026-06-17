class Solution {
    public int maximumWealth(int[][] accounts) {
        Integer max=Integer.MIN_VALUE;
        int wealth=0;
        for(int i=0;i<accounts.length;i++){
            for(int j=0;j<accounts[i].length;j++){
                wealth+=accounts[i][j];
            }
            max=Math.max(max,wealth);
            wealth=0;
        }
        return max;
        
    }
}
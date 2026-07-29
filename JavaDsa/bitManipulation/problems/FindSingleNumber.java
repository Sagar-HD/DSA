package problems;

public class FindSingleNumber {
    static int getSingleNumber(int[] nums){
        int num=0;
        for(int i:nums){
            num^=i;
        }
        return num;
    }
    public static void main(String[] args) {
        int[] nums={1,3,7,5,3,7,1};
        System.out.println(getSingleNumber(nums));
    }
    
}

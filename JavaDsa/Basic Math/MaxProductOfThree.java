public class MaxProductOfThree{
    public static int maximumProduct(int[] nums) {
         int firstMax=Integer.MIN_VALUE;
         int firstMaxIndex=-1;
         int secondMax=Integer.MIN_VALUE;
          int secondMaxIndex=-1;
         int thirdMax=Integer.MIN_VALUE;
         int firstMin=Integer.MAX_VALUE;
         int firstMinIndex=-1;
         int secondMin=Integer.MAX_VALUE;
         for(int i=0;i<nums.length;i++){

            if(nums[i]>firstMax){
                firstMax=nums[i];
                firstMaxIndex=i;


            }

              if(nums[i]<firstMin){
                firstMin=nums[i];
                firstMinIndex=i;

            }
         }
         for(int i=0;i<nums.length;i++){
            if(i!=firstMaxIndex){

              if(nums[i]>secondMax){
                secondMax=nums[i];
                secondMaxIndex=i;
            }

            }
            if(i!=firstMinIndex){
             if(nums[i]<secondMin){
                secondMin=nums[i];
              
            }
            }
         }
          for(int i=0;i<nums.length;i++){
            if(i!=firstMaxIndex && i!=secondMaxIndex){
            thirdMax=Math.max(nums[i],thirdMax);
            }
          
         }
         return Math.max((firstMax*secondMax*thirdMax),(firstMin*secondMin*firstMax));


        
    }
    public static void main(String[] args) {
        int[] nums={-1,-2,-3};
        System.out.println(maximumProduct(nums));
        
    }
}